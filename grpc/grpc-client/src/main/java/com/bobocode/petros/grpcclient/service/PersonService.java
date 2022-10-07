package com.bobocode.petros.grpcclient.service;

import com.bobocode.petros.grpcclient.domain.Person;
import com.bobocode.petros.proto.PersonRequest;
import com.bobocode.petros.proto.PersonResponse;
import com.bobocode.petros.proto.PersonServiceGrpc;
import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    @GrpcClient("person-service")
    private PersonServiceGrpc.PersonServiceBlockingStub grpcPersonService;

    public Person getSinglePerson() {
        var grpcPerson = grpcPersonService.getSinglePerson(Empty.newBuilder().build());
        return toDomainPerson(grpcPerson);
    }

    private Person toDomainPerson(PersonResponse grpcPerson) {
        var person = new ModelMapper().map(grpcPerson, Person.class);
        var dateOfBirthTimeStamp = grpcPerson.getDateOfBirth();
        person.setDateOfBirth(Instant
                .ofEpochSecond(dateOfBirthTimeStamp.getSeconds(), dateOfBirthTimeStamp.getNanos())
                .atZone(ZoneOffset.UTC)
                .toLocalDate());
        return person;
    }

    public List<Person> getPersons(int number) {
        var request = PersonRequest.newBuilder()
                .setNumber(number)
                .build();
        var multiplePersons = grpcPersonService.getMultiplePersons(request);

        return multiplePersons.getPersonsList()
                .stream()
                .map(grpcPerson -> toDomainPerson(grpcPerson))
                .collect(Collectors.toList());
    }
}
