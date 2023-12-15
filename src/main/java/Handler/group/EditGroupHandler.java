package Handler.group;

import Handler.IHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.GroupControl;
import request.groupStudents.EditStudentGroup;

public class EditGroupHandler implements IHandler {
    private final GroupControl groupControl;

    public EditGroupHandler(GroupControl groupControl) {
        this.groupControl = groupControl;
    }

    @Override
    public String hande(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(groupControl.editStudentsGroup(mapper.readValue(json, EditStudentGroup.class)));
    }
}
