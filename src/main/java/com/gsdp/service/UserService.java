package com.gsdp.service;

import com.gsdp.entity.user.User;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.exception.group.GroupNotExistException;
import com.gsdp.exception.news.NewsException;
import com.gsdp.exception.user.*;
import com.gsdp.exception.file.EmptyFileException;
import com.gsdp.exception.file.FormatNotMatchException;
import com.gsdp.exception.file.SizeBeyondException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    /**
     * 随机的改变一个用户的头像
     * @param userId
     */
    String randomChangeHeadPicture(int userId) throws UserException ;

    /**
     *
     * @param userId
     * @param multipartFile
     * @param rootPath
     * @return
     * @throws EmptyFileException
     * @throws FormatNotMatchException
     * @throws SizeBeyondException
     * @throws UserException
     */
    String changeHeadPicture(int userId, MultipartFile multipartFile, String rootPath)
            throws EmptyFileException, FormatNotMatchException, SizeBeyondException, UserException ;

    /**
     * 修改用户的密码
     * @param email
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     * @return
     */
    boolean modifyPassword(String email, String oldPassword, String newPassword, String confirmPassword)
            throws IllegalArgumentException, TwoPasswordNotMatchException, LoginMsgIncorrectException, UserException ;


    /**
     * 验证用户登录
     * @param email
     * @param password
     * @return
     * @throws UserUndefinedException
     * @throws LoginMsgIncorrectException
     */
    User checkUserLogin(String email, String password)
            throws UserUndefinedException,LoginMsgIncorrectException;

    /**
     *
     * @param email
     * @param password
     * @param confirmPassword
     * @param verifyCode
     * @param session
     * @return
     * @throws UserExistedException
     * @throws ConfirmPasswordIncorrectException
     * @throws VerifyCodeIncorrectException
     */
    User registerUser(String email,String password,String confirmPassword,String verifyCode,HttpSession session)
            throws UserExistedException,ConfirmPasswordIncorrectException,VerifyCodeIncorrectException;

    /**
     *
     * @param userId
     * @param username
     * @param age
     * @param sex
     * @param weChat
     * @param userDec
     * @return
     * @throws IllegalArgumentException
     * @throws UserException
     */
    User modifyUserBaseInfo(int userId, String username, int age, int sex, String weChat, String userDec) throws
            IllegalArgumentException, UserException;

    /**
     * 验证成员身份
     * @param userId
     * @param groupId
     */
    boolean verifyMember(int userId,int groupId);

    /**
     * 验证管理身份
     * @param userId
     * @param groupId
     */
    boolean verifyAdmin(int userId,int groupId);

    /**
     *
     * @param userId
     * @param groupId
     * @param applyReason
     * @param phone
     * @return
     * @throws IllegalArgumentException
     * @throws GroupNotExistException
     * @throws SqlActionWrongException
     * @throws NewsException
     */
    boolean applyJoinGroup(int userId, int groupId, String applyReason, String phone) throws
            IllegalArgumentException,GroupNotExistException, SqlActionWrongException, NewsException;
    /**
     * 通过组织Id获取相关组织的成员
     * @param groupId
     * @return
     */
    List<User> getUserListByGroupId(int groupId);

}
