package request.lesson;

public class GetLessonById
{
    private long id;

    public GetLessonById(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
