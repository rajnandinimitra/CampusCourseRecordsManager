package edu.ccrm.domain;

/**
 * Course domain class. Provides both a convenient constructor and a Builder
 * so Import/Export and other services can use either style.
 */
public class Course {
    private final String code;     // immutable identifier
    private String title;
    private int credits;
    private String instructor;
    private Semester semester;
    private String department;
    private boolean active = true;

    // Convenient constructor (used by some import code if desired)
    public Course(String code, String title, int credits, String instructor, Semester semester, String department) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.instructor = instructor;
        this.semester = semester;
        this.department = department;
    }

    // Builder (preferred in many services)
    private Course(Builder b) {
        this.code = b.code;
        this.title = b.title;
        this.credits = b.credits;
        this.instructor = b.instructor;
        this.semester = b.semester;
        this.department = b.department;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public Semester getSemester() { return semester; }
    public void setSemester(Semester semester) { this.semester = semester; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public boolean isActive() { return active; }
    public void deactivate() { this.active = false; }

    @Override
    public String toString() {
        return code + " - " + title + " (" + credits + "cr) [" + (semester == null ? "N/A" : semester) + "] Dept: " + department +
                " | Instructor: " + (instructor == null ? "TBA" : instructor) + (active ? "" : " [DEACTIVATED]");
    }

    public static class Builder {
        private final String code;
        private final String title;
        private int credits = 3;
        private String instructor = "TBA";
        private Semester semester = Semester.SPRING;
        private String department = "General";

        public Builder(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public Builder credits(int credits) { this.credits = credits; return this; }
        public Builder instructor(String instructor) { this.instructor = instructor; return this; }
        public Builder semester(Semester semester) { this.semester = semester; return this; }
        public Builder department(String department) { this.department = department; return this; }
        public Course build() { return new Course(this); }
    }
}