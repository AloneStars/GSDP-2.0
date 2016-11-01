package com.gsdp.service;

import com.gsdp.entity.group.Group;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/31 创造的作品
 * ********************************************************
 * +描述:组织相关的Service接口
 *********************************************************/
@Service
public interface GroupService {

    //根据typeId获取相应的组织列表
    List<Group> getGroupListMsg(int typeId);

    //根据groupId获取相应的组织信息
    Group getGroupMsg(int groupId);

    //获取所有的组织信息
    List<Group> getAllGroupListMsg();

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

    //转让组织
    boolean changeOwner(int userId, int groupId);

}
