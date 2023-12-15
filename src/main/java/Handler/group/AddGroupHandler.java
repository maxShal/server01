package Handler.group;

import Handler.IHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.GroupControl;
import request.groupStudents.AddStudentGroup;

public class AddGroupHandler implements IHandler {

    private final GroupControl groupControl;

    public AddGroupHandler(GroupControl groupControl) {
        this.groupControl = groupControl;
    }

    @Override
    public String hande(String json) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(groupControl.addStudentGroup(mapper.readValue(json, AddStudentGroup.class)));
    }
}
