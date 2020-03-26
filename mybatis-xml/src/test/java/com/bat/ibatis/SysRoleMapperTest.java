package com.bat.ibatis;

import com.alibaba.fastjson.JSONObject;
import com.bat.ibatis.dao.SysRoleDao;
import com.bat.ibatis.po.SysRolePO;
import com.bat.ibatis.util.TimeUtil;
import com.bat.ibatis.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 23:07
 **/
@Slf4j
public class SysRoleMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
            resourceAsReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 获取系统人员的角色列表
     */
    @Test
    public void testGetSysRoleList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysRoleDao sysRoleDao = sqlSession.getMapper(SysRoleDao.class);
        List<SysRolePO> sysRoleList = sysRoleDao.getSysRoleByUserUuid("9284fd9ded1b4421a6c21d2da097186c");
        log.info("获取系统人员的角色列表查询结果 ==> [{}]", JSONObject.toJSONString(sysRoleList));
    }

    /*
     * 系统角色添加
     */
    @Test
    public void testInsertSysRole() {
        List<SysRolePO> sysUserList = new ArrayList<SysRolePO>(3) {{
            add(new SysRolePO(UuidUtil.createUuid(), "超级管理员", TimeUtil.getLocalDateTime()));
            add(new SysRolePO(UuidUtil.createUuid(), "运维管理员", TimeUtil.getLocalDateTime()));
            add(new SysRolePO(UuidUtil.createUuid(), "研发部经理", TimeUtil.getLocalDateTime()));
            add(new SysRolePO(UuidUtil.createUuid(), "研发部成员", TimeUtil.getLocalDateTime()));
            add(new SysRolePO(UuidUtil.createUuid(), "测试部成员", TimeUtil.getLocalDateTime()));
        }};

        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysRoleDao sysRoleDao = sqlSession.getMapper(SysRoleDao.class);
        sysUserList.forEach(sysRole -> sysRoleDao.insertSysRole(sysRole));
        sqlSession.commit();
        log.info("系统角色添加成功!");
    }
}
