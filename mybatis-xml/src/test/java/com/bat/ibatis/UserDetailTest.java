package com.bat.ibatis;

import com.bat.ibatis.dao.UserDetailPOMapper;
import com.bat.ibatis.dao.UserPOMapper;
import com.bat.ibatis.entity.UserDetailPO;
import com.bat.ibatis.util.SqlSessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 测试 {@link UserPOMapper}
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 23:07
 **/
@Slf4j
public class UserDetailTest {

    private static final String USER_UUID = "440db2543c5544bca7ca29324769bcd3";

    /**
     * 测试 - 查询{@link org.apache.ibatis.builder.xml.XMLMapperBuilder#parse()}
     *
     * @author ZhengYu
     */
    @Test
    public void testQueryList() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        UserDetailPOMapper userDetailDao = sqlSession.getMapper(UserDetailPOMapper.class);
        List<UserDetailPO> userDetailList = userDetailDao.queryUserDetailList(USER_UUID);
        log.info("查询用户 [{}] 的属性列表: [{}]", USER_UUID, userDetailList == null ? 0 : userDetailList.size());
    }

    /**
     * 测试 - 插入
     *
     * @author ZhengYu
     */
    @Test
    public void testBatchInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        UserDetailPOMapper userDetailDao = sqlSession.getMapper(UserDetailPOMapper.class);

        UserDetailPO userDetailPO = new UserDetailPO();
        userDetailPO.setUserUuid(USER_UUID);
        userDetailPO.setGroup("base");
        userDetailPO.setAttributeKey("sex");
        userDetailPO.setAttributeValue("male");

        int count = userDetailDao.insertUserDetail(userDetailPO);
        sqlSession.commit();
        log.info("批量插入: [{}] 条用户详情数据", count);
    }
}
