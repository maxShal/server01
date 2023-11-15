package repositories.interfaces;

import entity.Teacher;

import java.util.List;

public interface ITeacherRepos {
    long add(Teacher teacher);
    Long update(Teacher teacher);
    void deleteById(long id);
    List<Teacher> getAllByGroupId(long Id);
    Teacher gatById(long id);
}
