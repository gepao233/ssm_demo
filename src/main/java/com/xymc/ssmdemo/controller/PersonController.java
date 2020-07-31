package com.xymc.ssmdemo.controller;

import com.xymc.ssmdemo.bean.Person;
import com.xymc.ssmdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(path = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(path = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    public HashMap findAll(){
        personService.findAll();
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("persons",personService.findAll());
        return map;
    }

    @RequestMapping(path = "/find",method = RequestMethod.GET)
    @ResponseBody
    public HashMap findById(Long id){
        Person person = personService.findById(id);
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("person",person);
        return map;
    }

    @RequestMapping(path = "/save",method = RequestMethod.POST)
    @ResponseBody
    public HashMap savePerson(@RequestBody Person person){
        personService.savePerson(person);
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",200);
        return map;
    }
}
