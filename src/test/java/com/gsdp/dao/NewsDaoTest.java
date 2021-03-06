package com.gsdp.dao;

import javax.annotation.Resource;

import com.gsdp.enums.news.NewsStatusInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsdp.entity.user.News;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class NewsDaoTest {

	@Resource(name = "newsDao")
	private NewsDao newsDao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testAddNews() {
		String newsTitle = "吃饭了吗?";
		String newsContent = "我反正吃了。";
		int toAddress = 2;
		String sendTime = "2016-10-27";
		int statue = 0;
		News news = new News(newsTitle, newsContent, toAddress, sendTime, statue);
		int affectRows = newsDao.addNews(news);
		logger.info("影响的行数:" + affectRows + "自增的id:" + news.getNewsId());
	}
	
	@Test
	public void testDeleteNews() {
		int newsId = 2;
		int affectRows = newsDao.deleteNews(newsId);
		logger.info("影响的行数:" + affectRows);
	}
	
	@Test
	public void testChangeNewsStatue() {
		int statue = 1;
		int newsId = 70;
		int affectRows = newsDao.changeNewsStatue(statue, newsId);
		logger.info("影响的行数:" + affectRows);
	}

	@Test
	public void batchAddNews() throws Exception {
		News news1 = new News(NewsStatusInfo.SYSTEM_NEWS_TITLE.getMessage(),"有成员申请该团队",6,"",0);
		News news2 = new News(NewsStatusInfo.SYSTEM_NEWS_TITLE.getMessage(),"有成员申请该团队",7,"",0);
		List<News> list = new ArrayList<News>();
		list.add(news1);
		list.add(news2);
		int affectRows = newsDao.batchAddNew(list);
		logger.info("影响的行数:" + affectRows);
	}

	@Test
	public void testQueryNoReadNews() {

		int number = newsDao.queryNoReadNews(199);

		logger.info("未读消息条数:" + number);

	}
}
