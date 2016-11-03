package com.gsdp.service.impl;

import com.gsdp.dao.ActivityDao;
import com.gsdp.entity.group.Activity;
import com.gsdp.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/3 创造的作品
 * ********************************************************
 * +描述:活动相关的服务层实现
 *********************************************************/
@Service
public class ActivityServiceImpl implements ActivityService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ActivityDao activityDao;

    @Override
    public boolean addActivity(Activity activity) {
        return false;
    }

    @Override
    public boolean deleteActivity(int activityId) {
        return false;
    }

    @Override
    public boolean updateActivity(Activity activity) {
        return false;
    }

    @Override
    public Activity getSingleActivity(int activityId) {
        return null;
    }

    @Override
    public List<Activity> getAllActivity() {

        List<Activity> activityList = activityDao.getAllActivityMessage();

        logger.info("activityList={}",activityList);

        return activityList;
    }

    @Override
    public List<Activity> getActivityBySponsor(int sponsor) {

        List<Activity> activityList = activityDao.getActivityMessage(sponsor);

        logger.info("activityList={}",activityList);

        return activityList;
    }

    @Override
    public List<Activity> getGeneralActivityMessage(int sponsor, int offset, int limit, String order, boolean type) {

        List<Activity> activityList = activityDao.getGeneralActivityMessage(sponsor,offset,limit,order,type);

        logger.info("activityList={}",activityList);

        return activityList;
    }

}
