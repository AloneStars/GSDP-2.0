package com.gsdp.dao;

import org.apache.ibatis.annotations.Param;

import com.gsdp.entity.user.News;

import java.util.List;

/**
 * 
 * @author yizijun
 *
 */
public interface NewsDao {
	
	/**
	 * 添加新消息
	 * @param news
	 * @return
	 */
	int addNews(News news);

	/**
	 * 批量的添加消息
	 * @param news
	 * @return
	 */
	int batchAddNew(List<News> news);
	
	/**
	 * 删除消息
	 * @param newsId
	 * @return
	 */
	int deleteNews(int newsId);
	
	/**
	 * 修改消息的阅读状态
	 * @param statue
	 * @param newsId
	 * @return
	 */
	int changeNewsStatue(@Param("statue") int statue, @Param("newsId") int newsId);

	/**
	 * 获取该用户收到的所有消息
	 * @param toAddress
	 * @return
     */
	List<News> getNewsListByToAddress(int toAddress);

}
