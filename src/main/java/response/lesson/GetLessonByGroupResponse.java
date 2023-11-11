package response.lesson;

import base.GroupStudents;
import base.Teacher;

import java.time.LocalDate;

public class GetLessonByGroupResponse
{
    private int numberOfLesson;
    private  Teacher teacher;
    private LocalDate date;

    public GetLessonByGroupResponse(int numberOfLesson, Teacher teacher, LocalDate date) {
        this.numberOfLesson = numberOfLesson;
        this.teacher = teacher;
        this.date = date;
    }

    public int getNumberOfLesson() {

        return numberOfLesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LocalDate getDate() {
        return date;
    }
}
