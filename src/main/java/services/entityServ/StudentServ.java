package services.entityServ;

import entity.Student;
import repositories.interfaces.IStudentRepos;
import services.interfases.IStudentServ;

import java.util.List;

public class StudentServ implements IStudentServ {

    private final IStudentRepos studentRepos;

    public StudentServ(IStudentRepos studentRepos) {
        this.studentRepos = studentRepos;
    }

    @Override
    public long add(Student student) {
        return studentRepos.add(student);
    }

    @Override
    public void deleteById(long id) {
        studentRepos.deleteById(id);
    }

    @Override
    public Student getById(long id) {
        return studentRepos.getById(id);
    }

    @Override
    public List<Student> getAllGroupId(long id) {
        return studentRepos.getAllGroupId(id);
    }

    @Override
    public void update(Student student) {
        studentRepos.update(student);

    }
}
