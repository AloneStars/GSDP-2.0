package com.gsdp.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by yizijun on 2016/11/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring-dao.xml")
public class UserDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "userDao")
    private UserDao userDao;

    @Test
    public void changeHeadPicture() throws Exception {
        int userId = 1;
        String headPicture = "D://123.jpg";
        int affectRows = userDao.changeHeadPicture(userId, headPicture);
        logger.info("影响的行数：" + affectRows);
    }

    @Test
    public void modifyPassword() throws Exception {
        String loginEmail = "1210938970@qq.com";
        String newPassword = "1234567";
        int affectRows = userDao.modifyPassword(loginEmail, newPassword);
        logger.info("影响的行数:" + affectRows);
    }


}