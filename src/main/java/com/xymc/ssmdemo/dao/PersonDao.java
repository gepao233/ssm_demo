package com.xymc.ssmdemo.dao;

import com.xymc.ssmdemo.bean.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonDao {

    //查询所有用户
    @Select("select * from tb_person")
    List<Person> findAll();

    //保存用户
    @Insert("insert into tb_person (id,name,age,job) values (#{id},#{name},#{age},#{job})")
    void savePerson(Person person);

    //根据id查询用户
    Person findById(Long id);

}
