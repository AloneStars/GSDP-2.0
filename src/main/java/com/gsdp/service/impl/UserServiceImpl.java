package com.gsdp.service.impl;

import com.gsdp.dao.UserDao;
import com.gsdp.entity.group.Group;
import com.gsdp.entity.user.User;
import com.gsdp.exception.EmptyFileException;
import com.gsdp.exception.FormatNotMatchException;
import com.gsdp.exception.SizeBeyondException;
import com.gsdp.exception.user.*;
import com.gsdp.service.CommonService;
import com.gsdp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CommonService commonService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    //TODO  随机得到一个头像地址
    private String getHeadPictureByRandom() {
        return "12345.jpg";
    }

    @Override
    public String randomChangeHeadPicture(int userId) {
        /*
        1.从服务器的头像图片库中随机得到一个地址
        2.把这个地址赋值给当前用户
         */
        String headPicture = getHeadPictureByRandom();
        int affectRows = userDao.changeHeadPicture(userId, headPicture);
        if(affectRows == 1) {
            return headPicture;
        } else {
            return null;
        }
    }

    @Override
    public String changeHeadPicture(int userId, MultipartFile multipartFile)
    throws EmptyFileException, FormatNotMatchException, SizeBeyondException {
        /*
        1.先把用户上传的图片保存到我们服务器上面
        2.更改用户的头像url
         */
        final String path = "D:/";
        final String regex = "jpg|jpeg|png|gif";
        final long maxSize = 5 * 1024 * 1024;

        try {
            String headPicture = commonService.upload(multipartFile, path, maxSize, regex);
            if(null != headPicture) {
                //改变用户的头像地址
                if(1 == userDao.changeHeadPicture(userId, headPicture)) {
                    return headPicture;
                }
            }
        } catch (EmptyFileException e) {
            throw e;
        } catch (FormatNotMatchException e) {
            throw e;
        } catch (SizeBeyondException e) {
            throw e;
        } catch (Exception e) {
            logger.error("database update exception", e);
            return null;
        }
        return null;
    }

    @Override
    public User checkUserLogin(String email, String password) throws UserUndefinedException, LoginMsgIncorrectException {

        User user = userDao.queryUserMsgByEmail(email);

        if(user == null)
            throw  new UserUndefinedException("查询该用户不存在");
        else{
            if(!password.equals(user.getPassword()))
                throw new  LoginMsgIncorrectException("邮箱或者密码不正确");
            else
                return user;
        }

    }

    @Override
    public User registerUser(String email, String password, String confirmPassword, String verifyCode,HttpSession session)
    throws UserExistedException,ConfirmPasswordIncorrectException,VerifyCodeIncorrectException{

        int age = 0;
        List<Group> groups = null;
        String headPicture = "123456.jpg";
        String phone = "未填写";
        String qq = "未填写";
        int sex = 0;
        String userDec = null;
        String username = null;
        String weChat = "未填写";

        System.out.println(session.getAttribute("verifyCode"));

        if(userDao.queryUserByEmail(email) != null){
            throw new UserExistedException("this email has already registered");
        }
        else if(!password.equals(confirmPassword)){
            throw new ConfirmPasswordIncorrectException("confirmPassword failure");
        }
        else if(!verifyCode.equals(session.getAttribute("verifyCode"))){
            System.out.println("verifyCode:"+verifyCode+"session:"+session.getAttribute("verifyCode"));
            throw new VerifyCodeIncorrectException("verifyCode is incorrect");
        }
        else{
            User user = new User(age,groups,headPicture,email,password,phone,qq,sex,userDec,username,weChat);
            userDao.registerUser(user);
            return user;
        }
    }

    @Override
    public boolean verifyMember(int userId, int groupId) throws VerifyMemberException {

        Integer affectRows = userDao.verifyMember(userId,groupId);

        System.out.println("验证成员身份："+affectRows);

        if(affectRows == null)
            throw new VerifyMemberException("verifyMember failure");
        else
            return true;

    }

    @Override
    public boolean verifyAdmin(int userId, int groupId) throws VerifyAdminException {

        Integer affectRows = userDao.verifyAdmin(userId,groupId);

        System.out.println("验证管理身份："+affectRows);

        if(affectRows == null)
            throw new VerifyAdminException("verifyAdmin failure");
        else
            return true;

    }
}
