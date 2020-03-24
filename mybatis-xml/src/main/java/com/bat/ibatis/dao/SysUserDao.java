package com.bat.ibatis.dao;

import com.bat.ibatis.po.SysUserPO;

import java.util.List;

/**
 * 系统角色 Dao
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:58
 **/
public interface SysUserDao {

    List<SysUserPO> getSysUserList();

    int insertSysUser(SysUserPO sysUserPO);
}
