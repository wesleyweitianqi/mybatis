package com.example.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {
  private static SqlSessionFactory sqlSessionFactory = null;
  static {
    Reader reader = null;
    try {
      reader = Resources.getResourceAsReader("mybatis-config.xml");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }catch(IOException e){
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
      throw new ExceptionInInitializerError(e);
    }
  }

  public static SqlSession openSession() {
    return sqlSessionFactory.openSession();
  }

  public static void closeSession(SqlSession session) {
    if (session != null) {
      session.close();
    }
  }
}
