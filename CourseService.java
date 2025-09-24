package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Semester;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseService {
    private final List<Course> courses = new ArrayList<>();

    public Course addCourse(String code, String title, int credits, String instructor, Semester semester, String department) {
        Course c = new Course.Builder(code, title)
                .credits(credits)
                .instructor(instructor == null || instructor.isBlank() ? "TBA" : instructor)
                .semester(semester == null ? Semester.SPRING : semester)
                .department(department == null || department.isBlank() ? "General" : department)
                .build();
        courses.add(c);
        return c;
    }

    public List<Course> getAllCourses() { return List.copyOf(courses); }

    public Optional<Course> findByCode(String code) {
        return courses.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findFirst();
    }

    public boolean courseExists(String code) {
        return findByCode(code).isPresent();
    }

    public boolean updateCourse(String code, String newTitle, Integer newCredits, String newInstructor, Semester newSemester, String newDept) {
        Optional<Course> opt = findByCode(code);
        if (opt.isEmpty()) return false;
        Course c = opt.get();
        if (newTitle != null && !newTitle.isBlank()) c.setTitle(newTitle);
        if (newCredits != null && newCredits > 0) c.setCredits(newCredits);
        if (newInstructor != null && !newInstructor.isBlank()) c.setInstructor(newInstructor);
        if (newSemester != null) c.setSemester(newSemester);
        if (newDept != null && !newDept.isBlank()) c.setDepartment(newDept);
        return true;
    }

    public boolean deactivateCourse(String code) {
        Optional<Course> opt = findByCode(code);
        if (opt.isEmpty()) return false;
        opt.get().deactivate();
        return true;
    }

    public List<Course> searchByInstructor(String instructor) {
        return courses.stream().filter(c -> c.getInstructor() != null && c.getInstructor().equalsIgnoreCase(instructor)).collect(Collectors.toList());
    }

    public List<Course> searchByDepartment(String department) {
        return courses.stream().filter(c -> c.getDepartment() != null && c.getDepartment().equalsIgnoreCase(department)).collect(Collectors.toList());
    }

    public List<Course> searchBySemester(Semester semester) {
        return courses.stream().filter(c -> c.getSemester() == semester).collect(Collectors.toList());
    }
}