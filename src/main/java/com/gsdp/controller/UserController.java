package com.gsdp.controller;

import com.gsdp.dto.JsonData;
import com.gsdp.enums.BaseStatusInfo;
import com.gsdp.enums.file.FileStatusInfo;
import com.gsdp.enums.user.UserStatusInfo;
import com.gsdp.exception.file.EmptyFileException;
import com.gsdp.exception.file.FormatNotMatchException;
import com.gsdp.exception.file.SizeBeyondException;
import com.gsdp.exception.user.TwoPasswordNotMatchException;
import com.gsdp.exception.user.UserException;
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

    @RequestMapping(value = "/randomChangeHead", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData randomChangeHead(HttpSession session) {
        // TODO 从session中把用户的userId获取到
        int userId = 1;
        try {
            String headPicture = userService.randomChangeHeadPicture(userId);
            if(null != headPicture) {
                //TODO 在把当前的Session给更新了
                return new JsonData(true, headPicture, UserStatusInfo.MODIFY_HEAD_PICTURE_SUCCESS.getMessage());
            } else {
                return new JsonData(false, UserStatusInfo.MODIFY_HEAD_PICTURE_FAIL.getMessage());
            }
        } catch (UserException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/changeHead", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData changeHeadPicture(@RequestParam("headPicture") MultipartFile multipartFile, HttpSession session) {
        /*
        1.从session中获取用户的userId TODO
         */
        int userId = 1;
        try {
            String headPicture = userService.changeHeadPicture(userId, multipartFile);
            if(headPicture != null) {
                //TODO 在把当前的Session给更新了
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

    @RequestMapping(value = "/modifyPassword",method = RequestMethod.POST,
    produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData modifyPassword(String oldPassword, String newPassword, String confirmPassword,
                                   HttpSession session) {

        //TODO 用户邮箱从session中获取
        String email = "1210938970@qq.com";
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
        } catch (UserException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }
}
