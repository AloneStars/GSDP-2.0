package com.gsdp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsdp.entity.group.Group;

/**
 * 管理员的所有操作
 * @author yizijun
 *
 */
public interface GroupDao {
	
	/**
	 * 给团体添加管理员
	 * @param userId
	 * @param groupId
	 * @return
	 */
	int addAdmin(@Param("userId") int userId, @Param("groupId") int groupId);
	
	/**
	 * 删除团体管理员
	 * @param userId
	 * @param groupId
	 * @return
	 */
	int deleteAdmin(@Param("userId") int userId, @Param("groupId") int groupId);
	
	/**
	 * 转让组织给别人
	 * @param userId
	 * @param groupId
	 * @return
	 */
	int changeOwner(@Param("userId") int userId, @Param("groupId") int groupId);
	
	/**
	 * 添加团体成员
	 * @param userId
	 * @param groupId
	 * @return
	 */
	int addMember(@Param("userId") int userId, @Param("groupId") int groupId);
	
	/**
	 * 删除团体成员
	 * @param userId
	 * @param groupId
	 * @return
	 */
	int deleteMember(@Param("userId") int userId, @Param("groupId") int groupId);

	/**
	 * 更改成员数量
	 * @param number
	 * @param groupId
	 * @return
     */
	int changeMemberNumber(@Param("number") int number , @Param("groupId") int groupId);
	
	/**
	 * 增加一个团体
	 * @param group
	 * @return
	 */
	int addGroup(Group group);

	/**
	 * 删除一个团体
	 * @param groupId
	 * @return
	 */
	int deleteGroup(int groupId);
	
	/**
	 * 更新组织信息
	 * @param group
	 * @return
	 */
	int updateGroup(Group group);
	
	/**
	 * 获取组织信息（根据Id）
	 * @param groupId
	 * @return
	 */
	Group getGroupMessage(int groupId);

	/**
	 * 获取组织列表,通过给定的参数获取
	 * @param groupType 组织类型
	 * @param offset  偏移量
	 * @param limited  开始位置
	 * @param order  排序字段，必须是表中的字段
	 * @param type    是否启用降序排列，true表示采用降序排列
     * @return list<Group>
     */
	List<Group> getGroupMessageByType(@Param("groupType") int groupType, @Param("offset") int offset,
									  @Param("limit") int limited, @Param("order") String order,
									  @Param("type") boolean type);

	/**
	 * 获取组织列表,通过给定的参数获取
	 * @param offset 偏移量
	 * @param limited 开始位置
	 * @param order  排序字段，必须是表中的字段
	 * @parma type  是否启用降序排列，true表示采用降序排列
     * @return lsit<Group>
     */
	List<Group> getAllGroupMessage(@Param("offset") int offset,@Param("limit") int limited,
								   @Param("order") String order,@Param("type") boolean type);

	/**
	 * 判断是否有重名的团队名称
	 * @param groupName
	 * @return
	 */
	int isSameGroupName(@Param("groupName") String groupName);
}
