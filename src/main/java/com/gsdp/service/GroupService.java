package com.gsdp.service;

import com.gsdp.dto.group.GroupMember;
import com.gsdp.dto.group.GroupMemberWithCurrentUserRole;
import com.gsdp.dto.group.MemberAddition;
import com.gsdp.entity.group.Group;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.exception.file.*;
import com.gsdp.exception.group.*;
import com.gsdp.exception.news.NewsException;
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

    //删除组织信息
    boolean deleteGroup(int groupId);


    /**
     * 修改组织信息
     * @param groupId
     * @param groupName
     * @param groupContact
     * @param groupAddress
     * @param groupType
     * @param groupDec
     * @return
     * @throws IllegalArgumentException  用户传入的参数不符合格式
     * @throws SqlActionWrongException   数据库执行时发生了异常
     */
    boolean changeGroupInfo(int groupId, String groupName, String groupContact, String groupAddress,
                            int groupType, String groupDec) throws
            IllegalArgumentException, SqlActionWrongException;


    /**
     * 将团队里面的一个普通成员变成管理员
     * @param userId
     * @param groupId
     * @return
     * @throws NotInGroupException
     * @throws HasBeenAdminException
     * @throws NewsException
     * @throws SqlActionWrongException
     */
    boolean addAdmin(int userId, int groupId) throws
            NotInGroupException, HasBeenAdminException, NewsException, SqlActionWrongException;

    /**
     * 把团队的某个管理员变成普通成员，并且给其发送一封消息
     * @param userId
     * @param groupId
     * @return
     * @throws NotInGroupException
     * @throws NotGroupAdminException
     * @throws NewsException
     * @throws SqlActionWrongException
     */
    boolean deleteAdmin(int userId, int groupId) throws
            NotInGroupException, NotGroupAdminException, NewsException, SqlActionWrongException;

    /**
     * 向member表中插入一条数据
     * @param userId
     * @param groupId
     * @param applyReason
     * @param phone
     * @return
     * @throws GroupNotExistException
     * @throws SqlActionWrongException
     */
    MemberAddition addMember(int userId, int groupId, String applyReason, String phone) throws
            GroupNotExistException, SqlActionWrongException;

    /**
     *团队用户自动退出团体，但是法人不能够退出团队
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
     *
     * @param currentUserId
     * @param userId
     * @param groupId
     * @return
     * @throws NotInGroupException
     * @throws OwnerCanNotQuitGroupException
     * @throws NotHasPermissionException
     * @throws NewsException
     * @throws SqlActionWrongException
     */
    boolean fireMember(int currentUserId, int userId, int groupId) throws
            NotInGroupException, OwnerCanNotQuitGroupException, NotHasPermissionException, NewsException, SqlActionWrongException;

    /**
     *
     * @param currentOwner
     * @param userId
     * @param groupId
     * @return
     * @throws NotInGroupException
     * @throws HasBeenOwnerException
     * @throws NewsException
     * @throws SqlActionWrongException
     */
    boolean changeOwner(int currentOwner, int userId, int groupId) throws
            NotInGroupException, HasBeenOwnerException, NewsException, SqlActionWrongException;

    /**
     * 获取除了该组织之后的所有组织列表
     * @param groupId
     * @return
     */
    List<Group> getGroupListMessageExpGroup(int groupId);

    /**
     * 获取该用户创建的所有组织
     * @param owner
     * @return
     */
    List<Group> getGroupListByOwner(int owner);

    /**
     * 获取该用户加入的所有组织
     * @param member
     * @return
     */
    List<Group> getGroupListByMember(int member);


    /**
     * 返回所有社团的全部信息（包括该社团的法人信息），供app调用
     * @return
     * @throws SqlActionWrongException
     */
    List<Group> getAllGroupMessagesWithOwner() throws
            SqlActionWrongException;


    /**
     * 用户完成创建团队的申请
     * @param currentUserId   当前用户的id
     * @param group     团队信息
     * @param rootPath  团队佐证材料存放的文件夹
     * @param multipartFile  文件
     * @return
     * @throws EmptyFileException
     * @throws SizeBeyondException
     * @throws FormatNotMatchException
     * @throws IllegalArgumentException
     * @throws GroupRepeatException
     * @throws SqlActionWrongException
     */
    Group createGroup(int currentUserId, Group group, String rootPath, MultipartFile multipartFile) throws
            EmptyFileException,SizeBeyondException,FormatNotMatchException,IllegalArgumentException,GroupRepeatException, SqlActionWrongException;

    /**
     * 同意用户创建社团的申请
     * @param groupId
     * @return
     * @throws NewsException
     * @throws SqlActionWrongException
     */
    boolean agreeCreateGroup(int groupId) throws
            NewsException, SqlActionWrongException;

    /**
     * 不同意用户的创建社团申请
     * @param groupId
     * @return
     * @throws NewsException
     * @throws SqlActionWrongException
     */
    boolean disagreeCreateGroup(int groupId) throws
            NewsException, SqlActionWrongException;


    /**
     * 随机改变团队的头像
     * @param groupId
     * @return
     * @throws SqlActionWrongException
     */
    String randomChangeGroupIcon(int groupId) throws
            SqlActionWrongException;

    String changeGroupIcon(int groupId, MultipartFile multipartFile, String rootPath) throws
            EmptyFileException, FormatNotMatchException, SizeBeyondException, SqlActionWrongException;

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
     *
     * @param userId
     * @param groupId
     * @return
     * @throws HasBeenMemberException
     * @throws NewsException
     * @throws SqlActionWrongException
     */
    boolean agreeUserJoinGroup(int userId, int groupId) throws
            HasBeenMemberException, NewsException, SqlActionWrongException;

    /**
     *
     * @param userId
     * @param groupId
     * @return
     * @throws NewsException
     * @throws SqlActionWrongException
     */
    boolean disagreeUserJoinGroup(int userId, int groupId) throws
            NewsException, SqlActionWrongException;

    Group getGroupMessageWithOwner(int groupId) throws
            SqlActionWrongException;
}
