package com.gsdp.service.impl;

import com.gsdp.dao.NewsDao;
import com.gsdp.entity.user.News;
import com.gsdp.exception.news.ReceiverIsEmptyException;
import com.gsdp.service.NewsService;
import com.gsdp.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizijun on 2016/11/28 0028.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean sendMessage(String newsTitle, String newsContent, List<Integer> receiver) throws
            ReceiverIsEmptyException {

        if(receiver == null || receiver.size() == 0) {
            //没有收件人
            throw new ReceiverIsEmptyException("receiver is empty");
        }

        List<News> list = new ArrayList<>(receiver.size());

        for(Integer user : receiver) {
                list.add(new News(newsTitle,newsContent,user, DateUtil.dateToString("yyyy-MM-dd"),0));
        }

        try {
            if (receiver.size() == newsDao.batchAddNew(list)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("database update error", e);
            //do nothing
        }
        return false;
    }

    @Override
    public List<News> getNewsListByToAddress(int toAddress) {
        List<News> newsList = newsDao.getNewsListByToAddress(toAddress);
        return newsList;
    }
}
