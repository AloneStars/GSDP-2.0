package com.gsdp.service.impl;

import com.gsdp.dao.SituationDao;
import com.gsdp.entity.group.Situation;
import com.gsdp.service.SituationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/6 创造的作品
 * ********************************************************
 * +描述:SituationService的实现类
 *********************************************************/
@Service
public class SituationServiceImpl implements SituationService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SituationDao situationDao;

    @Override
    public boolean addSituation(Situation situation) {
        return false;
    }

    @Override
    public boolean deleteSituation(int situationId) {
        return false;
    }

    @Override
    public Situation getSingleSituationMessage(int situationId, int offset, int limit) {
        return null;
    }

    @Override
    public List<Situation> getSituationMessage(int groupId, int offset, int limit, String order, boolean type) {

        List<Situation> situationList = situationDao.getSituationMessage(groupId,offset,limit,order,type);

        logger.info("situationList={}",situationList);

        return situationList;

    }
}
