package services.interfases;

import entity.Teacher;

import java.util.List;

public interface ITeacherServ
{
    long add(Teacher teacher);
    void update(Teacher teacher);
    void deleteById(long id);
    List<Teacher> getAll();
    Teacher gatById(long id);
}
