package com.gsdp.controller;

import com.gsdp.dto.JsonData;
import com.gsdp.enums.BaseStatusInfo;
import com.gsdp.dto.Token;
import com.gsdp.email.Send;
import com.gsdp.entity.user.User;
import com.gsdp.enums.file.FileStatusInfo;
import com.gsdp.enums.group.GroupStatusInfo;
import com.gsdp.enums.user.UserStatusInfo;
import com.gsdp.exception.file.EmptyFileException;
import com.gsdp.exception.file.FormatNotMatchException;
import com.gsdp.exception.file.SizeBeyondException;
import com.gsdp.exception.group.GroupException;
import com.gsdp.exception.group.GroupNotExistException;
import com.gsdp.exception.user.*;
import com.gsdp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String viewUserProfile() {
        return "personProfile";
    }

    @RequestMapping(value = "/randomChangeHead", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData randomChangeHead(HttpSession session) {
        User user = (User)session.getAttribute("user");
        int userId = user.getUserId();
        try {
            String headPicture = userService.randomChangeHeadPicture(userId);
            if(null != headPicture) {
                user.setHeadPicture(headPicture);
                session.setAttribute("user", user);
                return new JsonData(true, headPicture, UserStatusInfo.MODIFY_HEAD_PICTURE_SUCCESS.getMessage());
            } else {
                return new JsonData(false, UserStatusInfo.MODIFY_HEAD_PICTURE_FAIL.getMessage());
            }
        } catch (UserException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/changeHead", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData changeHeadPicture(@RequestParam("headPicture") MultipartFile multipartFile, HttpSession session) {

        User user = (User)session.getAttribute("user");
        int userId = user.getUserId();
        String rootPath = session.getServletContext().getRealPath("/");
        try {
            String headPicture = userService.changeHeadPicture(userId, multipartFile, rootPath);
            if(headPicture != null) {
                user.setHeadPicture(headPicture);
                session.setAttribute("user", user);
                return new JsonData(true, headPicture, UserStatusInfo.MODIFY_HEAD_PICTURE_SUCCESS.getMessage());
            } else {
                return new JsonData(false, UserStatusInfo.MODIFY_HEAD_PICTURE_FAIL.getMessage());
            }
        } catch (EmptyFileException e) {
            return new JsonData(false, FileStatusInfo.EMPTY_FILE.getMessage());
        } catch (FormatNotMatchException e) {
            return new JsonData(false, FileStatusInfo.FORMAT_NOT_MATCH.getMessage());
        } catch (SizeBeyondException e) {
            return new JsonData(false, FileStatusInfo.SIZE_BEYOND.getMessage());
        } catch (UserException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/modifyPassword",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData modifyPassword(String oldPassword, String newPassword, String confirmPassword,
                                   HttpSession session) {

        User user = (User)session.getAttribute("user");
        String email = user.getLoginEmail();

        try {
            if(userService.modifyPassword(email, oldPassword, newPassword, confirmPassword)) {
                return new JsonData(true, "", UserStatusInfo.MODIFY_PASSWORD_SUCCESS.getMessage());
            } else {
                return new JsonData(false, UserStatusInfo.MODIFY_PASSWORD_FAIL.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return new JsonData(false,BaseStatusInfo.PARAMETER_ERROR.getMessage());
        } catch (TwoPasswordNotMatchException e) {
            return new JsonData(false, UserStatusInfo.TWO_PASSWORD_INPUT_NOT_MATCH.getMessage());
        } catch(LoginMsgIncorrectException e) {
            return new JsonData(false, UserStatusInfo.ORIGINAL_PASSWORD_ERROR.getMessage());
        } catch (UserException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData login(String email,String password,HttpSession session){

        User user = null;
        try {
            user = userService.checkUserLogin(email, password);
        }catch(UserUndefinedException e){
            return new JsonData(false, UserStatusInfo.USER_UNDEFINED.getMessage());
        }catch(LoginMsgIncorrectException e){
            return new JsonData(false, UserStatusInfo.USER_LOGIN_MESSAGE_INCORRECT.getMessage());
        }

        //将用户信息放入session中
        session.setAttribute("user",user);

        return new JsonData(true,user,UserStatusInfo.USER_LOGIN_SUCCESS.getMessage());

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData register(String email,String password,String confirmPassword,String verifyCode,HttpSession session){

        User user = null;

        try {

            user = userService.registerUser(email,password,confirmPassword,verifyCode,session);

            if(user != null)
                return new JsonData(true,UserStatusInfo.USER_REGISTER_SUCCESS.getMessage());
            else
                return new JsonData(false,UserStatusInfo.USER_LOGOUT_FAILURE.getMessage());

        }catch(UserExistedException e){
            return new JsonData(false,UserStatusInfo.USER_REGISTER_USEREXISTED.getMessage());
        }catch(ConfirmPasswordIncorrectException e){
            return new JsonData(false,UserStatusInfo.USER_REGISTER_CONFIRMPASSWORDFAILURE.getMessage());
        }catch(VerifyCodeIncorrectException e){
            return new JsonData(false,UserStatusInfo.USER_REGISTER_VERIFTCORRECT.getMessage());
        }

    }


    @RequestMapping(value = "/sendVerifyCode", method = RequestMethod.POST , produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData sendVerifyCode(String email,HttpSession session){

        String verifyCode = Token.randToken();

        Send send = new Send("/email.properties");

        boolean success = send.email(email,"本邮件为GSDP(校园团体风采展示平台)的用户注册邮件",
                        "<h1>欢迎您注册成为我们的用户,下面是本次登录的验证码:</h1>" +
                        "<br/><h1 style='color:#08c;'>验证码:"+ verifyCode+"</h1>");

        if(success){
            session.setAttribute("verifyCode",verifyCode);
            return new JsonData(true,UserStatusInfo.USER_SENDVERIFYCODE_SUCCESS.getMessage());
        }else
            return new JsonData(true,UserStatusInfo.USER_SENDVERIFYCODE_FAILURE.getMessage());




    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST , produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData LoginOut(HttpSession session){

        session.removeAttribute("user");
        session.invalidate();

        return new JsonData(true,UserStatusInfo.USER_LOGOUT_SUCCESS.getMessage());
    }

    @RequestMapping(value = "/modifyBaseInfo", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData modifyUserBaseInfo(String username, int age, int sex, String weChat,
                                       String userDec, HttpSession session) {
        int userId = ((User)session.getAttribute("user")).getUserId();

        try {
            User user = userService.modifyUserBaseInfo(userId, username,age,sex,weChat,userDec);
            if(null != user) {
                //我们把其密码置为null
                user.setPassword(null);
                session.setAttribute("user", user);
                return new JsonData(true, "", UserStatusInfo.MODIFY_USER_BASE_INFO_SUCCESS.getMessage());
            } else {
                return new JsonData(false, UserStatusInfo.MODIFY_USER_BASE_INFO_FAIL.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return new JsonData(false, BaseStatusInfo.PARAMETER_ERROR.getMessage());
        } catch (UserException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/applyJoinGroup", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData applyJoinGroup(int groupId, String applyReason, String phone, HttpSession session) {

        int userId = ((User)session.getAttribute("user")).getUserId();
        try {
            if(userService.applyJoinGroup(userId, groupId,applyReason,phone)) {
                return new JsonData(true,"",GroupStatusInfo.APPLICATION_HAS_BEEN_SUBMITTED.getMessage());
            } else {
                return new JsonData(false,GroupStatusInfo.APPLICATION_SUBMISSION_FAILED.getMessage());
            }
        } catch(IllegalArgumentException e) {
                return new JsonData(false, BaseStatusInfo.PARAMETER_ERROR.getMessage());
        } catch (GroupNotExistException e) {
            return new JsonData(false, GroupStatusInfo.GROUP_NOT_EXIST.getMessage());
        } catch (GroupException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }

    }

}
