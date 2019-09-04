package com.teracode.hiring.school.model;

import java.time.LocalDate;

public class Employee extends Person{

    public Employee(String firstName, String lastName, int dni, LocalDate birthDate, double salary) {
        super(firstName, lastName, dni, birthDate);
        this.salary = salary;
    }

    private double salary;

    public double getSalary() {
        return salary;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
}
