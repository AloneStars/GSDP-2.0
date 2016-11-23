package com.gsdp.service.impl;

import com.gsdp.dao.UserDao;
import com.gsdp.enums.user.UserStatusInfo;
import com.gsdp.exception.file.EmptyFileException;
import com.gsdp.exception.file.FormatNotMatchException;
import com.gsdp.exception.file.SizeBeyondException;
import com.gsdp.exception.user.TwoPasswordNotMatchException;
import com.gsdp.exception.user.UserException;
import com.gsdp.service.CommonService;
import com.gsdp.service.UserService;
import com.gsdp.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public String changeHeadPicture(int userId, MultipartFile multipartFile)
    throws EmptyFileException, FormatNotMatchException, SizeBeyondException, UserException {
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
            logger.error("database update error", e);
            throw new UserException("database update error");
        }
        return null;
    }

    @Override
    public boolean modifyPassword(String email, String oldPassword, String newPassword, String confirmPassword)
        throws IllegalArgumentException, TwoPasswordNotMatchException, UserException {

        if (!(UserUtil.checkPassword(newPassword) && UserUtil.checkPassword(confirmPassword)
                && UserUtil.checkPassword(oldPassword))) {
            throw new IllegalArgumentException("user input information is incorrect");
        }

        if(!newPassword.equals(confirmPassword)) {
            throw new TwoPasswordNotMatchException("two input password not match");
        }

        try {

            //TODO  这里要先判断用户输入的原密码是否是正确的。如果原密码都不正确就直接返回

           if (1 == userDao.modifyPassword(email, newPassword)) {
               return true;
           }
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new UserException("database update error");
        }

        return false;
    }
}
