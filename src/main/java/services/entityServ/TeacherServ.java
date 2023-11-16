package services.entityServ;

import entity.Teacher;
import repositories.interfaces.ITeacherRepos;
import services.interfases.ITeacherServ;

import java.util.List;

public class TeacherServ implements ITeacherServ {

    private final ITeacherRepos teacherRepos;

    public TeacherServ(ITeacherRepos teacherRepos) {
        this.teacherRepos = teacherRepos;
    }

    @Override
    public long add(Teacher teacher) {
        return teacherRepos.add(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherRepos.update(teacher);
    }

    @Override
    public void deleteById(long id) {
        teacherRepos.deleteById(id);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepos.getAll();
    }

    @Override
    public Teacher gatById(long id) {
        return teacherRepos.gatById(id);
    }
}
