package com.bat.ibatis.dao;

import com.bat.ibatis.entity.UserPO;

public interface UserPOMapper {
    int insert(UserPO record);

    int insertSelective(UserPO record);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}