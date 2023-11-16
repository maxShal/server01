package repositories.entityRep;

import entity.GroupStudents;
import repositories.DataBase;
import repositories.interfaces.IGroupRepos;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GroupRepos implements IGroupRepos
{
    private final Map<Long, GroupStudents> groupStudentsMap;

    public GroupRepos(DataBase dataBase) {
        this.groupStudentsMap = dataBase.getGroupStudentsMap();
    }

    @Override
    public long add(GroupStudents group) {
        long currentId = !groupStudentsMap.isEmpty() ? Collections.max(groupStudentsMap.keySet())+1:+1;
        groupStudentsMap.put(currentId, new GroupStudents(currentId, group.getGroupName()));
        return currentId;
    }

    @Override
    public void deleteById(long id) {
        groupStudentsMap.remove(id);
    }

    @Override
    public GroupStudents getById(long id) {
        return groupStudentsMap.getOrDefault(id,null);
    }

    @Override
    public List<GroupStudents> getAll() {
        return groupStudentsMap.values().stream().toList();
    }

    @Override
    public Long update(GroupStudents group) {
        if(groupStudentsMap.containsKey(group.getId())) {
            groupStudentsMap.put(group.getId(),group);
            return group.getId();
        }else{
            return null;
        }
    }
}
