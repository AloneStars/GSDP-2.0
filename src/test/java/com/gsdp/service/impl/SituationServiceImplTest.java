package com.gsdp.service.impl;

import com.gsdp.service.SituationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by yizijun on 2016/11/23 0023.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring/spring-dao.xml",
                                "classpath:spring/spring-service.xml"})
public class SituationServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "situationService")
    private SituationService situationService;

    @Test
    public void addSituation() throws Exception {

    }

    @Test
    public void deleteSituation() throws Exception {

    }

    @Test
    public void getSingleSituationMessage() throws Exception {

    }

    @Test
    public void getSituationMessage() throws Exception {

    }

    @Test
    public void publishSituation() throws Exception {
        int userId = 2;
        int groupId = 3;
        String situationTitle = "测试发布动态标题";
        String situationContent = "测试发布动态内容34324324343244";
        Integer situationId = situationService.publishSituation(userId,groupId,situationTitle,situationContent);
        logger.info("situationId = " + situationId);
    }

}