package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.*;

public class EnrollmentService {
    // Map: studentId → list of course codes
    private final Map<String, List<String>> enrollments = new HashMap<>();

    public void enrollStudent(Student student, String courseCode) {
        enrollments.putIfAbsent(student.getId(), new ArrayList<>());
        enrollments.get(student.getId()).add(courseCode);
        System.out.println(" " + student.getFullName() + " enrolled in " + courseCode);
    }

    public List<String> getEnrolledCourses(String studentId) {
        return enrollments.getOrDefault(studentId, new ArrayList<>());
    }

    public void dropCourse(String studentId, String courseCode) {
        List<String> courses = enrollments.get(studentId);
        if (courses != null) {
            courses.remove(courseCode);
            System.out.println("🗑️ Dropped course " + courseCode + " for student " + studentId);
        }
    }
}