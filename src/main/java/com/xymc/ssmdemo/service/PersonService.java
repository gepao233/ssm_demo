package com.xymc.ssmdemo.service;

import com.xymc.ssmdemo.bean.Person;

import java.util.List;

public interface PersonService {
    //查询所有用户
    List<Person> findAll();
    //保存用户
    void savePerson(Person person);
    //根据id查用户
    Person findById(Long id);
}
