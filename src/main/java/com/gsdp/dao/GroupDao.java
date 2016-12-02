package com.gsdp.dao;

import java.util.List;

import com.gsdp.entity.Role;
import com.gsdp.entity.group.Member;
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
	 * 获取一个团队的所有管理员的id
	 * @param groupId
	 * @return
	 */
	List<Integer> getGroupAdmin(int groupId);
	
	/**
	 * 转让组织给别人
	 * @param userId
	 * @param groupId
	 * @return
	 */
	int changeOwner(@Param("userId") int userId, @Param("groupId") int groupId);


	/**
	 *
	 * @param member
	 * @return
	 */
	int addMember(Member member);
	
	/**
	 * 删除团体成员
	 * @param userId
	 * @param groupId
	 * @return
	 */
	int deleteMember(@Param("userId") int userId, @Param("groupId") int groupId);

	/**
	 * 根据userId和groupId来更新Member
	 * @param member
	 * @return
	 */
	int updateMember(Member member);

	/**
	 * 根据特定的状态（也就是查看是申请中，还是已加入该团队）来获取相关团队成员信息，同时
	 * 包括该用户的详细信息，但是密码被我们给抹去了
	 * @param groupId
	 * @param status
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Member> getGroupMembersByStatus(@Param("groupId") int groupId, @Param("status") int status,
										 @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据特定的状态（也就是查看是申请中，还是已加入该团队）来获取相关团队成员信息，同时
     * 包括该用户的详细信息,同时还包括该成员在该团队的角色信息，但是密码被我们给抹去了
     * 同时这是一个升序排列，意思就是说这个列表是按照职位的高低依次排列的。
     * @param groupId
     * @param status
     * @param offset
     * @param limit
     * @return
     */
    List<Member> getGroupMembersMessageWithRoleByStatus(@Param("groupId") int groupId, @Param("status") int status,
														@Param("offset") int offset, @Param("limit") int limit);

	/**
	 * 获取指定用户在指定团队的权限
	 * @param userId
	 * @param groupId
	 * @return
	 */
	Role getRole(@Param("userId") int userId, @Param("groupId") int groupId);

	/**
	 * 根据状态获取一个团队总人数
	 * @param groupId
	 * @param status
	 * @return
	 */
	int getGroupAllMemberNumbersByStatus(@Param("groupId") int groupId, @Param("status") int status);

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
	 * 获取一个团队的信息，包括这个团队的创建者信息
	 * @param groupId
	 * @return
	 */
	Group queryGroupMessageWithOwner(int groupId);


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
	 * 获取除了该组织之外的组织对象列表
	 * @param groupId
	 * @return
     */
	List<Group> getGroupListMessageExpGroup(int groupId);

	/**
	 * 判断是否有重名的团队名称
	 * @param groupName
	 * @return
	 */
	int isSameGroupName(String groupName);
}
