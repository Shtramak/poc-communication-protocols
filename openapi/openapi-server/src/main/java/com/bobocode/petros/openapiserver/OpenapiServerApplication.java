package com.bobocode.petros.openapiserver;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.RandomGenerator;
import com.devskiller.jfairy.producer.person.DefaultPersonProvider;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.person.PersonFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class OpenapiServerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(OpenapiServerApplication.class, args);
        Fairy fairy = Fairy.create();
        var people = IntStream.rangeClosed(0, 10)
                .boxed()
                .map(i -> fairy.person())
                .toList();
    }

}
