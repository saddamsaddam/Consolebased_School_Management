package org.example;

import java.util.Objects;

public class Grade {
    private String username;
    private String courseName;
    private String grade;

    public Grade(String username, String courseName, String grade) {
        this.username = username;
        this.courseName = courseName;
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return Objects.equals(username, grade1.username) &&
                Objects.equals(courseName, grade1.courseName) &&
                Objects.equals(grade, grade1.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, courseName, grade);
    }
}
