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

    /**
     * 修改用户的密码
     * @param email
     * @param newPassword
     * @return
     */
    int modifyPassword(@Param("email") String email, @Param("newPassword") String newPassword);
}
