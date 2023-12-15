package Handler.student;

import Handler.IHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentControl;
import request.student.EditStudent;

public class EditStudentHandler implements IHandler {

    private final StudentControl studentControl;

    public EditStudentHandler(StudentControl studentControl) {
        this.studentControl = studentControl;
    }

    @Override
    public String hande(String json) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(studentControl.editStudent(mapper.readValue(json, EditStudent.class)));
    }
}
