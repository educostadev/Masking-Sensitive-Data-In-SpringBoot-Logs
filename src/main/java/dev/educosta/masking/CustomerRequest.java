package dev.educosta.masking;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    private String name;

    private String documentNumber;

    private int age;

    private String zipCode;

    private String street;

    private String city;

    private int number;


}
