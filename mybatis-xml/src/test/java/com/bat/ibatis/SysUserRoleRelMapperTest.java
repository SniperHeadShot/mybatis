package com.bat.ibatis;

import com.alibaba.fastjson.JSONObject;
import com.bat.ibatis.dao.SysUserRoleRelDao;
import com.bat.ibatis.po.SysUserRoleRelPO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * 测试
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 23:07
 **/
@Slf4j
public class SysUserRoleRelMapperTest {

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
     * 系统人员与角色关系查询
     */
    @Test
    public void testGetSysUserRoleRel() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysUserRoleRelDao sysUserRoleRelDao = sqlSession.getMapper(SysUserRoleRelDao.class);
        List<SysUserRoleRelPO> userRoleRelList = sysUserRoleRelDao.getSysUserRoleRel("9ccb528ad22340198a13e2e82a75f9f6");
        log.info("系统人员与角色关系查询 ==> [{}]", JSONObject.toJSONString(userRoleRelList));
    }

    /*
     * 系统人员与角色关系添加
     */
    @Test
    public void testInsertSysUserRoleRel() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysUserRoleRelDao sysUserRoleRelDao = sqlSession.getMapper(SysUserRoleRelDao.class);
        sysUserRoleRelDao.insertSysUserRoleRel(new SysUserRoleRelPO("9ccb528ad22340198a13e2e82a75f9f6","1e1f953ddc2b480c8b32719a0b36a2e7"));
        sqlSession.commit();
        log.info("系统人员与角色关系添加成功!");
    }
}
