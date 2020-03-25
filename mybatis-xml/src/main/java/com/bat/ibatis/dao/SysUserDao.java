package com.bat.ibatis.dao;

import com.bat.ibatis.po.SysUserCondition;
import com.bat.ibatis.po.SysUserPO;

import java.util.List;

/**
 * 系统人员 Dao
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:58
 **/
public interface SysUserDao {

    List<SysUserPO> getSysUserList(SysUserCondition sysUserCondition);

    int insertSysUser(SysUserPO sysUserPO);

    int updateSysUser(SysUserPO sysUserPO);
}
