package com.xymc.ssmdemo.service.impl;

import com.xymc.ssmdemo.bean.Person;
import com.xymc.ssmdemo.dao.PersonDao;
import com.xymc.ssmdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;
    @Override
    public List<Person> findAll() {
        System.out.println("PersonServiceImpl:findAll()");
        return personDao.findAll();
    }

    @Override
    public void savePerson(Person person) {
        System.out.println("PersonServiceImpl:savePerson()");
        personDao.savePerson(person);
    }

    @Override
    public Person findById(Long id) {
        return personDao.findById(id);
    }
}
