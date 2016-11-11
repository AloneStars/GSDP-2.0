package com.gsdp.service.impl;

import com.gsdp.exception.EmptyFileException;
import com.gsdp.exception.FormatNotMatchException;
import com.gsdp.exception.SizeBeyondException;
import com.gsdp.service.CommonService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by yizijun on 2016/11/9 0009.
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String upload(MultipartFile multipartFile, String path, long maxSize, String regex)
            throws EmptyFileException, FormatNotMatchException, SizeBeyondException {

        //说明根本没有选择文件，我们要抛出相应的异常，防止用户绕过前端验证
        if(null == multipartFile) {
            throw new EmptyFileException("the file is empty");
        }

        String originalFileName = multipartFile.getOriginalFilename();

        //防止用户传一些非允许的格式的文件
        if(-1 == regex.indexOf(originalFileName.substring(originalFileName.lastIndexOf(".") + 1))) {
            throw new FormatNotMatchException("the file format is not allowed upload");
        }

        //防止用户上传的文件大小大于指定的文件大小
        if(multipartFile.getSize() > maxSize) {
            throw new SizeBeyondException("the file size beyond specified size：" + maxSize);
        }

        if(path.charAt(path.length() - 1) != '/') {
            path += "/";
        }

        String filePath = path + System.currentTimeMillis() + originalFileName;

        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(filePath));
            return filePath;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

    }
}
