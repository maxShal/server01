package request.lesson;

public class GetLessonsByTeacher
{
    private String startDate;
    private String endDate;
    private long teacherId;

    public GetLessonsByTeacher(String startDate, String endDate, long teacherId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getTeacherId() {
        return teacherId;
    }
}
