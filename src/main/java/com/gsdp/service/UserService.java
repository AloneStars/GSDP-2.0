package com.gsdp.service;

import com.gsdp.exception.EmptyFileException;
import com.gsdp.exception.FormatNotMatchException;
import com.gsdp.exception.SizeBeyondException;
import org.springframework.web.multipart.MultipartFile;

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
}
