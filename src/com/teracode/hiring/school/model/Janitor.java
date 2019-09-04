package com.teracode.hiring.school.model;

import java.time.LocalDate;
import java.util.List;

public class Janitor extends Employee{

    List<String> workingAreas;

    public Janitor(String firstName, String lastName, int dni, LocalDate birthDate, double salary, List<String> workingAreas) {
        super(firstName, lastName, dni, birthDate, salary);
        this.workingAreas=workingAreas;
    }

    public List<String> getWorkingAreas() {
        return workingAreas;
    }
}
