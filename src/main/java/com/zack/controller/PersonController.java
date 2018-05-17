package com.zack.controller;

import com.zack.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @RequestMapping("/list")
    public List<Person> list() {
        List<Person> list = new ArrayList<>();

        Person person1 = new Person();
        Person person2 = new Person();
        person1.setName("person1");
        person2.setName("person2");

        list.add(person1);
        list.add(person2);
        return list;
    }

    @RequestMapping("/detail")
    public Person detail(Integer id) {
        Person person = new Person();
        person.setName("detail1");

        return person;
    }
}
