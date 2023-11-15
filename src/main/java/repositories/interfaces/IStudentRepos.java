package repositories.interfaces;

import entity.Student;

import java.util.List;

public interface IStudentRepos
{
    long add(Student student);
    void deleteById(long id);
    Student getById(long id);
    List<Student> getAllGroupId(long id);
    Long update(Student student);
}
