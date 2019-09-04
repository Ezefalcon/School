package com.teracode.hiring.school.model;

import java.time.LocalDate;
import java.util.List;

public class Principal extends Employee {
    private List<String> responsabilities;

    public Principal(String firstName, String lastName, int dni, LocalDate birthDate, double salary, List<String> responsabilities) {
        super(firstName, lastName, dni, birthDate, salary);
        this.responsabilities = responsabilities;
    }

    public List<String> getResponsabilities() {
        return responsabilities;
    }
}
