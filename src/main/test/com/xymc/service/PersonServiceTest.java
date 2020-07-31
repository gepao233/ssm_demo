package com.xymc.service;

import com.xymc.ssmdemo.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonServiceTest {
    /**
     * 测试spring配置文件的可用性
     */
    @Test
    public void test1(){
        //加载spring配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-service.xml");
        //获取对象
        PersonService bean = applicationContext.getBean(PersonService.class);
        //调用方法
        bean.findAll();
    }
}
