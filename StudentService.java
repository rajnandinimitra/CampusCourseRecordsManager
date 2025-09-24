package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println(" Student added: " + student.getFullName());
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> findStudentById(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    public void removeStudent(String id) {
        students.removeIf(s -> s.getId().equals(id));
        System.out.println("🗑️ Student with ID " + id + " removed.");
    }
}