package repositories.interfaces;

import entity.GroupStudents;

import java.util.List;

public interface IGroupRepos
{
    long add(GroupStudents group);//throws RepositoryException;
    void deleteById(long id);
    GroupStudents getById(long id);
    List<GroupStudents> getAll();
    Long update(GroupStudents group);
}
