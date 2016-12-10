package com.gsdp.service;

import com.gsdp.entity.user.News;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.exception.news.NoNewsExistException;
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
     * @param receiver
     * @return 只有全部发送成功才返回true，其余返回false，
     * @throws ReceiverIsEmptyException  接收消息的人为空
     */
    boolean sendMessage(String newsTitle, String newsContent, List<Integer> receiver) throws
            ReceiverIsEmptyException;

    /**
     * 获取用户收到的所有消息
     * @param toAddress
     * @return
     */
    List<News> getNewsListByToAddress(int toAddress);

    /**
     * 改变消息状态
     * @param newsId 消息Id
     * @param statue 消息状态
     * @return
     */
    boolean changeNewsStatue(int newsId,int statue) throws NoNewsExistException,SqlActionWrongException;

    /**
     * 获取该用户未读消息条数
     * @param toAddress
     * @return
     */
    int getNoReadNews(int toAddress);

}
