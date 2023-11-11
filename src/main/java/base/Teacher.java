package base;

import java.util.Objects;

public class Teacher
{
    private final String name;
    private final String surename;
    private final String fathername;

    public Teacher(String name, String surename, String fathername) {
        this.name = name;
        this.surename = surename;
        this.fathername = fathername;
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
