package com.gsdp.dao;

import com.gsdp.entity.group.Group;
import com.gsdp.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

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


    @Test
    public void queryUserByEmail() throws Exception{
        String email = "1138494584@qq.com";
        User user = userDao.queryUserByEmail(email);
        logger.info("user={}",user);
    }

    @Test
    public void  queryUserMsgByEmail() throws Exception{
        String email = "1210938970@qq.com";
        User user = userDao.queryUserMsgByEmail(email);
        logger.info("user={}",user);
    }

    @Test
    public void  registerUser() throws Exception{

        int age = 21;
        List<Group> groups = null;
        String headPicture = "123.jpg";
        String loginEmail = "doubleLL@foxmail.com";
        String password = "123456789";
        String phone = "未填写";
        String qq = "未填写";
        int sex = 1;
        String userDec = "我就是我，颜色不一样的烟火";
        String username = "耀光想的孤星";
        String weChat = "未填写";

        User user = new User(age,groups,headPicture,loginEmail,password,phone,qq,sex,userDec,username,weChat);
        int affectRows = userDao.registerUser(user);

        logger.info("影响的行数"+affectRows+",返回的自增Id:"+user.getUserId());
    }

    @Test
    public void updateUserById() throws Exception {
        String username = "一生一知己";
        int age = 22;
        int sex = 1;
        String weChat = "一生一知己";
        int userId = 2;
        String userDec = "我们是黑夜的雄鹰,腾飞在祖国的蓝天之上";
        int affectRows = userDao.updateUserById(new User(userId,null,null,null,username,userDec,sex,age,null,weChat,null));
        logger.info("影响的行数:" + affectRows);
    }

    @Test
    public void queryUserMessageById() {
        int userId = 2;
        User user = userDao.queryUserMessageById(userId);
        logger.info("user = {}", user);
    }

    @Test
    public void  verifyMember() throws Exception{

        int userId = 1;
        int groupId = 2;

        Integer affectRows = userDao.verifyAdmin(userId,groupId);

        logger.info("影响的行数:"+affectRows);

    }

    @Test
    public void  verifyAdmin() throws Exception{

        int userId = 1;
        int groupId = 5;

        Integer affectRows = userDao.verifyMember(userId,groupId);

        logger.info("影响的行数:"+affectRows);

    }

}