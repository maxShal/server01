package response.lesson;

import entity.GroupStudents;

import java.time.LocalDate;

public record GetLessonByTeacherResponse(int numberOfLesson, GroupStudents groupStudents, LocalDate date) {

}
