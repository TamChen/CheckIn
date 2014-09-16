package com.csust.dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.csust.entity.Attend;
import com.csust.entity.DayData;
import com.csust.entity.News;
import com.csust.entity.Rss;
import com.csust.entity.RssUser;


public interface ClientDAO {

	List<News> findPersonal(String username);

	List<Rss> findRssByUsername(String username);


	News findNewById(Integer newsid);



}
