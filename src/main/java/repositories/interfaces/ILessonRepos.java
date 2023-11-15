package repositories.interfaces;

import entity.GroupStudents;
import entity.Lesson;

import java.util.List;

public interface ILessonRepos
{
    long add(Lesson lesson);//throws RepositoryException;
    void deleteById(long id);
    Lesson getById(long id);
    List<Lesson> getAllByIdGroup(long id);
    Long update(Lesson lesson);
}
