package com.bat.ibatis;

import com.bat.ibatis.dao.UserPOMapper;
import com.bat.ibatis.entity.UserPO;
import com.bat.ibatis.entity.UserQuery;
import com.bat.ibatis.util.SqlSessionUtil;
import com.bat.ibatis.util.UuidUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 测试 {@link com.bat.ibatis.dao.UserPOMapper}
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 23:07
 **/
@Slf4j
public class UserPOTest {

    /**
     * 测试 - 查询 - 一级缓存
     *
     * @author ZhengYu
     */
    @Test
    public void testQueryOneLevelCacheList() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        UserPOMapper userDao = sqlSession.getMapper(UserPOMapper.class);
        // TODO 此分页插件无效
        Page<Object> startPage = PageHelper.startPage(1, 10);
        UserQuery userQuery = new UserQuery();
        userQuery.setUserUuidList(new ArrayList<String>(2) {{
            add("259b337b86ad4440ba8cdc1525cfea6e");
            add("ceafd0fbbecd4002b7fb6e9e680f819c");
            add("73b1d0d9442a4254a9630be8a087bf5e");
        }});

        // 第一次获取
        List<UserPO> result1 = userDao.queryUserList(userQuery);
        log.info("第1次查询到的用户数: [{}], 总数: [{}]", result1 == null ? 0 : result1.size(), startPage.getTotal());

        // 第二次获取
        List<UserPO> result2 = userDao.queryUserList(userQuery);
        log.info("第2次查询到的用户数: [{}], 总数: [{}]", result2 == null ? 0 : result2.size(), startPage.getTotal());

        log.info("第一次与第二次的结果是否相等: [{}]", result1 == result2);
        sqlSession.close();
    }

    /**
     * 测试 - 查询 - 二级缓存
     *
     * @author ZhengYu
     */
    @Test
    public void testQueryTwoLevelCacheList() {
        UserQuery userQuery = new UserQuery();
        userQuery.setUserUuidList(new ArrayList<String>(2) {{
            add("259b337b86ad4440ba8cdc1525cfea6e");
            add("ceafd0fbbecd4002b7fb6e9e680f819c");
            add("73b1d0d9442a4254a9630be8a087bf5e");
        }});

        List<List<UserPO>> result = new ArrayList<>(3);

        // 测试缓存
        IntStream.rangeClosed(1, 3).forEach(index -> {
            SqlSession sqlSession = SqlSessionUtil.openSqlSession();
            UserPOMapper userDao = sqlSession.getMapper(UserPOMapper.class);
            // TODO 此分页插件无效
            Page<Object> startPage = PageHelper.startPage(1, 10);
            List<UserPO> userList = userDao.queryUserList(userQuery);
            result.add(userList);
            log.info("第 [{}] 次查询到的用户数: [{}], 总数: [{}]", index, userList == null ? 0 : userList.size(), startPage.getTotal());
            sqlSession.close();
        });

        log.info("第一次与第二次的结果是否相等: [{}]", result.get(0) == result.get(1));
    }

    /**
     * 测试 - 批量插入
     *
     * @author ZhengYu
     */
    @Test
    public void testBatchInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        UserPOMapper userDao = sqlSession.getMapper(UserPOMapper.class);
        int count = userDao.batchInsertUser(buildUserList());
        sqlSession.commit();
        log.info("批量插入: [{}] 条用户数据", count);
        sqlSession.close();
    }

    /**
     * 测试 - 删除
     *
     * @author ZhengYu
     */
    @Test
    public void testBatchDelete() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        UserPOMapper userDao = sqlSession.getMapper(UserPOMapper.class);
        int count = userDao.deleteUser(null);
        log.info("删除用户数据: [{}] 条", count);
        sqlSession.commit();
        sqlSession.close();
    }

    private List<UserPO> buildUserList() {
        List<UserPO> userList = new ArrayList<>(100);
        IntStream.rangeClosed(1, 100).forEach(index -> {
            UserPO userPO = new UserPO();
            userPO.setUserUuid(UuidUtil.createUuid());
            userPO.setUserName("user" + String.format("%03d", index));
            userPO.setPassword("123456");
            userList.add(userPO);
        });
        return userList;
    }
}
