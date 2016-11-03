package com.gsdp.service;

import com.gsdp.entity.group.Activity;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/3 创造的作品
 * ********************************************************
 * +描述:活动相关的服务
 *********************************************************/
public interface ActivityService {

    /**
     * 添加一个活动
     * @param activity
     * @return
     */
    boolean addActivity(Activity activity);

    /**
     * 删除一个活动
     * @param activityId
     * @return
     */
    boolean deleteActivity(int activityId);

    /**
     * 更新一个活动
     * @param activity
     * @return
     */
    boolean updateActivity(Activity activity);

    /**
     * 获取单个活动相关信息
     * @param activityId
     * @return
     */
    Activity getSingleActivity(int activityId);

    /**
     * 获取所有的活动信息
     * @return
     */
    List<Activity> getAllActivity();

    /**
     * 根据主办方获取活动那个信息
     * @param sponsor 主办方
     */
    List<Activity> getActivityBySponsor(int sponsor);

    /**
     * 根据所给条件获取活动列表
     * @param sponsor
     * @param offset
     * @param limit
     * @param order
     * @param type
     * @return
     */
    List<Activity> getGeneralActivityMessage(int sponsor, int offset, int limit, String order, boolean type);


}
