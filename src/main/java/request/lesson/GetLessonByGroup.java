package request.lesson;

import entity.Teacher;

import java.time.LocalDate;

public class GetLessonByGroup {
    private final int numberofLesson;
    private final Teacher teacher;
    private final LocalDate date;
    private Long GroupId;


    public GetLessonByGroup(int numberofLesson, Teacher teacher, LocalDate date) {
        this.numberofLesson = numberofLesson;
        this.teacher = teacher;
        this.date = date;
    }

    public Long getGroupId() {
        return GroupId;
    }

    public int getNumberofLesson() {
        return numberofLesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LocalDate getDate() {
        return date;
    }
}
