package com.csust.dao.impl;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csust.entity.News;
import com.csust.service.ChartService;
import com.csust.service.ClientService;
import com.csust.service.DataService;

public class SubjectDAOTest {

	ApplicationContext ctx = null;
	private List<String> lists = new ArrayList<String>();
	private ClientService clientService;
	@Before
	public void before(){
		 ctx = new ClassPathXmlApplicationContext("app*.xml");
		 clientService=(ClientService) ctx.getBean("clientService");
		
		 System.out.println("@Before");
	}
	
	@Test
	public void findPersonal(){
		
		
		List<News> u =clientService.findPersonal("陈六");
		System.out.println(u);
		
	}
}
