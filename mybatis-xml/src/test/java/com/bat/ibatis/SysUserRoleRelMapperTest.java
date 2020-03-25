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
        SysUserRoleRelPO userRoleRel = sysUserRoleRelDao.getSysUserRoleRel("b317548a06f940e1861e40d6604ab304");
        log.info("系统人员与角色关系查询 ==> [{}]", JSONObject.toJSONString(userRoleRel));
    }

    /*
     * 系统人员与角色关系添加
     */
    @Test
    public void testInsertSysUserRoleRel() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysUserRoleRelDao sysUserRoleRelDao = sqlSession.getMapper(SysUserRoleRelDao.class);
        sysUserRoleRelDao.insertSysUserRoleRel(new SysUserRoleRelPO("b317548a06f940e1861e40d6604ab304","a2246b493a35428dafa026cf78f2ba71"));
        sqlSession.commit();
        log.info("系统人员与角色关系添加成功!");
    }
}
