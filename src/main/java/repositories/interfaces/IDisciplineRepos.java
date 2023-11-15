package repositories.interfaces;

import entity.Discipline;
import entity.Student;

import java.util.List;

public interface IDisciplineRepos    {
        long add(Discipline discipline);
        void deleteById(long id);
        Discipline getById(long id);
        List<Discipline> getAllByGroupId(long id);
        Long update(Discipline discipline);
}
