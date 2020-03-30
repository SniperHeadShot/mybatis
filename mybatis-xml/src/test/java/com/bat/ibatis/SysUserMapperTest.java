package com.bat.ibatis;

import com.alibaba.fastjson.JSONObject;
import com.bat.ibatis.dao.SysUserDao;
import com.bat.ibatis.enums.SysUserTypeEnum;
import com.bat.ibatis.po.SysUserCondition;
import com.bat.ibatis.po.SysUserPO;
import com.bat.ibatis.util.SqlSessionUtil;
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

    /*
     * 系统人员查询
     */
    @Test
    public void testGetSysUserList() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        SysUserDao sysUserDao = sqlSession.getMapper(SysUserDao.class);

        SysUserCondition condition = new SysUserCondition();
        //condition.setUserUuid("b317548a06f940e1861e40d6604ab304");
        //condition.setAccountName("张三");
        condition.setUserUuidList(new ArrayList<String>() {{
            //add("9ccb528ad22340198a13e2e82a75f9f6");
            //add("5c229e18343a4176ad955235d8a4b9ff");
        }});

        List<SysUserPO> sysUserList = sysUserDao.getSysUserList(condition);
        log.info("懒加载查询系统人员角色信息数据 ==> [{}]", JSONObject.toJSONString(sysUserList));
    }

    /*
     * 系统人员添加
     */
    @Test
    public void testInsertSysUser() {
        SysUserPO sysUser = new SysUserPO(UuidUtil.createUuid(), "张三", SysUserTypeEnum.SYSTEM.getCode(), "111111", null, null, TimeUtil.getLocalDateTime());

        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        SysUserDao sysUserDao = sqlSession.getMapper(SysUserDao.class);
        int i = sysUserDao.insertSysUser(sysUser);
        sqlSession.commit();
        log.info("系统人员添加结果 ==> [{}]", i > 0);
    }

    /*
     * 系统人员批量添加
     */
    @Test
    public void testBatchInsertSysUser() {
        List<SysUserPO> sysUserList = new ArrayList<SysUserPO>(3) {{
            add(new SysUserPO(UuidUtil.createUuid(), "李四", SysUserTypeEnum.SYSTEM.getCode(), "222222", null, null, TimeUtil.getLocalDateTime()));
            add(new SysUserPO(UuidUtil.createUuid(), "王五", SysUserTypeEnum.SYSTEM.getCode(), "333333", null, null, TimeUtil.getLocalDateTime()));
            add(new SysUserPO(UuidUtil.createUuid(), "赵六", SysUserTypeEnum.VISITOR.getCode(), "444444", null, null, TimeUtil.getLocalDateTime()));
        }};

        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        SysUserDao sysUserDao = sqlSession.getMapper(SysUserDao.class);
        int i = sysUserDao.batchInsertSysUser(sysUserList);
        sqlSession.commit();
        log.info("系统人员批量添加结果 ==> [{}]", i == sysUserList.size());
    }

    /*
     * 系统人员更新
     */
    @Test
    public void testUpdateSysUser() {
        SysUserPO sysUser = new SysUserPO();
        sysUser.setUserUuid("867710b8451d4640bab56e87cac637ce");
        sysUser.setPhone("13671899478");
        sysUser.setUpdateTime(TimeUtil.getLocalDateTime());

        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        SysUserDao sysUserDao = sqlSession.getMapper(SysUserDao.class);
        int i = sysUserDao.updateSysUser(sysUser);
        sqlSession.commit();
        log.info("系统人员更新结果 ==> [{}]", i > 0);
    }
}
