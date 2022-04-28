package com.hbsi.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory factory=null;

    static {
        //创建SqlSessionFactory对象
        String config="mybatis-config.xml";
        InputStream is= null;
        try {
            is = Resources.getResourceAsStream(config);
            factory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static SqlSession getSession(){
        SqlSession sqlSession =null;
        if(factory!=null){
            sqlSession=factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }

}

