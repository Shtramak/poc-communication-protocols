package com.bobocode.petros.grpcserver.service;

import com.bobocode.petros.grpcserver.domain.Person;
import com.devskiller.jfairy.Fairy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class RandomPersonService {
    private final Fairy fairyPerson;

    public Person randomPerson() {
        var person = fairyPerson.person();
        return Person.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .age(person.getAge())
                .dateOfBirth(person.getDateOfBirth())
                .build();
    }

    public List<Person> randomPersonList(int number) {
        return IntStream.range(0, number)
                .boxed()
                .map(i -> randomPerson())
                .collect(Collectors.toList());
    }
}
