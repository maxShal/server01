package services.entityServ;

import entity.GroupStudents;
import repositories.interfaces.IGroupRepos;
import services.interfases.IGroupServ;

import java.util.List;

public class GroupServ implements IGroupServ
{
    private final IGroupRepos groupRepos;

    public GroupServ(IGroupRepos groupRepos)
    {
        this.groupRepos = groupRepos;
    }

    @Override
    public long addGroup(GroupStudents group) {

        return groupRepos.add(group);/// group;
    }

    @Override
    public void updateGroup(GroupStudents t) {
        groupRepos.update(t);

    }

    @Override
    public void deleteGroup(long i) {
        groupRepos.deleteById(i);

    }

    @Override
    public GroupStudents getGroup(long i)
    {
        return groupRepos.getById(i);
    }

    @Override
    public List<GroupStudents> getGroups() {
        return groupRepos.getAll();
    }
}
