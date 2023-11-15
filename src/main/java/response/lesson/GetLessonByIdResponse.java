package response.lesson;

import entity.GroupStudents;
import entity.Teacher;

import java.time.LocalDate;

public record GetLessonByIdResponse(int numberOfLesson, Teacher teacher, GroupStudents groupStudents, LocalDate date) {
}
