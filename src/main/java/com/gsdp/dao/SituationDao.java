package com.gsdp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsdp.entity.group.Situation;

/**
 * 这是团队管理员发表的动态的数据库映射操作，我是根据实际的前端交互模型来写的Dao层，
 * 如果还有一些操作没有写出来。待用到了再说，因为现在需求不明确
 * @author yizijun
 * 
 */
public interface SituationDao {

	/**
	 * 根据所给的信息获取相关的动态列表
	 * @param groupId 组织Id
	 * @param offset  偏移量
	 * @param limit   查询数量
	 * @param order   查询字段
	 * @param type    排序类型
     * @return  List<Situation>
     */
	List<Situation> getSituationMessage(@Param("groupId") int groupId,@Param("offset") int offset,
										@Param("limit") int limit,@Param("order") String order,
										@Param("type") boolean type);

	/**
	 * 获得单个动态的消息（包含这个动态所包含的全部回复，并且每条回复都包含了这条回复的用户）
	 * 
	 * @param situationId
	 *            动态id
	 * @param offset
	 *            查询回复的偏移量
	 * @param limit
	 *            限制查询回复的条数
	 * @return
	 */
	Situation getSingleSituationMessage(@Param("situationId") int situationId,
										@Param("offset") int offset, @Param("limit") int limit);

	/**
	 * 添加动态消息
	 * 
	 * @param situation
	 * @return
	 */
	int addSituationMessage(Situation situation);

	/**
	 * 删除动态消息
	 * 
	 * @param situationId
	 * @return
	 */
	int deleteSituationMessage(int situationId);

	/**
	 * 添加浏览记录
	 * @param situationId
	 * @return
     */
	int addSituationVisitors(int situationId);

	/**
	 * 获取该用户发布的所有的动态
	 * @param publisher
	 * @return
     */
	List<Situation> getSituationListByPublisher(int publisher);

}
