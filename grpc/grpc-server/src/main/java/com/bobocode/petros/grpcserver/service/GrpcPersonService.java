package com.bobocode.petros.grpcserver.service;

import com.bobocode.petros.grpcserver.domain.Person;
import com.bobocode.petros.proto.MultiplePersonResponse;
import com.bobocode.petros.proto.PersonRequest;
import com.bobocode.petros.proto.PersonResponse;
import com.bobocode.petros.proto.PersonServiceGrpc;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;


@RequiredArgsConstructor
@GrpcService
public class GrpcPersonService extends PersonServiceGrpc.PersonServiceImplBase {
    private final RandomPersonService randomPersonService;

    @Override
    public void getSinglePerson(Empty request, StreamObserver<PersonResponse> responseObserver) {
        var person = randomPersonService.randomPerson();
        responseObserver.onNext(toPersonResponse(person));
        responseObserver.onCompleted();
    }

    @Override
    public void getMultiplePersons(PersonRequest request, StreamObserver<MultiplePersonResponse> responseObserver) {
        var persons = randomPersonService.randomPersonList(request.getNumber());
        responseObserver.onNext(MultiplePersonResponse.newBuilder()
                .addAllPersons(persons.stream()
                        .map(this::toPersonResponse)
                        .toList())
                .build());
        responseObserver.onCompleted();
    }

    private PersonResponse toPersonResponse(Person person) {
        return PersonResponse.newBuilder()
                .setFirstName(person.getFirstName())
                .setLastName(person.getLastName())
                .setAge(person.getAge())
                .setEmail(person.getEmail())
                .setDateOfBirth(Timestamp.newBuilder()
                        .setSeconds(person.getDateOfBirth().toEpochDay())
                        .build())
                .build();
    }
}
