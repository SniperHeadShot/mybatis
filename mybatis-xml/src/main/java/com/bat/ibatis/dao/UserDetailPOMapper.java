package com.bat.ibatis.dao;

import com.bat.ibatis.entity.UserDetailPO;

import java.util.List;

public interface UserDetailPOMapper {

    List<UserDetailPO> queryUserDetailList(String userUuid);

    int insertUserDetail(UserDetailPO userDetail);
}