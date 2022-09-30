package com.bobocode.petros.openapiserver.controller;

import com.bobocode.petros.openapi.controller.PersonsApi;
import com.bobocode.petros.openapi.model.PersonDto;
import com.bobocode.petros.openapiserver.service.RandomPersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RandomPersonController implements PersonsApi {

    private final RandomPersonService service;

    @Override
    public ResponseEntity<List<PersonDto>> personsGet(Integer number) {
        return ResponseEntity.ok(
                service.randomPersonList(number)
                        .stream()
                        .map(person -> new ModelMapper().map(person, PersonDto.class))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<PersonDto> personsSingleGet() {
        return ResponseEntity.ok(
                new ModelMapper().map(service.randomPerson(), PersonDto.class)
        );
    }
}
