package com.gsdp.service.impl;

import com.gsdp.service.UserService;
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
@ContextConfiguration(value = {"classpath:spring/spring-dao.xml",
                                "classpath:spring/spring-service.xml"})
public class UserServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void testRandomChangeHeadPicture() throws Exception {
        int userId = 1;
        String headPicture = userService.randomChangeHeadPicture(userId);
        logger.info("headPicture = {}", headPicture);
    }

    @Test
    public void modifyPassword() throws Exception{
        String email = "1210938970@qq.com";
        String oldPassword = "1234567";
        String newPassword = "123456";
        String confirmPassword = "123456";
        boolean result = userService.modifyPassword(email,oldPassword,newPassword,confirmPassword);
        logger.info("result = {}", result);
    }

}