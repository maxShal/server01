package response.lesson;

import base.GroupStudents;

import java.time.LocalDate;

public record GetLessonByTeacherResponse(int numberOfLesson, GroupStudents groupStudents, LocalDate date) {

}
