package services.entityServ;

import entity.Lesson;
import entity.Teacher;
import repositories.interfaces.ILessonRepos;
import services.interfases.ILessonServ;

import java.util.List;

public class LessonServ implements ILessonServ {

    private final ILessonRepos iLessonRepos;

    public LessonServ(ILessonRepos iLessonRepos) {
        this.iLessonRepos = iLessonRepos;
    }

    @Override
    public long add(Lesson lesson) {
        return iLessonRepos.add(lesson);
    }

    @Override
    public void deleteById(long id) {
        iLessonRepos.deleteById(id);
    }

    @Override
    public Lesson getById(long id) {
        return iLessonRepos.getById(id);
    }

    @Override
    public List<Lesson> getAllByIdGroup(long id) {
        return iLessonRepos.getAllByIdGroup(id);
    }

    @Override
    public List<Lesson> getAllByTeacher(Teacher teacher) {
        return iLessonRepos.getLessonsByTeacher(teacher);
    }

}
