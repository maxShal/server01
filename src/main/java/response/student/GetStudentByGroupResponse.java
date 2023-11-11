package response.student;

import base.Student;

import java.util.List;

public record GetStudentByGroupResponse(List<Student> student) {
}
