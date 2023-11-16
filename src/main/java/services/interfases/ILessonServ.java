package services.interfases;

import entity.Lesson;
import entity.Teacher;

import java.util.List;

public interface ILessonServ {
    long add(Lesson lesson);
    void deleteById(long id);
    Lesson getById(long id);
    List<Lesson> getAllByIdGroup(long id);
    List<Lesson> getAllByTeacher(Teacher teacher);
}
