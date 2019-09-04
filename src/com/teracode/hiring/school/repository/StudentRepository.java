package com.teracode.hiring.school.repository;

import com.teracode.hiring.school.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentRepository {
    public Map<Character, List<Student>> getStudentsGroupByFirstLetterOfLastName();
    public void save(List<Student> students);
}
