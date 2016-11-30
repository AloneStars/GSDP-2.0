package com.gsdp.service;

import com.gsdp.entity.user.User;
import com.gsdp.exception.EmptyFileException;
import com.gsdp.exception.FormatNotMatchException;
import com.gsdp.exception.SizeBeyondException;
import com.gsdp.exception.user.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    /**
     * 随机的改变一个用户的头像
     * @param userId
     */
    String randomChangeHeadPicture(int userId);

    /**
     * @param userId
     * @param multipartFile
     * @return
     */
    String changeHeadPicture(int userId, MultipartFile multipartFile)
            throws EmptyFileException, FormatNotMatchException, SizeBeyondException;

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

    User registerUser(String email,String passwrod,String confirmPassword,String verifyCode,HttpSession session)
            throws UserExistedException,ConfirmPasswordIncorrectException,VerifyCodeIncorrectException;

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
     * 通过组织Id获取相关组织的成员
     * @param groupId
     * @return
     */
    List<User> getUserListByGroupId(int groupId);

}
