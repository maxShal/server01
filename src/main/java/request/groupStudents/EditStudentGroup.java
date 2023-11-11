package request.groupStudents;

public class EditStudentGroup
{
    private long id;
    private String name;

    public EditStudentGroup(long id, String name) {
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
