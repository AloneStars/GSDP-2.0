package com.gsdp.service.impl;

import com.gsdp.enums.news.NewsStatusInfo;
import com.gsdp.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yizijun on 2016/11/28 0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                        "classpath:spring/spring-service.xml"})
public class NewsServiceImplTest {

    @Autowired
    private NewsService newsService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void sendMessage() throws Exception {

        String newsTitle = NewsStatusInfo.SYSTEM_NEWS_TITLE.getMessage();
        String newsContent = "有人加入社团";
        int sender = 2;
        List<Integer> receiver = Arrays.asList(6,7,8,9);
        boolean result = newsService.sendMessage(newsTitle,newsContent,2,receiver);
        logger.info("result = " + result);
    }

}