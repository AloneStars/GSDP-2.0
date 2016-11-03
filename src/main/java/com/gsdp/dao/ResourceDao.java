package com.gsdp.dao;

import com.gsdp.entity.group.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/2 创造的作品
 * ********************************************************
 * +描述:资源相关的dao层接口
 *********************************************************/
public interface ResourceDao {

    /**
     * 添加一个文件
     * @param resource
     * @return 影响的行数
     */
    int addResource(Resource resource);

    /**
     * 删除一个文件，根据id
     * @param resourceId
     * @return 影响的行数
     */
    int deleteResource(int resourceId);

    /**
     * 修改文件相关信息
     * @param resource
     * @return 影响的行数
     */
    int updateResource(Resource resource);

    /**
     * 查找所有文件
     * @return List<Resource>
     */
    List<Resource> queryAllResource();

    /**
     * 查找所给类型的文件
     * @param typeId
     * @return List<Resource>
     */
    List<Resource> queryResourceByType(int typeId);

    /**
     * 查找组织类内的相关类型的文件
     * @param typeId
     * @param groupId
     * @return List<Resource>
     */
    List<Resource> queryResourceByTypeAndGroup(@Param("typeId") int typeId,@Param("groupId") int groupId);
}
