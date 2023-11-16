package services.interfases;

import entity.Discipline;

import java.util.List;

public interface IDisciplineServ {
    long add(Discipline discipline);
    void deleteById(long id);
    Discipline getById(long id);
    List<Discipline> getAll();
    void update(Discipline discipline);
}
