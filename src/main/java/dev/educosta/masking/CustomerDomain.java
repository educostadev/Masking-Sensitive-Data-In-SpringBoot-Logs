package dev.educosta.masking;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CustomerDomain {

    private final UUID id;

    private final String name;

    private final String documentNumber;

    private final int age;

    private final Address address;

    @AllArgsConstructor
    @Getter
    public static class Address {

        private final String zipCode;

        private final String street;

        private final String city;

        private final int number;

    }


}
