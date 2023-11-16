package repositories.entityRep;

import entity.GroupStudents;
import entity.Teacher;
import repositories.DataBase;
import repositories.interfaces.ITeacherRepos;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TeacherRepos implements ITeacherRepos
{
    private final Map<Long, Teacher> teacherMap;

    public TeacherRepos(DataBase dataBase)
    {
        this.teacherMap = dataBase.getTeacherMap();

    }

    @Override
    public long add(Teacher teacher) {
        long currentId = !teacherMap.isEmpty() ? Collections.max(teacherMap.keySet()) +1:1;
        teacherMap.put(currentId,new Teacher(currentId,teacher.getSurename(), teacher.getName(),teacher.getFathername()));
        return currentId;
    }

    @Override
    public Long update(Teacher teacher) {
        if (teacherMap.containsKey(teacher.getId())) {
            teacherMap.put(teacher.getId(), teacher);
            return teacher.getId();
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(long id) {
        teacherMap.remove(id);
    }

    @Override
    public List<Teacher> getAll()
    {
        return teacherMap.values().stream().toList();
    }

    @Override
    public Teacher gatById(long id) {

        return teacherMap.getOrDefault(id,null);
    }
}
