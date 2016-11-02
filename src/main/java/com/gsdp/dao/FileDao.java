package com.gsdp.dao;

import com.gsdp.entity.group.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/2 创造的作品
 * ********************************************************
 * +描述:文件相关的dao层接口
 *********************************************************/
public interface FileDao {

    /**
     * 添加一个文件
     * @param file
     * @return 影响的行数
     */
    int addFile(File file);

    /**
     * 删除一个文件，根据id
     * @param fileId
     * @return 影响的行数
     */
    int deleteFile(int fileId);

    /**
     * 修改文件相关信息
     * @param file
     * @return 影响的行数
     */
    int updateFile(File file);

    /**
     * 查找所有文件
     * @return List<File>
     */
    List<File> queryAllFile();

    /**
     * 查找所给类型的文件
     * @param typeId
     * @return List<File>
     */
    List<File> queryFileByType(int typeId);

    /**
     * 查找组织类内的相关类型的文件
     * @param typeId
     * @param groupId
     * @return List<File>
     */
    List<File> queryFileByTypeAndGroup(@Param("typeId") int typeId,@Param("groupId") int groupId);
}
