package com.gsdp.dao;

import com.gsdp.entity.user.User;
import org.apache.ibatis.annotations.Param;

/**
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
     * 根据用户id来查询用户的基本信息
     * @param userId
     * @return
     */
    User queryUserMessageById(int userId);

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

    /**
     *根据用户的userId来更新用户的信息
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 验证成员身份
     * @param userId
     * @param groupId
     * @return
     */
    Integer verifyMember(@Param("userId") int userId,@Param("groupId") int groupId);


    /**
     * 验证管理员身份
     * @param userId
     * @param groupId
     * @return
     */
    Integer verifyAdmin(@Param("userId") int userId,@Param("groupId") int groupId);

}
