package entity;

import java.util.Objects;

public class GroupStudents
{
    private final String groupName;
    private final Long id;

    public Long getId() {
        return id;
    }

    public GroupStudents(Long id, String groupName) {
        this.groupName = groupName;
        this.id =id;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupStudents that = (GroupStudents) o;
        return Objects.equals(groupName, that.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }
}
