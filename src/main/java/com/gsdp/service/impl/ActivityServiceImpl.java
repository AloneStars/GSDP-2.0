package com.gsdp.service.impl;

import com.gsdp.dao.ActivityDao;
import com.gsdp.entity.group.Activity;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.exception.activity.ActivityTimeException;
import com.gsdp.exception.activity.OpenPermissionException;
import com.gsdp.service.ActivityService;
import com.gsdp.util.ActivityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public boolean addActivity(Activity activity) throws ActivityTimeException,OpenPermissionException{

        if(ActivityUtil.checkStartTime(activity.getBeginTime())
                &&ActivityUtil.checkEndTime(activity.getBeginTime(),activity.getEndTime())){
            if(ActivityUtil.checkOpen(activity.getPermission())){
                activityDao.addActivityMessage(activity);
                return true;
            }
            else
                throw new OpenPermissionException("this permission of activity is incorrect");
        }else
            throw new ActivityTimeException("ActivityTime is incorrect");

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
    @Transactional
    public Activity getSingleActivity(int activityId){
        Activity activity = activityDao.queryActivityMessage(activityId);

        //添加浏览记录失败，事物回滚
        addActivityVisitors(activityId);

        return activity;

    }

    @Override
    public List<Activity> getAllActivity() {

        List<Activity> activityList = activityDao.getAllActivityMessage();

        logger.info("activityList={}",activityList);

        return activityList;
    }

    @Override
    public List<Activity> getAllOpenActivity() {

        List<Activity> activityList = activityDao.getAllOpenActivityMessage();

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

    @Override
    public List<Activity> getOpenActivityMessage(int sponsor, int offset, int limit, String order, boolean type) {

        List<Activity> activityList = activityDao.getOpenActivityMessage(sponsor,offset,limit,order,type);

        logger.info("activityList={}",activityList);

        return activityList;
    }

    @Override
    public boolean addActivityVisitors(int activityId) throws SqlActionWrongException {
        try{
            if(activityDao.addActivityVisitors(activityId) == 1)
                return true;
            else
                throw new SqlActionWrongException("add visitors failure");
        }catch (Exception e){
            throw new SqlActionWrongException("add visitors failure");
        }
    }

}
