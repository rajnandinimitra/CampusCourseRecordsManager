package edu.ccrm.cli;

import edu.ccrm.domain.Student;
import edu.ccrm.service.StudentService;
import edu.ccrm.service.EnrollmentService;
import edu.ccrm.service.TranscriptService;
import edu.ccrm.io.ImportExportService;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // -----------------------------
        // Initialize services
        // -----------------------------
        StudentService studentService = new StudentService();
        EnrollmentService enrollmentService = new EnrollmentService();
        TranscriptService transcriptService = new TranscriptService();
        ImportExportService ioService = new ImportExportService("data");

        // -----------------------------
        // 1. Add Students
        // -----------------------------
        Student s1 = new Student("S001", "REG001", "Rajnandini", "rajnandini@example.com");
        Student s2 = new Student("S002", "REG002", "Rajrani", "rajrani@example.com");

        studentService.addStudent(s1);
        studentService.addStudent(s2);

        // -----------------------------
        // 2. Enroll Students in Courses
        // -----------------------------
        enrollmentService.enrollStudent(s1, "CS101");
        enrollmentService.enrollStudent(s1, "MATH201");
        enrollmentService.enrollStudent(s2, "CS101");

        // -----------------------------
        // 3. Record Grades
        // -----------------------------
        transcriptService.recordGrade("S001", "CS101", "A");
        transcriptService.recordGrade("S001", "MATH201", "B+");
        transcriptService.recordGrade("S002", "CS101", "A-");

        // -----------------------------
        // 4. Print Transcript
        // -----------------------------
        transcriptService.printTranscript("S001");
        transcriptService.printTranscript("S002");

        // -----------------------------
        // 5. Export Students to CSV
        // -----------------------------
        ioService.exportStudents(studentService.getAllStudents(), "students.csv");

        // -----------------------------
        // 6. Import Students back
        // -----------------------------
        List<Student> importedStudents = ioService.importStudents("students.csv");
        System.out.println("Imported Students:");
        importedStudents.forEach(System.out::println);
    }
}