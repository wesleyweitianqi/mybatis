package com.example.mybatis;

import static org.junit.Assert.assertTrue;

import java.io.Reader;
import java.sql.Connection;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testSqlSessionFactory() {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        System.out.println("SessionFactory加载成功");
        SqlSession sqlSession = null;
        try {

            sqlSession = sqlSessionFactory.openSession();

            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {

                sqlSession.close();
            }
        }
    }
}
