package com.example.prog4.cnapsrepo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "\"employee\"")
public class EmployeeCnapsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;
    private String cin;
    private String cnaps;
    private String image;
    private String address;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "personal_email")
    private String personalEmail;

    @Column(name = "professional_email")
    private String professionalEmail;

    @Column(name = "registration_number")
    private String registrationNumber;


    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "entrance_date")
    private LocalDate entranceDate;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "children_number")
    private Integer childrenNumber;
}
