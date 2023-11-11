package request.student;

public class GetStudentsByGroup
{
    private long id;

    public GetStudentsByGroup(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
