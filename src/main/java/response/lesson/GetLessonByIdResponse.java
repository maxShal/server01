package response.lesson;

import base.GroupStudents;
import base.Teacher;

import java.time.LocalDate;

public record GetLessonByIdResponse(int numberOfLesson, Teacher teacher, GroupStudents groupStudents, LocalDate date) {
}
