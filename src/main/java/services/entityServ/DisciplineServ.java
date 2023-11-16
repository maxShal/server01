package services.entityServ;

import entity.Discipline;
import repositories.interfaces.IDisciplineRepos;
import services.interfases.IDisciplineServ;

import java.util.List;

public class DisciplineServ implements IDisciplineServ {

    private final IDisciplineRepos disciplineRepos;

    public DisciplineServ(IDisciplineRepos disciplineRepos) {

        this.disciplineRepos = disciplineRepos;
    }

    @Override
    public long add(Discipline discipline) {
        return disciplineRepos.add(discipline);
    }

    @Override
    public void deleteById(long id) {
        disciplineRepos.deleteById(id);
    }
    @Override
    public Discipline getById(long id) {
        return disciplineRepos.getById(id);
    }

    @Override
    public List<Discipline> getAll() {
        return disciplineRepos.getAll();
    }

    @Override
    public void update(Discipline discipline) { disciplineRepos.update(discipline);

    }
}
