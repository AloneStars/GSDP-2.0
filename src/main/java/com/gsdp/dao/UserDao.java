package com.gsdp.dao;

import com.gsdp.entity.user.User;
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

    /**
     * 通过email来获取用户信息
     * @param email
     * @return
     */
    User queryUserByEmail(String email);

    /**
     * 单纯获取用户信息
     * @param email
     * @return
     */
    User queryUserMsgByEmail(String email);

    /**
     * 注册用户
     * @param user
     * @return
     */
    int registerUser(User user);
}
