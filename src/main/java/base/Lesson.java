package base;

import java.time.LocalDate;
import java.util.Objects;

public class Lesson
{
    private int numberOfLesson;
    private Teacher teacher;
    private GroupStudents groupStudents;
    private LocalDate date;

    public Lesson(int numberOfLesson, Teacher teacher, GroupStudents groupStudents, LocalDate date) {
        this.numberOfLesson = numberOfLesson;
        this.teacher = teacher;
        this.groupStudents = groupStudents;
        this.date = date;
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
