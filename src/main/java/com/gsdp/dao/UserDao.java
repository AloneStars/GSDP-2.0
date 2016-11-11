package com.gsdp.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author yizijun
 *
 */
public interface UserDao {

    /**
     * 修改用户的头像
     * @param userId
     * @param headPicture
     * @return
     */
	int changeHeadPicture(@Param("userId") int userId, @Param("headPicture") String headPicture);
}
