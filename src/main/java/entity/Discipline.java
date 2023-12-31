package entity;

import java.util.Objects;

public class Discipline
{
    private final Long id;

    private final String title;


    public Discipline(Long id,String title) {
        this.title = title;
        this.id=id;
    }



    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
