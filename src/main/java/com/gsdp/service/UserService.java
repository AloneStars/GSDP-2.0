package com.gsdp.service;

import com.gsdp.entity.user.User;
import com.gsdp.exception.EmptyFileException;
import com.gsdp.exception.FormatNotMatchException;
import com.gsdp.exception.SizeBeyondException;
import com.gsdp.exception.user.*;
import com.gsdp.exception.file.EmptyFileException;
import com.gsdp.exception.file.FormatNotMatchException;
import com.gsdp.exception.file.SizeBeyondException;
import com.gsdp.exception.user.TwoPasswordNotMatchException;
import com.gsdp.exception.user.UserException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

public interface UserService {

    /**
     * 随机的改变一个用户的头像
     * @param userId
     */
    String randomChangeHeadPicture(int userId) throws UserException ;

    /**
     * @param userId
     * @param multipartFile
     * @return
     */
    String changeHeadPicture(int userId, MultipartFile multipartFile)
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
            throws IllegalArgumentException, TwoPasswordNotMatchException, UserException ;
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
}
