package com.example.mybatis;

import java.io.Reader;
import java.sql.Connection;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.example.mybatis.entity.CourseMapper;

/**
 * Unit test for simple App.
 */
public class mybatisTest {

    @Test
    public void testSqlSessionFactory() {
        SqlSession sqlSession = null;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            System.out.println("SessionFactory loading successfully");

            sqlSession = sqlSessionFactory.openSession();

            Connection connection = sqlSession.getConnection();
            CourseMapper  courseMapper = sqlSession.getMapper(CourseMapper.class);
            courseMapper.getAllCourse();
            System.out.println(connection);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {

                sqlSession.close();
            }
        }
    }
}
