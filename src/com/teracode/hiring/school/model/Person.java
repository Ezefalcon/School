package com.teracode.hiring.school.model;

import java.time.LocalDate;

public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected int dni;
    protected LocalDate birthDate;

    public Person(String firstName, String lastName, int dni, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.birthDate = birthDate;
    }

    public abstract String getLastName();
}
