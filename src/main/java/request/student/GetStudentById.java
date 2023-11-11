package request.student;

public class GetStudentById
{
    private long id;

    public GetStudentById(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
}
