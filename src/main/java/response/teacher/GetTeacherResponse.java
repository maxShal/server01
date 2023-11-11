package response.teacher;

import base.Teacher;

import java.util.List;

public record GetTeacherResponse(List<Teacher> teachers) {
}
