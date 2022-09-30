package com.bobocode.petros.openapiserver.controller;

import com.bobocode.petros.openapi.client.api.PersonApiApi;
import com.bobocode.petros.openapi.client.model.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class RandomPersonClientController {
    private final PersonApiApi personApi;

    @GetMapping("/single")
    public PersonDto randomPerson() {
        return personApi.personsSingleGet();
    }

    @GetMapping
    public List<PersonDto> randomPersonList(@RequestParam(required = false, defaultValue = "10") Integer number) {
        return personApi.personsGet(number);
    }
}
