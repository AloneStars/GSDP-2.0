package com.gsdp.service;

import com.gsdp.dto.group.GroupMember;
import com.gsdp.dto.group.GroupMemberWithCurrentUserRole;
import com.gsdp.dto.group.MemberAddition;
import com.gsdp.entity.group.Group;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.exception.file.*;
import com.gsdp.exception.group.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/31 创造的作品
 * ********************************************************
 * +描述:组织相关的Service接口
 *********************************************************/
public interface GroupService {

    //根据typeId获取相应的组织列表
    List<Group> getGroupListMsg(int typeId,int offset,int limit,String order,boolean type);

    //根据groupId获取相应的组织信息
    Group getGroupMsg(int groupId);

    //获取所有的组织信息
    List<Group> getAllGroupListMsg(int offset,int limit,String order,boolean type);

    //添加组织信息
    boolean addGroup(Group group);

    //删除组织信息
    boolean delGroup(int groupId);

    //更新组织信息
    boolean updateGroup(Group group);


    /**
     * 将团队里面的一个普通成员变成一个管理员
     * @param userId
     * @param groupId
     * @return
     * @throws NotInGroupException
     * @throws HasBeenAdminException
     * @throws SqlActionWrongException
     */
    boolean addAdmin(int userId, int groupId) throws
            NotInGroupException, HasBeenAdminException, SqlActionWrongException;

    /**
     * 把某个团队的管理员变成普通成员
     * @param userId
     * @param groupId
     * @return
     * @throws NotInGroupException
     * @throws NotGroupAdminException
     * @throws SqlActionWrongException
     */
    boolean deleteAdmin(int userId, int groupId) throws
            NotInGroupException, NotGroupAdminException, SqlActionWrongException;

    /**
     *向member表中插入一条数据
     * @param userId
     * @param groupId
     * @param applyReason
     * @param phone
     * @return 添加成功就返回这个用户的信息
     * @throws GroupNotExistException  所传的社团并不存在
     * @throws GroupException  数据库更新异常
     */
    MemberAddition addMember(int userId, int groupId, String applyReason, String phone) throws
            GroupNotExistException, GroupException;

    /**
     *
     * @param userId
     * @param groupId
     * @return
     * @throws NotInGroupException
     * @throws OwnerCanNotQuitGroupException
     * @throws SqlActionWrongException
     */
    boolean quitGroup(int userId, int groupId) throws
            NotInGroupException, OwnerCanNotQuitGroupException, SqlActionWrongException;


    /**
     * 改变一个团队的法人
     * @param currentOwner
     * @param userId
     * @param groupId
     * @return
     * @throws SqlActionWrongException
     */
    boolean changeOwner(int currentOwner, int userId, int groupId) throws
            NotInGroupException, SqlActionWrongException;

    //获取除了该组织之后的所有组织列表
    List<Group> getGroupListMessageExpGroup(int groupId);

    /**
     *
     * @param group
     * @param multipartFile
     * @return
     * @throws EmptyFileException
     * @throws SizeBeyondException
     * @throws FormatNotMatchException
     * @throws IllegalArgumentException
     * @throws GroupRepeatException
     * @throws GroupException
     */
    Group createGroup(Group group, MultipartFile multipartFile) throws
            EmptyFileException,SizeBeyondException,FormatNotMatchException,IllegalArgumentException,GroupRepeatException, GroupException;

    /**
     *
     * @param groupId
     * @param status
     * @param currentPage
     * @param limit
     * @return
     * @throws GroupNotExistException
     * @throws SqlActionWrongException
     */
    GroupMember getGroupMembersByStatus(int groupId, int status, int currentPage, int limit) throws
            GroupNotExistException, SqlActionWrongException;

    /**
     *
     * @param groupId
     * @param status
     * @param currentUserId
     * @param currentPage
     * @param limit
     * @return
     * @throws GroupNotExistException
     * @throws SqlActionWrongException
     */
    GroupMemberWithCurrentUserRole getGroupMembersWithRoleByStatus(int groupId, int status, int currentUserId, int currentPage, int limit) throws
            GroupNotExistException, SqlActionWrongException;

    /**
     * 同意用户加入指定团队
     * @param userId
     * @param groupId
     * @return
     * @throws SqlActionWrongException
     */
    boolean agreeUserJoinGroup(int userId, int groupId) throws
            SqlActionWrongException;

    /**
     * 不同意用户加入指定团队
     * @param userId
     * @param groupId
     * @return
     * @throws SqlActionWrongException
     */
    boolean disagreeUserJoinGroup(int userId, int groupId) throws
            SqlActionWrongException;

    Group getGroupMessageWithOwner(int groupId) throws
            SqlActionWrongException;
}
