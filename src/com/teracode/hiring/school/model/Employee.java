package com.teracode.hiring.school.model;

import java.time.LocalDate;

public class Employee extends Person{

    private double salary;

    public Employee(String firstName, String lastName, int dni, LocalDate birthDate, double salary) {
        super(firstName, lastName, dni, birthDate);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
}
