package com.gsdp.controller;

import com.gsdp.dto.JsonData;
import com.gsdp.enums.file.FileStatusInfo;
import com.gsdp.exception.EmptyFileException;
import com.gsdp.exception.FormatNotMatchException;
import com.gsdp.exception.SizeBeyondException;
import com.gsdp.service.UserService;
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
        String headPicture = userService.randomChangeHeadPicture(userId);
        if(headPicture != null) {
            //TODO 在把当前的Session给更新了
            return new JsonData(true, headPicture, "");
        } else {
            return new JsonData(false, "");
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
                return new JsonData(true, headPicture, FileStatusInfo.UPLOAD_SUCCESS.getMessage());
            } else {
                return new JsonData(false, FileStatusInfo.UPLOAD_FAIL.getMessage());
            }
        } catch (EmptyFileException e) {
            return new JsonData(false, FileStatusInfo.EMPTY_FILE.getMessage());
        } catch (FormatNotMatchException e) {
            return new JsonData(false, FileStatusInfo.FORMAT_NOT_MATCH.getMessage());
        } catch (SizeBeyondException e) {
            return new JsonData(false, FileStatusInfo.SIZE_BEYOND.getMessage());
        }
    }

}
