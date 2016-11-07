package com.gsdp.service.impl;

import com.gsdp.dao.GroupDao;
import com.gsdp.entity.group.Group;
import com.gsdp.exception.group.CreateGroupException;
import com.gsdp.exception.EmptyFileException;
import com.gsdp.exception.FormatNotMatchException;
import com.gsdp.exception.SizeBeyondException;
import com.gsdp.exception.group.GroupRepeatException;
import com.gsdp.service.GroupService;
import com.gsdp.util.GroupUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
public class GroupServiceImpl implements GroupService{

    private final Logger looger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public GroupDao groupDao;

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
            looger.info("数据库插入组织成功");
            return true;
        }
        else {
            looger.info("数据库插入组织数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean delGroup(int groupId) {

        int number = groupDao.deleteGroup(groupId);

        if(number == 1) {
            looger.info("数据库删除组织成功");
            return true;
        }
        else {
            looger.info("数据库删除组织数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean updateGroup(Group group) {

        int number = groupDao.updateGroup(group);

        if(number == 1) {
            looger.info("数据库更新组织成功");
            return true;
        }
        else {
            looger.info("数据库更新组织数量:{}", number);
            return false;
        }
    }

    @Override
    public boolean addAdmin(int userId, int groupId) {

        int number = groupDao.addAdmin(userId,groupId);

        if(number == 1) {
            looger.info("数据库添加组织管理员成功");
            return true;
        }
        else {
            looger.info("数据库添加组织管理员数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean delAdmin(int userId, int groupId) {

        int number = groupDao.deleteAdmin(userId,groupId);

        if(number == 1) {
            looger.info("数据库删除组织管理员成功");
            return true;
        }
        else {
            looger.info("数据库删除组织管理员数量:{}", number);
            return false;
        }
    }

    @Override
    @Transactional
    public boolean addMember(int userId, int groupId) {

        int number = groupDao.addMember(userId, groupId);
        int anoNumber = groupDao.changeMemberNumber(1,groupId);

        if((number == 1 )&& (anoNumber ==1)) {
            looger.info("数据库添加组织成员成功");
            return true;
        }
        else {
            looger.info("数据库添加组织成员数量:{}", number);
            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteMember(int userId, int groupId) {

        int number = groupDao.deleteMember(userId, groupId);
        int anoNumber = groupDao.changeMemberNumber(-1,groupId);

        if((number == 1 )&& (anoNumber ==1)) {
            looger.info("数据库删除组织成员成功");
            return true;
        }
        else {
            looger.info("数据库删除组织成员数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean changeOwner(int userId, int groupId) {

        int number = groupDao.changeOwner(userId, groupId);

        if(number == 1) {
            looger.info("数据库转让组织成功");
            return true;
        }
        else {
            looger.info("数据库转让组织数量:{}", number);
            return false;
        }
    }

    /**
     *
     * @param group
     * @param multipartFile
     * @return
     */
    @Override
    @Transactional
    public Group createGroup(Group group, MultipartFile multipartFile) throws
    EmptyFileException,SizeBeyondException,FormatNotMatchException,CreateGroupException,IllegalArgumentException, GroupRepeatException {

        final String UPLOAD_PATH = "D:/";
        //限制上传的最大字节数,最大可以上传5m的东西。
        long maxSize = 1024 * 1014 * 5;

        //说明根本没有选择文件，我们要抛出相应的异常，防止用户绕过前端验证
        if(null == multipartFile) {
            throw new EmptyFileException("the file is empty");
        }

       String originalFileName = multipartFile.getOriginalFilename();

        //防止用户传一些非允许的格式的文件
        if(!GroupUtil.isSpecialFormat(originalFileName)) {
            throw new FormatNotMatchException("the file format is not allowed upload");
        }
        //防止用户上传的文件大小大于指定的文件大小
        if(multipartFile.getSize() > maxSize) {
            throw new SizeBeyondException("the file size beyond specified size：" + maxSize);
        }

        //判断用户输入的团队信息是否全， 如果不全则返回
        if(!GroupUtil.checkGroupName(group.getGroupName()) || !GroupUtil.checkGroupContact(group.getGroupContact()) ||
                !GroupUtil.checkGroupAddress(group.getGroupAddress()) || !GroupUtil.checkGroupType(group.getGroupType())) {
            throw new IllegalArgumentException("user input information is incorrect");
        }


        if(groupDao.isSameGroupName(group.getGroupName()) != 0) {
            throw new GroupRepeatException("the team repeated");
        }

        try {
            //把数据库的操作都要写到try   catch里面，防止数据库抛出免检异常，那样我们spring就不会处理我们的事务
            String filePath = UPLOAD_PATH + System.currentTimeMillis() + originalFileName;
            group.setGroupEvidence(filePath);
            groupDao.addGroup(group);
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),new File(filePath));
            return group;
        } catch (Exception e) {
            //如果没有发生前面指定的异常，我们这里就把数据库抛出的免检异常和其它异常都统一的用运行期异常抛出去
                throw new CreateGroupException("failed to create activity");
        }

    }
}
