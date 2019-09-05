package com.teracode.hiring.school.repository;

import com.teracode.hiring.school.model.Student;
import com.teracode.hiring.school.model.Subject;

import java.util.List;
import java.util.Map;

public interface StudentRepository {

    public Map<Character, List<Student>> getStudentsGroupByFirstLetterOfLastName();

    public List<Student> getStudentsBySubject(Subject subject);

    public void save(List<Student> students);
}
