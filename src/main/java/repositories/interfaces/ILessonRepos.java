package repositories.interfaces;

import entity.GroupStudents;
import entity.Lesson;
import entity.Teacher;

import java.util.List;

public interface ILessonRepos
{
    long add(Lesson lesson);
    void deleteById(long id);
    Lesson getById(long id);
    List<Lesson> getAllByIdGroup(long id);
    List<Lesson>  getLessonsByTeacher(Teacher teacher);
    Long update(Lesson lesson);
}
