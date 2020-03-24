package com.bat.ibatis;

import com.alibaba.fastjson.JSONObject;
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
     * 系统角色查询
     */
    @Test
    public void testGetSysRoleList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<SysRolePO> sysRoleList = sqlSession.selectList("getSysRoleList");
        log.info("系统角色查询结果 ==> [{}]", JSONObject.toJSONString(sysRoleList));
    }

    /*
     * 系统角色添加
     */
    @Test
    public void testInsertSysRole() {
        List<SysRolePO> sysUserList = new ArrayList<SysRolePO>(3) {{
            add(new SysRolePO(UuidUtil.createUuid(), "超级管理员", TimeUtil.getLocalDateTime()));
            add(new SysRolePO(UuidUtil.createUuid(), "普通管理员", TimeUtil.getLocalDateTime()));
            add(new SysRolePO(UuidUtil.createUuid(), "普通用户", TimeUtil.getLocalDateTime()));
        }};

        SqlSession sqlSession = sqlSessionFactory.openSession();
        sysUserList.forEach(sysRole -> sqlSession.insert("insertSysRole", sysRole));
        sqlSession.commit();
        log.info("系统角色添加成功!");
    }
}
