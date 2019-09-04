package com.teracode.hiring.school.model;


import java.time.LocalDate;
import java.util.List;

public class Student extends Person {
    private List<Subject> subjects;

    public Student(String firstName, String lastName, int dni, LocalDate birthDate, List<Subject> subjects) {
        super(firstName, lastName, dni, birthDate);
        this.subjects = subjects;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "subjects=" + subjects +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni=" + dni +
                ", birthDate=" + birthDate +
                '}';
    }
}
