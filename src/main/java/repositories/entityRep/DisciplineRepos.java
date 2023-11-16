package repositories.entityRep;

import entity.Discipline;
import entity.GroupStudents;
import entity.Teacher;
import repositories.DataBase;
import repositories.interfaces.IDisciplineRepos;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DisciplineRepos implements IDisciplineRepos
{
    private final Map<Long, Discipline> disciplineMap;

    public DisciplineRepos(DataBase dataBase)
    {
        this.disciplineMap= dataBase.getDisciplineMap();
    }

    @Override
    public long add(Discipline discipline) {
        long currentId = !disciplineMap.isEmpty() ? Collections.max(disciplineMap.keySet()) +1:1;
        disciplineMap.put(currentId,new Discipline(currentId,discipline.getTitle()));
        return currentId;
    }

    @Override
    public void deleteById(long id) {
        disciplineMap.remove(id);
    }

    @Override
    public Discipline getById(long id) {
        return disciplineMap.getOrDefault(id,null);
    }

    @Override
    public List<Discipline> getAll(){
        return disciplineMap.values().stream().toList();
    }

    @Override
    public Long update(Discipline discipline) {
        if (disciplineMap.containsKey(discipline.getId())) {
            disciplineMap.put(discipline.getId(), discipline);
            return discipline.getId();
        } else {
            return null;
        }
    }
}
