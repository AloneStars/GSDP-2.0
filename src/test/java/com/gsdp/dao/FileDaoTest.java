package com.gsdp.dao;

import com.gsdp.entity.group.File;
import com.gsdp.entity.staticData.FileType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
public class FileDaoTest {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "fileDao")
    private FileDao fileDao;

    @Test
    public void addFile() throws Exception {

         int fileType = FileType.EXCEL;
         String fileName = "星空摄影视频";
         String fileSrc = "file/videl/star";
         int updater = 1;
         String updateTime = "2016.11.2";
         int groupId = 3;
         int permission = 1;

         File file = new File(fileType,fileName,fileSrc,updater,updateTime,groupId,permission);

         int affectRows = fileDao.addFile(file);

         logger.info("影响的行数："+affectRows+";返回对象的自增Id:"+file.getFileId());

    }

    @Test
    public void deleteFile() throws Exception {

        int fileId = 2;

        int affectRows = fileDao.deleteFile(fileId);

        logger.info("影响的行数："+affectRows);

    }

    @Test
    public void updateFile() throws Exception {

        int fileId = 3;
        int fileType = FileType.EXCEL;
        String fileName = "星空摄影视频";
        String fileSrc = "file/videl/star.mp4";
        int updater = 1;
        String updateTime = "2016.11.2";
        int groupId = 3;
        int permission = 1;

        File file = new File(fileId,fileType,fileName,fileSrc,updater,updateTime,groupId,permission);

        int affectRows = fileDao.updateFile(file);

        logger.info("影响的行数："+affectRows);

    }

    @Test
    public void queryAllFile() throws Exception {

        List<File> fileList = fileDao.queryAllFile();

        logger.info("fileList={}",fileList);
    }

    @Test
    public void queryFileByType() throws Exception {

        List<File> fileList = fileDao.queryFileByType(FileType.EXCEL);

        logger.info("fileList={}",fileList);

    }

    @Test
    public void queryFileByTypeAndGroup() throws Exception {

        List<File> fileList = fileDao.queryFileByTypeAndGroup(FileType.VIDEO,3);

        logger.info("fileList={}",fileList);

    }

}