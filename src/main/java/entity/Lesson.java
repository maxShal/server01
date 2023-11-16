package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Lesson
{
    private final long id;
    private final int numberOfLesson;
    private final Teacher teacher;
    private final GroupStudents groupStudents;
    private final LocalDate date;
    private long idGroup;// в другой класс.

    public Lesson(long id,int numberOfLesson, Teacher teacher, GroupStudents groupStudents, LocalDate date) {
        this.id=id;
        this.numberOfLesson = numberOfLesson;
        this.teacher = teacher;
        this.groupStudents = groupStudents;
        this.date = date;
    }

    public long getGroupId() {
        return idGroup;
    }

    public long getId() {
        return id;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public GroupStudents getGroupStudents() {
        return groupStudents;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return numberOfLesson == lesson.numberOfLesson && Objects.equals(teacher, lesson.teacher) && Objects.equals(groupStudents, lesson.groupStudents) && Objects.equals(date, lesson.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfLesson, teacher, groupStudents, date);
    }
}
