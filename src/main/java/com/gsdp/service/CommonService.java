package com.gsdp.service;

import com.gsdp.exception.file.EmptyFileException;
import com.gsdp.exception.file.FormatNotMatchException;
import com.gsdp.exception.file.SizeBeyondException;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yizijun on 2016/11/9 0009.
 */
public interface CommonService {

    /**
     * 实现单文件上传的通用服务类。上传的文件的名字被我们在前面加了一个时间戳，防止重名的文件
     * @param multipartFile  Spring的multipartFile
     * @param path 上传文件所放的文件夹路径
     * @param maxSize 文件的最大字节数 注意要小于我们在spring配置文件中配置的大小，
     *                不然有可能有一些不可控的异常
     * @param regex 文件支持的格式，可以用'|'等(我们可以用在命名文件夹的时候不允许的符号来做
     *              间隔符,防止用户改扩展名)符号隔开，例如：jpg|png|jpeg|doc
     * @return
     * @throws EmptyFileException
     * @throws FormatNotMatchException
     * @throws SizeBeyondException
     */
    String upload(MultipartFile multipartFile, String path, long maxSize, String regex)
            throws EmptyFileException, FormatNotMatchException, SizeBeyondException;

}
