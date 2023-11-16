package repositories.interfaces;

import entity.Discipline;

import java.util.List;

public interface IDisciplineRepos    {
        long add(Discipline discipline);
        void deleteById(long id);
        Discipline getById(long id);
        List<Discipline> getAll();
        Long update(Discipline discipline);
}
