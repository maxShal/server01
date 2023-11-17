package entity;

import java.util.Objects;

public class Teacher
{
    private final String name;
    private final String surename;
    private final String fathername;

    private GroupStudents group;


    private final Long id;

    public Teacher(Long id, String surename,String name, String fathername) {
        this.id=id;
        this.surename = surename;
        this.name=name;
        this.fathername = fathername;
    }

    public Long getId() {
        return id;
    }
    public GroupStudents getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getSurename() {
        return surename;
    }

    public String getFathername() {
        return fathername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(name, teacher.name) && Objects.equals(surename, teacher.surename) && Objects.equals(fathername, teacher.fathername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surename, fathername);
    }
}
