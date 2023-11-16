package repositories.entityRep;

import entity.GroupStudents;
import entity.Lesson;
import entity.Teacher;
import repositories.DataBase;
import repositories.interfaces.ILessonRepos;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LessonRepos implements ILessonRepos
{
    private final Map<Long, Lesson> lessonMap;
    private final Map<Long, GroupStudents> groupStudentsMap;

    private final Map<Long, Teacher> teacherMap;

    public LessonRepos(DataBase dataBase)
    {
        this.lessonMap=dataBase.getLessonMap();
        this.groupStudentsMap=dataBase.getGroupStudentsMap();
        this.teacherMap=dataBase.getTeacherMap();
    }

    @Override
    public long add(Lesson lesson) {
        long currentId = !lessonMap.isEmpty() ? Collections.max(lessonMap.keySet())+1: 1;
        lessonMap.put(currentId, new Lesson(currentId,lesson.getNumberOfLesson(),lesson.getTeacher(),lesson.getGroupStudents(),lesson.getDate()));
        return currentId;
    }

    @Override
    public void deleteById(long id) {
        lessonMap.remove(id);
    }

    @Override
    public Lesson getById(long id) {
        return lessonMap.getOrDefault(id,null);
    }

    @Override
    public List<Lesson> getAllByIdGroup(long id) {
        if(groupStudentsMap.containsKey(id)){
            return lessonMap.values().stream().filter(x ->x.getGroupId()==id).toList();
        }
        else{
            return null;
        }
    }

    @Override
    public List<Lesson> getLessonsByTeacher(Teacher teacher) {
        if(teacherMap.containsKey(teacher.getId()))
        {
            return lessonMap.values().stream().filter(x->x.getTeacher().getId()==teacher.getId()).toList();
        }
        else {
            return null;
        }
    }


    @Override
    public Long update(Lesson lesson) {
        if(lessonMap.containsKey(lesson.getId())){
            lessonMap.put(lesson.getId(), lesson);
            return lesson.getId();
        }
        else {
            return null;}
    }
}
