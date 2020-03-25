package com.bat.ibatis.dao;

import com.bat.ibatis.po.SysUserRoleRelPO;

import java.util.List;

/**
 * 系统人员与角色关系 Dao
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:58
 **/
public interface SysUserRoleRelDao {

    List<SysUserRoleRelPO> getSysUserRoleRel(String userUuid);

    int insertSysUserRoleRel(SysUserRoleRelPO sysUserRoleRelPO);
}
