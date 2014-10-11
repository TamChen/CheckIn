package com.csust.service;

import java.util.List;

import com.csust.entity.News;
import com.csust.entity.Rss;


public interface ClientService {

	List<News> findPersonal(String username);

	List<Rss> findRssByUsername(String username);

	List<News> findCollectByUsername(String username);

	News getNewsById(Integer newsid);

}
