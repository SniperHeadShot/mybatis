package com.bat.ibatis.dao;

import com.bat.ibatis.po.SysRolePO;

import java.util.List;

/**
 * 系统角色 Dao
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:58
 **/
public interface SysRoleDao {

    List<SysRolePO> getSysRoleList();

    SysRolePO getSysRole(String userUuid);

    int insertSysRole(SysRolePO sysRolePO);
}
