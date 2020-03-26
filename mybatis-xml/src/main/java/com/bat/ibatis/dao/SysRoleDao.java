package com.bat.ibatis.dao;

import com.bat.ibatis.po.SysRolePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统角色 Dao
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:58
 **/
public interface SysRoleDao {

    /**
     * 获取系统人员的角色列表
     *
     * @param userUuid 系统用户UUID
     * @return java.util.List<com.bat.ibatis.po.SysRolePO>
     * @author ZhengYu
     */
    List<SysRolePO> getSysRoleByUserUuid(@Param("userUuid") String userUuid);

    int insertSysRole(SysRolePO sysRolePO);
}
