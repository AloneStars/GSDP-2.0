package com.gsdp.service.impl;

import com.gsdp.dao.GroupDao;
import com.gsdp.dao.UserDao;
import com.gsdp.dto.group.MemberAddition;
import com.gsdp.entity.group.Member;
import com.gsdp.enums.news.NewsStatusInfo;
import com.gsdp.enums.user.UserStatusInfo;
import com.gsdp.exception.file.*;
import com.gsdp.entity.group.Group;
import com.gsdp.entity.user.User;
import com.gsdp.exception.group.GroupException;
import com.gsdp.exception.group.GroupNotExistException;
import com.gsdp.exception.news.ReceiverIsEmptyException;
import com.gsdp.exception.user.*;
import com.gsdp.service.CommonService;
import com.gsdp.service.GroupService;
import com.gsdp.service.NewsService;
import com.gsdp.service.UserService;
import com.gsdp.util.DateUtil;
import com.gsdp.util.GroupUtil;
import com.gsdp.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private CommonService commonService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private NewsService newsService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    //TODO  随机得到一个头像地址
    private String getHeadPictureByRandom() {
        return "image/GroupIcon/Art.jpg";
    }

    @Override
    public String randomChangeHeadPicture(int userId) throws UserException {
        /*
        1.从服务器的头像图片库中随机得到一个地址
        2.把这个地址赋值给当前用户
         */
        String headPicture = getHeadPictureByRandom();
        try {
            if(1 == userDao.changeHeadPicture(userId, headPicture)) {
                return headPicture;
            }
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new UserException("database update error");
        }
        return null;
    }

    @Override
    public String changeHeadPicture(int userId, MultipartFile multipartFile, String rootPath)
    throws EmptyFileException, FormatNotMatchException, SizeBeyondException, UserException {
        /*
        1.先把用户上传的图片保存到我们服务器上面
        2.更改用户的头像url
         */
        final String PATH = rootPath + "headPicture/" + DateUtil.dateToString("yyyy-MM-dd");
        final String REGEX = "jpg|jpeg|png|gif";
        final long MAX_SIZE = 5 * 1024 * 1024;

        try {
            String headPicture = commonService.upload(multipartFile, PATH, MAX_SIZE, REGEX);
            if(null != headPicture) {
                //把前面的物理地址根目录去掉，直接保存到数据库中的为相对地址
                headPicture = headPicture.substring(rootPath.length());
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
            logger.error("database update error", e);
            throw new UserException("database update error");
        }
        return null;
    }

    @Override
    public boolean modifyPassword(String email, String oldPassword, String newPassword, String confirmPassword)
        throws IllegalArgumentException, TwoPasswordNotMatchException, LoginMsgIncorrectException, UserException {

        if (!(UserUtil.checkPassword(newPassword) && UserUtil.checkPassword(confirmPassword)
                && UserUtil.checkPassword(oldPassword))) {
            throw new IllegalArgumentException("user input information is incorrect");
        }

        if(!newPassword.equals(confirmPassword)) {
            throw new TwoPasswordNotMatchException("two input password not match");
        }

        try {
            //判断用户输入的原密码是否是正确的。
            checkUserLogin(email,oldPassword);

           if (1 == userDao.modifyPassword(email, newPassword)) {
               return true;
           }
        } catch (LoginMsgIncorrectException e) {
            throw e;
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new UserException("database update error");
        }

        return false;
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
    @Transactional
    public User modifyUserBaseInfo(int userId, String username, int age, int sex, String weChat, String userDec) throws
    IllegalArgumentException, UserException {

            if(!(UserUtil.checkUsername(username) && UserUtil.checkUserAge(age) &&
                    UserUtil.checkUserSex(sex) && UserUtil.checkUserWechat(weChat) &&
                    UserUtil.checkPersonIntroduce(userDec))) {
                throw new IllegalArgumentException("user input information is incorrect");
            }

            User user = new User(userId,null,null,null,username,userDec,sex,age,null,weChat,null);

        try {
            if(1 == userDao.updateUserById(user)) {
                //如果这个查询语句失败，我们就无法更新session，我们也把它算成修改失败
                    user = userDao.queryUserMessageById(user.getUserId());
                    return user;
            }
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new UserException("database update error");
        }
        return null;
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

    @Override
    public boolean applyJoinGroup(int userId, int groupId, String applyReason, String phone) throws
            IllegalArgumentException, GroupNotExistException, GroupException {

        if(!(GroupUtil.checkGroupContact(phone) && GroupUtil.checkApplyReason(applyReason))) {
            throw new IllegalArgumentException("user input information is incorrect");
        }

        try {

            MemberAddition memberAddition = groupService.addMember(userId, groupId, applyReason, phone);

            if(memberAddition != null && memberAddition.isSuccess()) {
                /*
                如果这条数据插入成功，我们就要把消息发给该团队的所有管理员，
                同时在这里有一点非常重要的业务逻辑的是：如果该数据插入成功，
                但是没有给团队管理员发送消息，我们也认定该申请提交成功
                1.查找该团队的所有管理员
                2.发送消息给所有的管理员
                 */
                try {
                    String newsTitle = NewsStatusInfo.SYSTEM_NEWS_TITLE.getMessage();

                    String newsContent = "用户:" + memberAddition.getUsername() + " 申请加入:" +
                            memberAddition.getGroupName() + " 申请理由:"
                            + memberAddition.getMember().getApplyReason();

                    List<Integer> admin = groupDao.getGroupAdmin(groupId);

                    newsService.sendMessage(newsTitle, newsContent,admin);

                } catch (ReceiverIsEmptyException e) {
                    logger.error("receiver is empty");
                    //do nothing
                } catch (Exception e) {
                    logger.error("database update error");
                    //do nothing
                }
                return true;
            }
        } catch(GroupNotExistException e) {
            throw e;
        } catch (GroupException e) {
            throw e;
        }
        return false;
    }


}
