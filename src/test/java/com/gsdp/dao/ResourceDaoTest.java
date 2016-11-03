package com.gsdp.dao;

import com.gsdp.entity.group.Resource;
import com.gsdp.entity.staticData.FileType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/2 创造的作品
 * ********************************************************
 * +描述:FileDao的测试类
 *********************************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ResourceDaoTest {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @javax.annotation.Resource(name = "resourceDao")
    private ResourceDao resourceDao;

    @Test
    public void addResource() throws Exception {

         int resourceType = FileType.EXCEL;
         String resourceName = "星空摄影视频";
         String resourceSrc = "file/videl/star";
         int updater = 1;
         String updateTime = "2016.11.2";
         int groupId = 3;
         int permission = 1;

        Resource resource = new Resource(resourceName,resourceSrc,resourceType,updater,updateTime,groupId,permission);

         int affectRows = resourceDao.addResource(resource);

         logger.info("影响的行数："+affectRows+";返回对象的自增Id:"+resource.getResourceId());

    }

    @Test
    public void deleteResource() throws Exception {

        int resourceId = 6;

        int affectRows = resourceDao.deleteResource(resourceId);

        logger.info("影响的行数："+affectRows);

    }

    @Test
    public void updateResource() throws Exception {

        int resourceId = 6;
        int resourceType = FileType.PPT;
        String resourceName = "星空摄影视频";
        String resourceSrc = "file/videl/star";
        int updater = 1;
        String updateTime = "2016.11.3";
        int groupId = 3;
        int permission = 1;

        Resource resource = new Resource(resourceId,resourceName,resourceSrc,resourceType,updater,updateTime,groupId,permission);

        int affectRows = resourceDao.updateResource(resource);

        logger.info("影响的行数："+affectRows);

    }

    @Test
    public void queryAllResource() throws Exception {

        List<Resource> resourceList = resourceDao.queryAllResource();

        logger.info("resourceList={}",resourceList);
    }

    @Test
    public void queryResourceByType() throws Exception {

        List<Resource> resourceList = resourceDao.queryResourceByType(FileType.EXCEL);

        logger.info("resourceList={}",resourceList);

    }

    @Test
    public void queryResourceByTypeAndGroup() throws Exception {

        List<Resource> resourceList = resourceDao.queryResourceByTypeAndGroup(FileType.VIDEO,3);

        logger.info("resourceList={}",resourceList);

    }

}