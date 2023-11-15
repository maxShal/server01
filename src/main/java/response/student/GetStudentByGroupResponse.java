package response.student;

import entity.Student;

import java.util.List;

public record GetStudentByGroupResponse(List<Student> student) {
}
