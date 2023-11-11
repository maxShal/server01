package response.student;

public record GetStudentByIdResponse(String lastName, String firstName, String middleName, long groupId,
                                     String status) {
}
