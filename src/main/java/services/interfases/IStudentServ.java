package services.interfases;

import entity.Student;

import java.util.List;

public interface IStudentServ {
    long add(Student student);
    void deleteById(long id);
    Student getById(long id);
    List<Student> getAllGroupId(long id);
    void update(Student student);
}
