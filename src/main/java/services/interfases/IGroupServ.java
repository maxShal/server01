package services.interfases;

import entity.GroupStudents;

import java.util.List;

public interface IGroupServ
{
    long addGroup(GroupStudents group);

    void updateGroup(GroupStudents t);

    void deleteGroup(long i);

    GroupStudents getGroup(long i);

    List<GroupStudents> getGroups();
}
