package Handler.group;

import Handler.IHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.GroupControl;
import request.groupStudents.DeleteStudentGroup;

public class DeleteGroupHandler implements IHandler {
    private final GroupControl groupControl;

    public DeleteGroupHandler(GroupControl groupControl) {
        this.groupControl = groupControl;
    }

    @Override
    public String hande(String json) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(groupControl.deleteStudentGroup(mapper.readValue(json, DeleteStudentGroup.class)));
    }
}
