package com.gsdp.service;

import com.gsdp.entity.group.Group;
import com.gsdp.exception.group.CreateGroupException;
import com.gsdp.exception.EmptyFileException;
import com.gsdp.exception.FormatNotMatchException;
import com.gsdp.exception.SizeBeyondException;
import com.gsdp.exception.group.GroupException;
import com.gsdp.exception.group.GroupRepeatException;
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

    //添加管理员
    boolean addAdmin(int userId, int groupId);

    //删除管理员
    boolean delAdmin(int userId, int groupId);

    //添加组织成员
    boolean addMember(int userId, int groupId);

    //删除组织成员
    String quitGroup(int userId, int groupId) throws GroupException ;

    //转让组织
    boolean changeOwner(int userId, int groupId);

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
     * @throws CreateGroupException
     * @throws IllegalArgumentException
     */
    Group createGroup(Group group, MultipartFile multipartFile) throws
            EmptyFileException,SizeBeyondException,FormatNotMatchException,CreateGroupException,IllegalArgumentException,GroupRepeatException;

}
