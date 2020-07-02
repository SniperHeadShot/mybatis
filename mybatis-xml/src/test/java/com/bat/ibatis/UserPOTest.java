package com.bat.ibatis;

import com.bat.ibatis.dao.UserPOMapper;
import com.bat.ibatis.entity.UserPO;
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
     * 测试 - 查询
     *
     * @author ZhengYu
     */
    @Test
    public void testQueryList() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        UserPOMapper userDao = sqlSession.getMapper(UserPOMapper.class);
        // TODO 此分页插件无效
        Page<Object> startPage = PageHelper.startPage(1, 10);
        List<UserPO> userList = userDao.queryUserList(null);
        log.info("查询到的用户数: [{}], 总数: [{}]", userList == null ? 0 : userList.size(), startPage.getTotal());
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
