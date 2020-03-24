package com.bat.ibatis;

import com.alibaba.fastjson.JSONObject;
import com.bat.ibatis.dao.SysUserDao;
import com.bat.ibatis.po.SysUserPO;
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
public class SysUserMapperTest {

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
     * 系统人员查询
     */
    @Test
    public void testGetSysUserList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysUserDao sysUserDao = sqlSession.getMapper(SysUserDao.class);
        List<SysUserPO> sysUserList = sysUserDao.getSysUserList();
        log.info("系统人员查询结果 ==> [{}]", JSONObject.toJSONString(sysUserList));
    }

    /*
     * 系统人员添加
     */
    @Test
    public void testInsertSysUser() {
        List<SysUserPO> sysUserList = new ArrayList<SysUserPO>(3) {{
            add(new SysUserPO(UuidUtil.createUuid(), "张三", "111111", TimeUtil.getLocalDateTime()));
            add(new SysUserPO(UuidUtil.createUuid(), "李四", "222222", TimeUtil.getLocalDateTime()));
            add(new SysUserPO(UuidUtil.createUuid(), "王五", "333333", TimeUtil.getLocalDateTime()));
            add(new SysUserPO(UuidUtil.createUuid(), "赵六", "444444", TimeUtil.getLocalDateTime()));
        }};

        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysUserDao sysUserDao = sqlSession.getMapper(SysUserDao.class);
        sysUserList.forEach(sysUser -> sysUserDao.insertSysUser(sysUser));
        sqlSession.commit();
        log.info("系统角色添加成功!");
    }
}
