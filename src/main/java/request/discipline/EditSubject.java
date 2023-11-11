package request.discipline;

public class EditSubject {
    private long id;
    private String name;

    public EditSubject(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
