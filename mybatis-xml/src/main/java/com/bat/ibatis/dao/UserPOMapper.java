package com.bat.ibatis.dao;

import com.bat.ibatis.entity.UserDelete;
import com.bat.ibatis.entity.UserPO;
import com.bat.ibatis.entity.UserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Dao
 *
 * @author ZhengYu
 * @version 1.0 2020/7/2 23:43
 **/
public interface UserPOMapper {

    /**
     * 查询用户列表
     *
     * @param userQuery 查询条件
     * @author ZhengYu
     */
    List<UserPO> queryUserList(UserQuery userQuery);

    /**
     * 批量插入用户
     *
     * @param userList 用户列表
     * @return int
     * @author ZhengYu
     */
    int batchInsertUser(@Param("userList") List<UserPO> userList);

    /**
     * 更新用户数据
     *
     * @param user 用户
     * @author ZhengYu
     */
    int updateUser(UserPO user);

    /**
     * 删除用户数据
     *
     * @param userDelete 用户
     * @author ZhengYu
     */
    int deleteUser(UserDelete userDelete);
}