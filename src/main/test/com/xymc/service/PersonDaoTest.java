package com.xymc.service;

import com.xymc.ssmdemo.bean.Person;
import com.xymc.ssmdemo.dao.PersonDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class PersonDaoTest {
    @Test
    public void testFindAll() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        PersonDao mapper = sqlSession.getMapper(PersonDao.class);
        mapper.findAll().forEach(System.out::println);
        //关闭资源
        sqlSession.clearCache();
        resourceAsStream.close();
    }
    @Test
    public void testSave() throws IOException {

        Person person = new Person();
        person.setId(5l);
        person.setName("gepao");
        person.setAge(20);
        person.setJob("ccc");

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        PersonDao mapper = sqlSession.getMapper(PersonDao.class);
        mapper.savePerson(person);
        // 提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.clearCache();
        resourceAsStream.close();

    }
    @Test
    public void test3(){
        //加载spring配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
        PersonDao bean = applicationContext.getBean(PersonDao.class);
        bean.findAll().forEach(System.out::println);
    }
}
