package entity;

import java.util.Objects;

public class Student {
    private final String name;
    private final String surename;
    private final String fathername;

    private final String status;
    private final GroupStudents group;

    public String getName() {
        return name;
    }

    public String getSurename() {
        return surename;
    }

    public String getFathername() {
        return fathername;
    }

    public String getStatus() {
        return status;
    }

    public GroupStudents getGroup() {
        return group;
    }

    public Student(String name, String surename, String fathername, String status, GroupStudents group) {
        this.name = name;
        this.surename = surename;
        this.fathername = fathername;
        this.status = status;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(surename, student.surename) && Objects.equals(fathername, student.fathername) && status == student.status && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surename, fathername, status, group);
    }
}
