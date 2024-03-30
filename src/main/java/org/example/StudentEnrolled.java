package org.example;

import java.util.Objects;

public class StudentEnrolled {
    private String username;
    private String courseName;

    public StudentEnrolled(String username, String courseName) {
        this.username = username;
        this.courseName = courseName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEnrolled that = (StudentEnrolled) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, courseName);
    }
}
