package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Student domain class used across the project.
 * Matches the CSV columns: id,regNo,fullName,email,status,enrollmentDate
 */
public class Student {
    private String id;
    private String regNo;
    private String fullName;
    private String email;
    private String status;               // e.g., "ACTIVE" or "INACTIVE"
    private LocalDate enrollmentDate;
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Student(String id, String regNo, String fullName, String email) {
        this.id = id;
        this.regNo = regNo;
        this.fullName = fullName;
        this.email = email;
        this.status = "ACTIVE";
        this.enrollmentDate = LocalDate.now();
    }

    // --- Getters / Setters ---
    public String getId() { return id; }
    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public List<Enrollment> getEnrollments() { return List.copyOf(enrollments); }
    public void addEnrollment(Enrollment e) { this.enrollments.add(e); }

    public void deactivate() { this.status = "INACTIVE"; }

    // Helper used by export
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", regNo='" + regNo + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }

    // For convenience if other code expects a short profile print
    public void printProfile() {
        System.out.println("Student: " + fullName + " | ID: " + id + " | RegNo: " + regNo + " | Status: " + status);
    }
}