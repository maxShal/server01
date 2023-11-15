package response.teacher;

import entity.Teacher;

import java.util.List;

public record GetTeacherResponse(List<Teacher> teachers) {
}
