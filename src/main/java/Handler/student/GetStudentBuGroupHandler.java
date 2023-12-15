package Handler.student;

import Handler.IHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentControl;
import request.student.GetStudentsByGroup;

public class GetStudentBuGroupHandler  implements IHandler {
    private final StudentControl studentControl;

    public GetStudentBuGroupHandler(StudentControl studentControl) {
        this.studentControl = studentControl;
    }

    @Override
    public String hande(String json) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(studentControl.getByGroup(mapper.readValue(json, GetStudentsByGroup.class)));
    }
}
