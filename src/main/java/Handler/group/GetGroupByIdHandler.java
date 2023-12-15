package Handler.group;

import Handler.IHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.GroupControl;
import request.groupStudents.GetStudentGroupById;

public class GetGroupByIdHandler implements IHandler {
    private final GroupControl groupControl;

    public GetGroupByIdHandler(GroupControl groupControl) {
        this.groupControl = groupControl;
    }

    @Override
    public String hande(String json) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(groupControl.getGroupStudentsById(mapper.readValue(json, GetStudentGroupById.class)));
    }
}
