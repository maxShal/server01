package repositories;

import entity.*;
import entity.Student;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
private final Map<Long, GroupStudents> groupStudentsMap;

private final Map<Long, Student> studentMap;

private final Map<Long, Discipline> disciplineMap;

private final Map<Long, Lesson> lessonMap;

private final Map<Long, Teacher> teacherMap;

    public DataBase(Map<Long, GroupStudents> groupStudentsMap, Map<Long, Student> studentMap, Map<Long, Discipline> disciplineMap, Map<Long, Lesson> lessonMap, Map<Long, Teacher> teacherMap) {
        this.groupStudentsMap = groupStudentsMap;
        this.studentMap = studentMap;
        this.disciplineMap = disciplineMap;
        this.lessonMap = lessonMap;
        this.teacherMap = teacherMap;
    }
    public DataBase()
    {
        this.groupStudentsMap = new HashMap<>();
        this.studentMap = new HashMap<>();
        this.disciplineMap = new HashMap<>();
        this.lessonMap = new HashMap<>();
        this.teacherMap = new HashMap<>();
    }

    public Map<Long, GroupStudents> getGroupStudentsMap() {
        return groupStudentsMap;
    }

    public Map<Long, Student> getStudentMap() {
        return studentMap;
    }

    public Map<Long, Discipline> getDisciplineMap() {
        return disciplineMap;
    }

    public Map<Long, Lesson> getLessonMap() {
        return lessonMap;
    }

    public Map<Long, Teacher> getTeacherMap() {
        return teacherMap;
    }
}
