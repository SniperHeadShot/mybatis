package com.bat.ibatis.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * SqlSession
 *
 * @author ZhengYu
 * @version 1.0 2020/3/27 14:10
 **/
@Slf4j
public class SqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (IOException e) {
            log.error("读取mybatis配置失败[{}] [{}]", e.getMessage(), e);
        }
    }

    public static SqlSession openSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
