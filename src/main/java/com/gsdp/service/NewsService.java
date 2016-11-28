package com.gsdp.service;

import com.gsdp.exception.news.ReceiverIsEmptyException;

import java.util.List;

/**
 * Created by yizijun on 2016/11/28 0028.
 */
public interface NewsService {

    /**
     * 给指定的人发送消息
     * @param newsTitle
     * @param newsContent
     * @param sender
     * @param receiver
     * @return 只有全部发送成功才返回true，其余返回false，
     * @throws ReceiverIsEmptyException  接收消息的人为空
     */
    boolean sendMessage(String newsTitle, String newsContent, int sender, List<Integer> receiver) throws
            ReceiverIsEmptyException;

}
