package com.gsdp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsdp.entity.group.Situation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SituationDaoTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="situationDao")
	private SituationDao situationDao;
	
	@Test
	public void testGetSituationMessage() {
		int groupId = 3;
		List<Situation> list = situationDao.getSituationMessage(groupId,0,2,"visitors",true);
		logger.info("list = {}", list);
	}
	
	@Test
	public void testGetSingleSituationMessage() {
		int situationId = 4;
		int offset = 0;
		int limit = 10;
		Situation situation = situationDao.getSingleSituationMessage(situationId, offset, limit);
		logger.info("situation = {}", situation);
	}
	
	@Test
	public void testAddSituationMessage() {
		String situationTitle = "我们团队的摄影展";
		String situationContent = "下面是我们团队的摄影展";
		int publisher = 1;
		String publishTime = "2016-10-27";
		int groupId = 3;
		int visitors = 111;
		Situation situation = new Situation(situationTitle, situationContent, publisher, publishTime, groupId, visitors);
		int affectRows = situationDao.addSituationMessage(situation);
		logger.info("影响的行数:" + affectRows + "返回的自增id:" + situation.getSituationId());
	}
	
	@Test
	public void testDeleteSituationMessage() {
		int situationId = 5;
		int affectRows = situationDao.deleteSituationMessage(situationId);
		logger.info("影响的行数:" + affectRows);
	}

	@Test
	public void testAddSituationVisitors(){

		int situationId = 5;
		int affectRows = situationDao.addSituationVisitors(situationId);
		logger.info("影响的行数:" + affectRows);

	}

	@Test
	public void testGetSituationListByPublisher(){
		int publisher = 1;
		List<Situation> situationList = situationDao.getSituationListByPublisher(publisher);
		logger.info("situationList = {}",situationList);
	}

}
