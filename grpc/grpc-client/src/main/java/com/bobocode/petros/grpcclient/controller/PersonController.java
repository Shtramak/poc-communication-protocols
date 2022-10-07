package com.bobocode.petros.grpcclient.controller;

import com.bobocode.petros.grpcclient.domain.Person;
import com.bobocode.petros.grpcclient.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("persons")
public class PersonController {
    private final PersonService service;

    @GetMapping("/single")
    public Person getSinglePerson() {
        return service.getSinglePerson();
    }

    @GetMapping
    public List<Person> getPersonList(@RequestParam(required = false, defaultValue = "10") Integer number) {
        return service.getPersons(number);
    }
}
