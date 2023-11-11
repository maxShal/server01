package request.groupStudents;

public class GetStudentGroupById
{
    private long id;

    public GetStudentGroupById(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
