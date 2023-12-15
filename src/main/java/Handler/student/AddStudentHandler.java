package Handler.student;

import Handler.IHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentControl;
import request.student.AddStudent;

public class AddStudentHandler implements IHandler
{
    private final StudentControl studentControl;

    public AddStudentHandler(StudentControl studentControl) {
        this.studentControl = studentControl;
    }

    @Override
    public String hande(String json) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(studentControl.addStudent(mapper.readValue(json, AddStudent.class)));
    }
}
