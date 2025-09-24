package edu.ccrm.domain;

import java.time.LocalDate;

public class Enrollment {
    private final String enrollmentId, studentId, courseCode;
    private final LocalDate enrolledOn; private Grade grade; private boolean active=true;

    public Enrollment(String eid, String sid, String ccode){
        this.enrollmentId=eid; this.studentId=sid; this.courseCode=ccode; this.enrolledOn=LocalDate.now();
    }

    public String getEnrollmentId(){return enrollmentId;}
    public String getStudentId(){return studentId;}
    public String getCourseCode(){return courseCode;}
    public LocalDate getEnrolledOn(){return enrolledOn;}
    public Grade getGrade(){return grade;}
    public void setGrade(Grade g){this.grade=g;}
    public boolean isActive(){return active;}
    public void deactivate(){active=false;}

    @Override
    public String toString(){ return enrollmentId+": student="+studentId+", course="+courseCode+", date="+enrolledOn+", grade="+(grade==null?"N/A":grade);}
}