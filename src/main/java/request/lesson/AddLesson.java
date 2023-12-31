package request.lesson;

import entity.GroupStudents;
import entity.Teacher;

import java.time.LocalDate;

public class AddLesson {
    private int numberOfLesson;
    private long teacherId;
    private long groupStudentsId;
    private Teacher teacher;///
    private GroupStudents groupStudents;///

    private LocalDate date;

    public AddLesson(int numberOfLesson, long teacherId, long groupStudentsId, LocalDate date) {
        this.numberOfLesson = numberOfLesson;
        this.teacherId = teacherId;
        this.groupStudentsId = groupStudentsId;
        this.date = date;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public GroupStudents getGroupStudents() {
        return groupStudents;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public long getGroupStudentsId() {
        return groupStudentsId;
    }

    public LocalDate getDate() {
        return date;
    }
}
