package com.gsdp.service.impl;

import com.gsdp.dao.GroupDao;
import com.gsdp.entity.group.Group;
import com.gsdp.enums.group.GroupStatusInfo;
import com.gsdp.exception.file.EmptyFileException;
import com.gsdp.exception.file.FormatNotMatchException;
import com.gsdp.exception.file.SizeBeyondException;
import com.gsdp.exception.group.GroupException;
import com.gsdp.exception.group.GroupRepeatException;
import com.gsdp.exception.group.NotInGroupException;
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
    private CommonService commonService;

    @Override
    public List<Group> getGroupListMsg(int typeId,int offset,int limit,String order,boolean type) {

        List<Group> groupList = groupDao.getGroupMessageByType(typeId,offset,limit,order,type);

        return groupList;
    }

    @Override
    public Group getGroupMsg(int groupId) {

        Group group = groupDao.getGroupMessage(groupId);

        return group;

    }

    @Override
    public List<Group> getAllGroupListMsg(int offset,int limit,String order,boolean type) {

        List<Group> groupList = groupDao.getAllGroupMessage(offset,limit,order,type);

        return groupList;

    }

    @Override
    public boolean addGroup(Group group) {

        int number = groupDao.addGroup(group);

        if(number == 1) {
            logger.info("数据库插入组织成功");
            return true;
        }
        else {
            logger.info("数据库插入组织数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean delGroup(int groupId) {

        int number = groupDao.deleteGroup(groupId);

        if(number == 1) {
            logger.info("数据库删除组织成功");
            return true;
        }
        else {
            logger.info("数据库删除组织数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean updateGroup(Group group) {

        int number = groupDao.updateGroup(group);

        if(number == 1) {
            logger.info("数据库更新组织成功");
            return true;
        }
        else {
            logger.info("数据库更新组织数量:{}", number);
            return false;
        }
    }

    @Override
    public boolean addAdmin(int userId, int groupId) {

        int number = groupDao.addAdmin(userId,groupId);

        if(number == 1) {
            logger.info("数据库添加组织管理员成功");
            return true;
        }
        else {
            logger.info("数据库添加组织管理员数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean delAdmin(int userId, int groupId) {

        int number = groupDao.deleteAdmin(userId,groupId);

        if(number == 1) {
            logger.info("数据库删除组织管理员成功");
            return true;
        }
        else {
            logger.info("数据库删除组织管理员数量:{}", number);
            return false;
        }
    }

    @Override
    @Transactional
    public boolean addMember(int userId, int groupId) {

        int number = groupDao.addMember(userId, groupId);
        int anoNumber = groupDao.changeMemberNumber(1,groupId);

        if((number == 1 )&& (anoNumber ==1)) {
            logger.info("数据库添加组织成员成功");
            return true;
        }
        else {
            logger.info("数据库添加组织成员数量:{}", number);
            return false;
        }
    }

    @Override
    @Transactional
    public String quitGroup(int userId, int groupId)
            throws NotInGroupException, GroupException {

        try {

            if(0 == groupDao.deleteMember(userId, groupId)) {
                throw new NotInGroupException("not in the group");
            }

            if(1 == groupDao.changeMemberNumber(-1, groupId)) {
                return GroupStatusInfo.QUIT_GROUP_SUCCESS.getMessage();
            }

        } catch (NotInGroupException e) {
            throw e;
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new GroupException("database update error");
        }
        return null;
    }

    @Override
    public boolean changeOwner(int userId, int groupId) {

        int number = groupDao.changeOwner(userId, groupId);

        if(number == 1) {
            logger.info("数据库转让组织成功");
            return true;
        }
        else {
            logger.info("数据库转让组织数量:{}", number);
            return false;
        }
    }

    @Override
    public List<Group> getGroupListMessageExpGroup(int groupId) {

        List<Group> groupList = groupDao.getGroupListMessageExpGroup(groupId);

        logger.info("groupList={}",groupList);

        return groupList;

    }

    /**
     *
     * @param group
     * @param multipartFile
     * @return
     */
    @Override
    public Group createGroup(Group group, MultipartFile multipartFile) throws
    EmptyFileException,SizeBeyondException,FormatNotMatchException,IllegalArgumentException, GroupRepeatException {

        final String PATH = "D:/";
        //限制上传的最大字节数,最大可以上传5m的东西。
        final long MAX_SIZE = 1024 * 1014 * 5;
        final String REGEX = "jpg|jpeg|doc";


        //判断用户输入的团队信息是否全， 如果不全则返回
        if(!GroupUtil.checkGroupName(group.getGroupName()) || !GroupUtil.checkGroupContact(group.getGroupContact()) ||
                !GroupUtil.checkGroupAddress(group.getGroupAddress()) || !GroupUtil.checkGroupType(group.getGroupType())) {
            throw new IllegalArgumentException("user input information is incorrect");
        }

        try {

            if(groupDao.isSameGroupName(group.getGroupName()) != 0) {
                throw new GroupRepeatException("the team repeated");
            }

            String evidencePath = commonService.upload(multipartFile, PATH, MAX_SIZE, REGEX);
            if(evidencePath != null) {
                group.setGroupEvidence(evidencePath);
                if(1 == groupDao.addGroup(group)) {
                    return group;
                }
            }
        } catch (EmptyFileException e) {
            throw e;
        } catch (FormatNotMatchException e) {
            throw e;
        } catch (SizeBeyondException e) {
            throw e;
        } catch(GroupRepeatException e) {
            throw e;
        } catch (Exception e) {
            logger.error("database update error", e);
            throw new GroupException("database update error");
        }
        return null;
    }
}
