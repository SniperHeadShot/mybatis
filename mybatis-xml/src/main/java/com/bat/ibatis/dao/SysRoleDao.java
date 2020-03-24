package com.bat.ibatis.dao;

import com.bat.ibatis.po.SysRolePO;

/**
 * 系统角色 Dao
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:58
 **/
public interface SysRoleDao {

    SysRolePO getSysRoleList();

    int insertSysRole(SysRolePO sysRolePO);
}
