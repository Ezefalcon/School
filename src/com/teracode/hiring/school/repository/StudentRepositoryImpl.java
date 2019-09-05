package com.teracode.hiring.school.repository;

import com.teracode.hiring.school.model.Student;
import com.teracode.hiring.school.model.Subject;

import java.time.LocalDate;
import java.util.*;

public class StudentRepositoryImpl implements StudentRepository {

    private Set<Student> students;

    public StudentRepositoryImpl() {
        this.students = new HashSet<>();
    }

    @Override
    public Map<Character, List<Student>> getStudentsGroupByFirstLetterOfLastName() {
        Map<Character, List<Student>> studentsMap = new HashMap<>();
        for(Student student:students) {
            char letter = student.getLastName().charAt(0);
            letter = Character.toUpperCase(letter);
            List<Student> studentsFromMap = studentsMap.get(letter);
            if(studentsFromMap!=null) {
                studentsFromMap.add(student);
            } else {
                List<Student> list = new ArrayList<>();
                list.add(student);
                studentsMap.put(letter, list);
            }
        }
        return studentsMap;
    }

    @Override
    public List<Student> getStudentsBySubject(Subject subject) {
        return subject.getStudents();
    }

    @Override
    public void save(List<Student> list) {
        students.addAll(list);
    }

    public static void main(String[] args) {
        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
        studentRepository.save(Arrays.asList(
                new Student("Juan","Acedo",123, LocalDate.now(), new ArrayList<>()),
                new Student("Juan","Marquez",123, LocalDate.now(), new ArrayList<>()),
                new Student("Juan","Tita",123, LocalDate.now(), new ArrayList<>()),
                new Student("Juan","Shin",123, LocalDate.now(), new ArrayList<>()),
                new Student("Juan","Amero",123, LocalDate.now(), new ArrayList<>()),
                new Student("Juan","Linares",123, LocalDate.now(), new ArrayList<>()),
                new Student("Juan","Lose",123, LocalDate.now(), new ArrayList<>()),
                new Student("Juan","Ataro",123, LocalDate.now(), new ArrayList<>())
        ));
        System.out.println(studentRepository.getStudentsGroupByFirstLetterOfLastName());
    }
}
