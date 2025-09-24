package edu.ccrm.domain;

public class Instructor extends Person {
    private String department;
    public Instructor(String id, String fullName, String email, String dept) {
        super(id, fullName, email); this.department = dept;
    }
    public String getDepartment() { return department; }
    @Override public void printProfile() { System.out.println(fullName+" ("+department+")"); }
}