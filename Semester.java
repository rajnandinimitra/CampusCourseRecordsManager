package edu.ccrm.domain;

public enum Semester {
    SPRING, SUMMER, FALL, WINTER;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}