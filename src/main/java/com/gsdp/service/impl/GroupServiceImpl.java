package com.gsdp.service.impl;

import com.gsdp.dao.GroupDao;
import com.gsdp.dao.UserDao;
import com.gsdp.dto.group.GroupMember;
import com.gsdp.dto.group.GroupMemberWithCurrentUserRole;
import com.gsdp.dto.group.MemberAddition;
import com.gsdp.entity.Page;
import com.gsdp.entity.Role;
import com.gsdp.entity.group.Group;
import com.gsdp.entity.group.Member;
import com.gsdp.entity.user.User;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.exception.file.*;
import com.gsdp.exception.group.*;
import com.gsdp.service.CommonService;
import com.gsdp.service.GroupService;
import com.gsdp.util.GroupUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/31 创造的作品
 * ********************************************************
 * +描述:GroupService实现类
 *********************************************************/
@Service
public class GroupServiceImpl implements GroupService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CommonService commonService;

    @Override
    public List<Group> getGroupListMsg(int typeId, int offset, int limit, String order, boolean type) {

        List<Group> groupList = groupDao.getGroupMessageByType(typeId, offset, limit, order, type);

        return groupList;
    }

    @Override
    public Group getGroupMsg(int groupId) {

        Group group = groupDao.getGroupMessage(groupId);

        return group;

    }

    @Override
    public List<Group> getAllGroupListMsg(int offset, int limit, String order, boolean type) {

        List<Group> groupList = groupDao.getAllGroupMessage(offset, limit, order, type);

        return groupList;

    }

    @Override
    public boolean addGroup(Group group) {

        int number = groupDao.addGroup(group);

        if (number == 1) {
            logger.info("数据库插入组织成功");
            return true;
        } else {
            logger.info("数据库插入组织数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean delGroup(int groupId) {

        int number = groupDao.deleteGroup(groupId);

        if (number == 1) {
            logger.info("数据库删除组织成功");
            return true;
        } else {
            logger.info("数据库删除组织数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean updateGroup(Group group) {

        int number = groupDao.updateGroup(group);

        if (number == 1) {
            logger.info("数据库更新组织成功");
            return true;
        } else {
            logger.info("数据库更新组织数量:{}", number);
            return false;
        }
    }

    @Override
    @Transactional
    public boolean addAdmin(int userId, int groupId) throws
    NotInGroupException, HasBeenAdminException, SqlActionWrongException {

        try {

            Role role = groupDao.getRole(userId, groupId);

            if(null == role) {
                throw new NotInGroupException("not in the group");
            }

            if(role.getRoleId() > com.gsdp.enums.user.Role.GROUP_USER.getRoleId()) {
                throw new HasBeenAdminException("has been an admin");
            }

            if(1 == groupDao.updateMember(new Member(userId, groupId, 1, com.gsdp.enums.user.Role.GROUP_ADMIN.getRoleId()))) {
                if(1 == groupDao.addAdmin(userId, groupId)) {
                    return true;
                }
            }
        } catch (NotInGroupException e) {
            throw  e;
        } catch (HasBeenAdminException e) {
            throw e;
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new SqlActionWrongException("database update error");
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteAdmin(int userId, int groupId) throws
            NotInGroupException, NotGroupAdminException, SqlActionWrongException {

        try {

            Role role = groupDao.getRole(userId, groupId);

            if(null == role) {
                throw new NotInGroupException("not in the group");
            }

            if(role.getRoleId() != com.gsdp.enums.user.Role.GROUP_ADMIN.getRoleId()) {
                throw new NotGroupAdminException("not group admin");
            }

            if(1 == groupDao.updateMember(new Member(userId, groupId, 1, com.gsdp.enums.user.Role.GROUP_USER.getRoleId()))) {
                if(1 == groupDao.deleteAdmin(userId, groupId)) {
                    return true;
                }
            }
        } catch(NotInGroupException e) {
            throw e;
        } catch (NotGroupAdminException e) {
            throw e;
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new SqlActionWrongException("database update error");
        }
        return false;
    }

    @Override
    @Transactional
    public MemberAddition addMember(int userId, int groupId, String applyReason, String phone) throws
            GroupNotExistException, GroupException {

        try {
            //1.判断该组织是否存在
            Group group = groupDao.getGroupMessage(groupId);
            if (null == group) {
                throw new GroupNotExistException("group not exist");
            }

            Member member = new Member(userId, groupId, applyReason, phone);

            if (1 == groupDao.addMember(member)) {
                User user = userDao.queryUserMessageById(userId);
                return new MemberAddition(true, user.getUsername(), group.getGroupName(), member);
            }
        } catch (GroupNotExistException e) {
            throw e;
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new GroupException("database update error");
        }
        return null;
    }

    @Override
    @Transactional
    public boolean quitGroup(int userId, int groupId) throws
            NotInGroupException, OwnerCanNotQuitGroupException, SqlActionWrongException{

        try {

            Role role = groupDao.getRole(userId, groupId);

            if(null == role) {
                throw new NotInGroupException("not in the group");
            }

            if(role.getRoleId() == com.gsdp.enums.user.Role.GROUP_OWNER.getRoleId()) {
                throw new OwnerCanNotQuitGroupException("owner can't quit group");
            }

            if (1 == groupDao.deleteMember(userId, groupId)) {
                groupDao.deleteAdmin(userId, groupId);
                if (1 == groupDao.changeMemberNumber(-1, groupId)) {
                    return true;
                }
            }
        } catch (NotInGroupException e) {
            throw e;
        } catch (OwnerCanNotQuitGroupException e) {
            throw  e;
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new SqlActionWrongException("database update error");
        }
        return false;
    }

    @Override
    @Transactional
    public boolean changeOwner(int currentOwner, int userId, int groupId) throws
            NotInGroupException, SqlActionWrongException {

        /**
         * 1.把当前法人在member表里面的role改变成团队普通管理员
         * 2.把即将成为法人在member表里面的role改成法人
         * 3.将当前这个人添加到admin表中
         * 3.将group表中的owner改变了。
         */
        try {

            if (0 == groupDao.updateMember(new Member(userId, groupId, 1, com.gsdp.enums.user.Role.GROUP_OWNER.getRoleId()))) {
                throw new NotInGroupException("not in the group");
            }

            //在这里我们已经用拦截器判断了当前操作的用户肯定当前社团的法人，所以在这里我们就不用判断了
            if (1 == groupDao.updateMember(new Member(currentOwner, groupId, 1, com.gsdp.enums.user.Role.GROUP_ADMIN.getRoleId()))) {
                //这里主要不做判断是说它有可能本来就是这个社团的管理员了
                groupDao.addAdmin(userId, groupId);
                if (1 == groupDao.changeOwner(userId, groupId)) {
                    return true;
                }
            }
        } catch (NotInGroupException e) {
            throw e;
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new SqlActionWrongException("database update error");
        }
        return false;
    }

    @Override
    public List<Group> getGroupListMessageExpGroup(int groupId) {

        List<Group> groupList = groupDao.getGroupListMessageExpGroup(groupId);

        logger.info("groupList={}", groupList);

        return groupList;

    }

    /**
     * @param group
     * @param multipartFile
     * @return
     */
    @Override
    public Group createGroup(Group group, MultipartFile multipartFile) throws
            EmptyFileException, SizeBeyondException, FormatNotMatchException, IllegalArgumentException, GroupRepeatException {

        final String PATH = "D:/";
        //限制上传的最大字节数,最大可以上传5m的东西。
        final long MAX_SIZE = 1024 * 1014 * 5;
        final String REGEX = "jpg|jpeg|doc";


        //判断用户输入的团队信息是否全， 如果不全则返回
        if (!GroupUtil.checkGroupName(group.getGroupName()) || !GroupUtil.checkGroupContact(group.getGroupContact()) ||
                !GroupUtil.checkGroupAddress(group.getGroupAddress()) || !GroupUtil.checkGroupType(group.getGroupType())) {
            throw new IllegalArgumentException("user input information is incorrect");
        }

        try {

            if (groupDao.isSameGroupName(group.getGroupName()) != 0) {
                throw new GroupRepeatException("the team repeated");
            }

            String evidencePath = commonService.upload(multipartFile, PATH, MAX_SIZE, REGEX);
            if (evidencePath != null) {
                group.setGroupEvidence(evidencePath);
                if (1 == groupDao.addGroup(group)) {
                    return group;
                }
            }
        } catch (EmptyFileException e) {
            throw e;
        } catch (FormatNotMatchException e) {
            throw e;
        } catch (SizeBeyondException e) {
            throw e;
        } catch (GroupRepeatException e) {
            throw e;
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new GroupException("database update error");
        }
        return null;
    }

    @Override
    public GroupMember getGroupMembersByStatus(int groupId, int status, int currentPage, int limit) throws
            GroupNotExistException, SqlActionWrongException {

        try {
            Group group = groupDao.getGroupMessage(groupId);
            if (null == group) {
                throw new GroupNotExistException("group not exist");
            }

            int groupNumbers = groupDao.getGroupAllMemberNumbersByStatus(groupId, status);

            //初始化分页参数
            Page page = new Page();
            page.initPage(groupNumbers, currentPage, limit);

            List<Member> members = groupDao.getGroupMembersMessageWithRoleByStatus(groupId, status, page.getStartNumbers(), page.getPerPageDisplay());

            return new GroupMember(page, members);

        } catch (GroupNotExistException e) {
            throw e;
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new SqlActionWrongException("database update error");
        }
    }

    @Override
    public GroupMemberWithCurrentUserRole getGroupMembersWithRoleByStatus(int groupId, int status, int currentUserId, int currentPage, int limit)
            throws GroupNotExistException, SqlActionWrongException {

        /*
        1.获取当前用户在这个团队的角色
        2.然后获得这个团队的全部成员
         */
        Role currentRole = null;
        try {
            currentRole = groupDao.getRole(currentUserId, groupId);
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new SqlActionWrongException("database update error");
        }
        GroupMember groupMember = getGroupMembersByStatus(groupId, status, currentPage, limit);
        return new GroupMemberWithCurrentUserRole(currentRole, groupMember);
    }


    @Override
    @Transactional
    public boolean agreeUserJoinGroup(int userId, int groupId) throws
            SqlActionWrongException {

        //TODO 有BUG
        try {
            if (1 == groupDao.updateMember(new Member(userId, groupId, 1, com.gsdp.enums.user.Role.GROUP_USER.getRoleId()))) {
                if (1 == groupDao.changeMemberNumber(1, groupId)) {
                    return true;
                }
            }
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new SqlActionWrongException("database update error");
        }
        return false;
    }

    @Override
    public boolean disagreeUserJoinGroup(int userId, int groupId) throws
            SqlActionWrongException {

        //TODO 有BUG
        try {
            if (1 == groupDao.deleteMember(userId, groupId)) {
                return true;
            }
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new SqlActionWrongException("database update error");
        }
        return false;
    }

    @Override
    public Group getGroupMessageWithOwner(int groupId)
            throws SqlActionWrongException {

        try {
            return groupDao.queryGroupMessageWithOwner(groupId);
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new SqlActionWrongException("database update error");
        }
    }
}
