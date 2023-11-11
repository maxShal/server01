package request.teacher;

public class AddTeacher
{
    private String lastName;
    private String firstName;
    private String middleName;
    private long groupId;

    public AddTeacher(String lastName, String firstName, String middleName, long groupId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.groupId = groupId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public long getGroupId() {
        return groupId;
    }


}
