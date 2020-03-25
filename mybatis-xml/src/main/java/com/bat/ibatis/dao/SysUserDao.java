package com.bat.ibatis.dao;

import com.bat.ibatis.po.SysUserCondition;
import com.bat.ibatis.po.SysUserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统人员 Dao
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:58
 **/
public interface SysUserDao {

    /**
     * 获取系统人员列表
     *
     * @param sysUserCondition 检索条件
     * @return java.util.List<com.bat.ibatis.po.SysUserPO>
     * @author ZhengYu
     */
    List<SysUserPO> getSysUserList(SysUserCondition sysUserCondition);

    /**
     * 新增系统人员
     *
     * @param sysUserPO 系统人员
     * @return int
     * @author ZhengYu
     */
    int insertSysUser(SysUserPO sysUserPO);

    int batchInsertSysUser(@Param("sysUserList") List<SysUserPO> sysUserList);

    /**
     * 修改系统人员
     *
     * @param sysUserPO 系统人员
     * @return int
     * @author ZhengYu
     */
    int updateSysUser(SysUserPO sysUserPO);
}
