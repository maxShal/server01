package repositories.entityRep;

import entity.GroupStudents;
import entity.Student;
import repositories.DataBase;
import repositories.interfaces.IStudentRepos;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StudentsRepos implements IStudentRepos {

    private final Map<Long, Student> studentMap;
    private final Map<Long, GroupStudents> groupStudentsMap;

    public StudentsRepos(DataBase dataBase)
    {
        this.studentMap=dataBase.getStudentMap();
        this.groupStudentsMap = dataBase.getGroupStudentsMap();
    }
    @Override
    public long add(Student student)
    {
        long currentId = !studentMap.isEmpty() ? Collections.max(studentMap.keySet())+1: 1;
        studentMap.put(currentId, new Student(currentId,student.getSurename(),student.getName(),student.getFathername(),student.getStatus(),student.getGroup()));
        return currentId;
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }

    @Override
    public Student getById(long id) {
        return studentMap.getOrDefault(id, null);
    }

    @Override
    public List<Student> getAllGroupId(long id) {
        if(groupStudentsMap.containsKey(id)){
            return studentMap.values().stream().filter(x ->x.getGroup().getId()==id).toList();
        }
        else{
            return null;
        }
    }

    @Override
    public Long update(Student student) {
        if(studentMap.containsKey(student.getId())){
            studentMap.put(student.getId(), student);
            return student.getId();
        }
        else {
        return null;}
    }
}

