package com.gsdp.service;

import com.gsdp.entity.group.Situation;
import com.gsdp.exception.situation.SituationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/6 创造的作品
 * ********************************************************
 * +描述:动态相关的服务层
 *********************************************************/
public interface SituationService {

    /**
     * 添加一条动态
     * @param situation
     * @return
     */
    boolean addSituation(Situation situation);

    /**
     * 删除一条动态
     * @param situationId
     * @return
     */
    boolean deleteSituation(int situationId);

    /**
     * 获取一条动态的详细信息，包括回复
     * @param situationId 动态Id
     * @param offset  偏移量
     * @param limit   查询数量
     * @return
     */
    Situation getSingleSituationMessage(int situationId,int offset,int limit);

    /**
     * 根据给出的信息获取相关动态
     * @param groupId  组织Id
     * @param offset  偏移量
     * @param limit   查询数量
     * @param order   查询字段
     * @param type    排序方式
     * @return
     */
    List<Situation> getSituationMessage(int groupId, int offset, int limit, String order, boolean type);


    /**
     *
     * @param userId
     * @param groupId
     * @param situationTitle
     * @param situationContent
     * @return
     * @throws IllegalArgumentException
     * @throws SituationException
     */
    Integer publishSituation(int userId, int groupId, String situationTitle, String situationContent)
            throws IllegalArgumentException, SituationException;

    /**
     * 浏览记录+1
     * @param situationId
     * @return
     */
    boolean addSituationVisitors(int situationId);
}
