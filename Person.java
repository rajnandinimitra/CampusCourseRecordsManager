package edu.ccrm.domain;

public abstract class Person {
    protected String id;
    protected String fullName;
    protected String email;

    public Person(String id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public abstract void printProfile();

    @Override
    public String toString() {
        return id + " - " + fullName + " <" + email + ">";
    }
}