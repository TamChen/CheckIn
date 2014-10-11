package com.csust.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.Region;
import org.apache.struts2.ServletActionContext;

import cn.com.util.EncodeUtil;

import com.csust.entity.Attend;
import com.csust.entity.DayData;
import com.csust.entity.User;
import com.csust.service.ChartService;
import com.csust.service.DataService;
import com.csust.service.UserService;
public class ExportReportAction {
	public UserService userService;
	public ChartService chartService;
	public DataService dataService;
	private String export;
	private String username;
	private String inputPath;

	public String downloadExcel() throws IOException {
		User user=new User();
		DayData dayData=new DayData();
		List<List<String>> totalList=new ArrayList<List<String>>();
		HttpServletRequest request = ServletActionContext.getRequest();
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Attend> attendList=new ArrayList<Attend>();
		Date date=new Date(timestamp.getTime());
	 	String fileName="";
	    //创建文件夹和文件
	    String path = ExportReportAction.class.getResource("").getPath();
		   path = path.substring(0,path.indexOf("/WEB-INF"));
		   System.out.println(path);
		   File file=new File(path+"/downloadReport");
		   if(!file.exists()){
			   file.mkdirs();
		   }
		//第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
        String realpath = ServletActionContext.getServletContext().getRealPath("/downloadReport");
        if(export.equals("personal")){
        	System.out.println(EncodeUtil.transferISO8859ToUTF8(username));
        	username=EncodeUtil.transferISO8859ToUTF8(username);
        	System.out.println(session.getAttribute("username"));
        	fileName=date+".xls"; // 
        	List<User> userlList=userService.getUserByName(username);
    		//第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
    		HSSFSheet sheet = wb.createSheet(username+"签到详细信息");
	        //第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
	        //设置单元格的行高宽度大小
	        sheet.setDefaultRowHeightInPoints(20);    
	        sheet.setDefaultColumnWidth((short) 20);    
	        HSSFRow row0 = sheet.createRow((int)0);
	        HSSFRow row1 = sheet.createRow((int)1);
	        HSSFRow row = sheet.createRow((int)2);
	//  		第四步，创建单元格，并设置值表头  设置表头居中
	        HSSFCellStyle style = wb.createCellStyle();
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //创建一个居中格式
	        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	        HSSFCell cell01 = row0.createCell(0);
          String title=username+"签到详细信息"+"(导出时间"+new Timestamp(System.currentTimeMillis()).toString()+")";
  	      cell01.setCellValue(title);cell01.setCellStyle(style);
  	      sheet.addMergedRegion(new Region(0, (short) 0, 1, (short) 4));
          HSSFCell cell = row.createCell((int)0);
          cell.setCellValue("实验室平均时长"); cell.setCellStyle(style);
          cell = row.createCell((int)1);
          cell.setCellValue("该天到勤率"); cell.setCellStyle(style);
          cell = row.createCell((int)2);
          cell.setCellValue("学习时长"); cell.setCellStyle(style);
          cell = row.createCell((int)3);
          cell.setCellValue("空闲时长"); cell.setCellStyle(style);        
          cell = row.createCell((int)4);
          cell.setCellValue("日期"); cell.setCellStyle(style);
          System.out.println(username);
          user=userlList.get(0);
  		  attendList=chartService.getPersonDate(user.getUserno());
  		//第五步，创建单元格，并设置值
  		  for (int i = 0; i < attendList.size(); i++) {
  			  	Attend attend=attendList.get(i);
	  			Date recordTime=attend.getRecordtime();
	  			System.out.println(recordTime);
				dayData=dataService.getThatData(recordTime);
				System.out.println(dayData.getEvertime());
	  			row = sheet.createRow((int)i+3);
	  			cell01=row.createCell((int)0);
	            cell01.setCellValue(dayData.getEvertime().toString());
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)1);
	            cell01.setCellValue(dayData.getRate().toString());
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)2);
	            cell01.setCellValue(attend.getWorktime().toString());
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)3);
	            cell01.setCellValue(attend.getFreetime().toString());
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)4);
	            cell01.setCellValue(recordTime.toString());
	            cell01.setCellStyle(style);
		}
        }
        if(export.equals("allinfo")){
        	fileName=date+".xls"; // 
        	List<User> userList=userService.findAll();
    		//第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
    		HSSFSheet sheet = wb.createSheet("所有签到详细信息");
	        //第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
	        //设置单元格的行高宽度大小
	        sheet.setDefaultRowHeightInPoints(20);    
	        sheet.setDefaultColumnWidth((short) 20);    
	        HSSFRow row0 = sheet.createRow((int)0);
	        HSSFRow row1 = sheet.createRow((int)1);
	        HSSFRow row = sheet.createRow((int)2);
	//  		第四步，创建单元格，并设置值表头  设置表头居中
	        HSSFCellStyle style = wb.createCellStyle();
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //创建一个居中格式
	        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	        HSSFCell cell01 = row0.createCell(0);
          String title="所有签到详细信息"+"(导出时间"+new Timestamp(System.currentTimeMillis()).toString()+")";
  	      cell01.setCellValue(title);cell01.setCellStyle(style);
  	      sheet.addMergedRegion(new Region(0, (short) 0, 1, (short) 4));
          HSSFCell cell = row.createCell((int)0);
          cell.setCellValue("用户名"); cell.setCellStyle(style);
          cell = row.createCell((int)1);
          cell.setCellValue("学号"); cell.setCellStyle(style);
          cell = row.createCell((int)2);
          cell.setCellValue("在线总时长"); cell.setCellStyle(style);
          cell = row.createCell((int)3);
          cell.setCellValue("在线次数"); cell.setCellStyle(style);        
          cell = row.createCell((int)4);
          cell.setCellValue("到勤率"); cell.setCellStyle(style);
  		//第五步，创建单元格，并设置值
  		  for (int i = 0; i < userList.size(); i++) {
  			  	user=userList.get(i);
	  			row = sheet.createRow((int)i+3);
	  			cell01=row.createCell((int)0);
	            cell01.setCellValue(user.getUsername().toString());
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)1);
	            cell01.setCellValue(String.valueOf(user.getUserno()));
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)2);
	            cell01.setCellValue(user.getActivetime());
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)3);
	            cell01.setCellValue(String.valueOf(user.getTime()));
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)4);
	            cell01.setCellValue("0");
	            cell01.setCellStyle(style);
        }}
        if(export.equals("everyday")){
        	fileName=date+".xls"; // 
        	List<DayData> dayDataList=new ArrayList<DayData>();
    		//第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
    		HSSFSheet sheet = wb.createSheet("每天签到详细信息");
	        //第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
	        //设置单元格的行高宽度大小
	        sheet.setDefaultRowHeightInPoints(20);    
	        sheet.setDefaultColumnWidth((short) 20);    
	        HSSFRow row0 = sheet.createRow((int)0);
	        HSSFRow row1 = sheet.createRow((int)1);
	        HSSFRow row = sheet.createRow((int)2);
	//  		第四步，创建单元格，并设置值表头  设置表头居中
	        HSSFCellStyle style = wb.createCellStyle();
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //创建一个居中格式
	        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	        HSSFCell cell01 = row0.createCell(0);
          String title="每天签到详细信息"+"(导出时间"+new Timestamp(System.currentTimeMillis()).toString()+")";
  	      cell01.setCellValue(title);cell01.setCellStyle(style);
  	      sheet.addMergedRegion(new Region(0, (short) 0, 1, (short) 5));
          HSSFCell cell = row.createCell((int)0);
          cell.setCellValue("平均在线时长"); cell.setCellStyle(style);
          cell = row.createCell((int)1);
          cell.setCellValue("到勤率"); cell.setCellStyle(style);
          cell = row.createCell((int)2);
          cell.setCellValue("在线人数"); cell.setCellStyle(style);
          cell = row.createCell((int)3);
          cell.setCellValue("时间最长"); cell.setCellStyle(style);        
          cell = row.createCell((int)4);
          cell.setCellValue("评级"); cell.setCellStyle(style);
          cell = row.createCell((int)5);
          cell.setCellValue("日期"); cell.setCellStyle(style);
  		//第五步，创建单元格，并设置值
          dayDataList=dataService.findAll();
  		  for (int i = 0; i < dayDataList.size(); i++) {
  			  	DayData daydate=dayDataList.get(i);
	  			row = sheet.createRow((int)i+3);
	  			cell01=row.createCell((int)0);
	            cell01.setCellValue(daydate.getEvertime().toString());
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)1);
	            cell01.setCellValue(daydate.getRate().toString());
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)2);
	            cell01.setCellValue(String.valueOf(daydate.getNumber()));
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)3);
	            cell01.setCellValue(daydate.getLongest());
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)4);
	            cell01.setCellValue(chartService.getRateRank());
	            cell01.setCellStyle(style);
	            cell01=row.createCell((int)5);
	            cell01.setCellValue(daydate.getRecordtime().toString());
	            cell01.setCellStyle(style);
        }}

        //第六步，将文件存到指定位置
        try {
        	File file01=new File(realpath+"/"+fileName);
        	if (!file01.exists()) {
        	       file01.createNewFile();
        	       System.err.println(file01 + "已创建！");
        	}
            FileOutputStream fout = new FileOutputStream(realpath+"/"+fileName);
            System.out.println(realpath);
            inputPath = "downloadReport"+"/"+fileName;
            wb.write(fout);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    	HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(fileName);
		System.out.println(request.getContextPath());
		
		inputPath=request.getContextPath()+"/downloadAction.action?inputPath="+inputPath;
		System.out.println(inputPath);
		out.print(inputPath);
		out.flush();        
        return null;
	}
	public InputStream getTargetFile() throws Exception {
		System.out.println("getTargetFile方法调用！！！"+inputPath);
		System.out.println("文件流为："+ServletActionContext.getServletContext().getResourceAsStream(inputPath));
    	return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
		//return is;
    }	
	public String download(){
		return "success";
	}
	public String getExport() {
		return export;
	}
	public void setExport(String export) {
		this.export = export;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setChartService(ChartService chartService) {
		this.chartService = chartService;
	}
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getInputPath() {
		return inputPath;
	}
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
}