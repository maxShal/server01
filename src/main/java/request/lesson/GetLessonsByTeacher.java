package request.lesson;

import entity.GroupStudents;
import entity.Teacher;

import java.time.LocalDate;

public class GetLessonsByTeacher
{
    private int numberOfLesson;
    private GroupStudents groupStudents;
    private LocalDate localDate;
    private String startDate;
    private String endDate;
    private long teacherId;
    private Teacher teacher;

    public GetLessonsByTeacher(String startDate, String endDate, long teacherId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public GroupStudents getGroupStudents() {
        return groupStudents;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Teacher getTeacher() {
        return teacher;
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
