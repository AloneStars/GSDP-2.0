package com.gsdp.dao;

import java.util.List;

import com.gsdp.entity.group.Activity;
import org.apache.ibatis.annotations.Param;

/**
 * 活动的Dao层接口
 * @author yizijun
 *
 */
public interface ActivityDao {
	
	/**
	 * 获取所有的活动信息
	 * @return
	 */
	List<Activity> getAllActivityMessage();

	/**
	 * 获取所有公开的活动信息
	 * @return
	 */
	List<Activity> getAllOpenActivityMessage();
	
	/**
	 * 查询指定社团所举办的所有活动
	 * @param sponsor 社团对应的id
	 * @return
	 */
	List<Activity> getActivityMessage(int sponsor);
	
	/**
	 * 添加一个活动，并把自增的id写回到该实体对应的activityId
	 * @param activity
	 * @return 数据库影响的行数
	 */
	int addActivityMessage(Activity activity);
	
	/**
	 * 删除一个活动
	 * @param activityId
	 * @return 数据库影响的行数
	 */
	int deleteActivityMessage(int activityId);
	
	/**
	 * 更新一个activity
	 * @param activity
	 * @return
	 */
	int updateActivityMessage(Activity activity);
	
	/**
	 * 查询activity中的信息，根据传入的id来获取相应的activity信息。
	 * @param activityId
	 * @return
	 */
	Activity queryActivityMessage(int activityId);

	/**
	 * 根据所给的条件获取活动列表
	 * @param sponsor 主办单位
	 * @param offset 偏移量
	 * @param limit 查询个数，为0表示不做分页查询
	 * @param order 排序子段，按照和字段做排序
	 * @parma type  是否启用降序排列，true表示采用降序排列
     * @return 活动列表
     */
	List<Activity> getGeneralActivityMessage(@Param("sponsor") int sponsor,@Param("offset") int offset,
											 @Param("limit") int limit,@Param("order") String order,
											 @Param("type") boolean type);


	/**
	 * 根据所给的条件获取活动列表
	 * @param activitier 活动发布人
	 * @param offset 偏移量
	 * @param limit 查询个数，为0表示不做分页查询
	 * @param order 排序子段，按照和字段做排序
	 * @parma type  是否启用降序排列，true表示采用降序排列
	 * @return 活动列表
	 */
	List<Activity> getGeneralActivityMessageByActivitier(@Param("activitier") int activitier,@Param("offset") int offset,
											 @Param("limit") int limit,@Param("order") String order,
											 @Param("type") boolean type);



	/**
	 * 根据所给的条件获取公开活动列表
	 * @param sponsor 主办单位
	 * @param offset 偏移量
	 * @param limit 查询个数，为0表示不做分页查询
	 * @param order 排序子段，按照和字段做排序
	 * @parma type  是否启用降序排列，true表示采用降序排列
	 * @return 活动列表
	 */
	List<Activity> getOpenActivityMessage(@Param("sponsor") int sponsor,@Param("offset") int offset,
											 @Param("limit") int limit,@Param("order") String order,
											 @Param("type") boolean type);

	/**
	 * 根据所给的条件获取公开活动列表
	 * @param activitier 活动发布者
	 * @param offset 偏移量
	 * @param limit 查询个数，为0表示不做分页查询
	 * @param order 排序子段，按照和字段做排序
	 * @parma type  是否启用降序排列，true表示采用降序排列
	 * @return 活动列表
	 */
	List<Activity> getOpenActivityMessageByActivitier(@Param("activitier") int activitier,@Param("offset") int offset,
										  @Param("limit") int limit,@Param("order") String order,
										  @Param("type") boolean type);

	/**
	 * 添加浏览记录
	 * @param activityId
	 * @return
     */
	int addActivityVisitors(int activityId);

}
