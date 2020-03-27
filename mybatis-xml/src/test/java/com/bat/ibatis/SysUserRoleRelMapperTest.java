package com.bat.ibatis;

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
     * 系统人员与角色关系添加
     */
    @Test
    public void testInsertSysUserRoleRel() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysUserRoleRelDao sysUserRoleRelDao = sqlSession.getMapper(SysUserRoleRelDao.class);
        sysUserRoleRelDao.insertSysUserRoleRel(new SysUserRoleRelPO("867710b8451d4640bab56e87cac637ce","5e1b1d72a67f4128ace0143d8bd3b2ce"));
        sqlSession.commit();
        log.info("系统人员与角色关系添加成功!");
    }
}
