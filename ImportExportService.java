package edu.ccrm.io;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Semester;
import edu.ccrm.domain.Student;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Import/export using CSV-like plain files.
 * Student CSV columns: id,regNo,fullName,email,status,enrollmentDate
 * Course CSV columns: code,title,credits,instructor,semester,department,active
 */
public class ImportExportService {

    private final Path dataDir;

    public ImportExportService(String folderName) {
        this.dataDir = Paths.get(folderName);
        try {
            if (!Files.exists(dataDir)) Files.createDirectories(dataDir);
        } catch (IOException e) {
            System.err.println("Error creating data dir: " + e.getMessage());
        }
    }

    // ---------------- EXPORT ----------------
    public void exportStudents(List<Student> students, String fileName) {
        Path file = dataDir.resolve(fileName);
        List<String> lines = new ArrayList<>();
        lines.add("id,regNo,fullName,email,status,enrollmentDate"); // header
        for (Student s : students) {
            String ld = s.getEnrollmentDate() == null ? "" : s.getEnrollmentDate().toString();
            lines.add(String.join(",",
                    safe(s.getId()),
                    safe(s.getRegNo()),
                    safe(s.getFullName()),
                    safe(s.getEmail()),
                    safe(s.getStatus()),
                    ld
            ));
        }
        try {
            Files.write(file, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Exported students -> " + file.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to export students: " + e.getMessage());
        }
    }

    public void exportCourses(List<Course> courses, String fileName) {
        Path file = dataDir.resolve(fileName);
        List<String> lines = new ArrayList<>();
        lines.add("code,title,credits,instructor,semester,department,active");
        for (Course c : courses) {
            lines.add(String.join(",",
                    safe(c.getCode()),
                    safe(c.getTitle()),
                    String.valueOf(c.getCredits()),
                    safe(c.getInstructor()),
                    c.getSemester() == null ? "" : c.getSemester().name(),
                    safe(c.getDepartment()),
                    String.valueOf(c.isActive())
            ));
        }
        try {
            Files.write(file, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Exported courses -> " + file.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to export courses: " + e.getMessage());
        }
    }

    // ---------------- IMPORT ----------------
    public List<Student> importStudents(String fileName) {
        Path file = dataDir.resolve(fileName);
        List<Student> out = new ArrayList<>();
        if (!Files.exists(file)) {
            System.out.println("Student file not found: " + file.toAbsolutePath());
            return out;
        }
        try {
            List<String> lines = Files.readAllLines(file);
            boolean header = true;
            for (String line : lines) {
                if (header) { header = false; continue; }
                if (line.isBlank()) continue;
                String[] p = line.split(",", -1); // keep empty trailing
                // expect at least 6 columns
                if (p.length < 6) continue;
                Student s = new Student(p[0], p[1], p[2], p[3]);
                if (p[4] != null && !p[4].isBlank()) s.setStatus(p[4]);
                if (p[5] != null && !p[5].isBlank()) s.setEnrollmentDate(LocalDate.parse(p[5]));
                out.add(s);
            }
            System.out.println("Imported " + out.size() + " students from " + file.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to import students: " + e.getMessage());
        }
        return out;
    }

    public List<Course> importCourses(String fileName) {
        Path file = dataDir.resolve(fileName);
        List<Course> out = new ArrayList<>();
        if (!Files.exists(file)) {
            System.out.println("Course file not found: " + file.toAbsolutePath());
            return out;
        }
        try {
            List<String> lines = Files.readAllLines(file);
            boolean header = true;
            for (String line : lines) {
                if (header) { header = false; continue; }
                if (line.isBlank()) continue;
                String[] p = line.split(",", -1);
                if (p.length < 6) continue;
                String code = p[0];
                String title = p[1];
                int credits = 3;
                try { credits = Integer.parseInt(p[2].isBlank() ? "3" : p[2]); } catch (NumberFormatException ignored) {}
                String instructor = p[3];
                Semester sem = null;
                if (p[4] != null && !p[4].isBlank()) {
                    try { sem = Semester.valueOf(p[4].toUpperCase()); } catch (Exception ignored) {}
                }
                String dept = p[5];
                Course c = new Course.Builder(code, title).credits(credits).instructor(instructor).semester(sem == null ? Semester.SPRING : sem).department(dept).build();
                // active flag if present
                if (p.length > 6 && "false".equalsIgnoreCase(p[6])) c.deactivate();
                out.add(c);
            }
            System.out.println("Imported " + out.size() + " courses from " + file.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to import courses: " + e.getMessage());
        }
        return out;
    }

    // simple CSV field sanitizer (does not quote) — keep minimal for this project
    private String safe(String s) {
        return s == null ? "" : s.replace("\n", " ").replace("\r", " ");
    }
}