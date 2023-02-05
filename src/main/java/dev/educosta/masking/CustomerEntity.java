package dev.educosta.masking;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String documentNumber;

    @Column
    private int age;

    @Column
    private String zipCode;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private int number;


}
