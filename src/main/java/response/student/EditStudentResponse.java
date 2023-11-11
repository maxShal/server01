package response.student;

public record EditStudentResponse(String lastName, String firstName, String middleName, long groupId, String status) {
}
