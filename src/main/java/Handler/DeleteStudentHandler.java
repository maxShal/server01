package Handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentControl;
import request.student.DeleteStudent;

public class DeleteStudentHandler implements IHandler
{

    private final StudentControl studentControl;

    public DeleteStudentHandler(StudentControl studentControl) {
        this.studentControl = studentControl;
    }

    @Override
    public String hande(String json) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(studentControl.deleteStudent(mapper.readValue(json, DeleteStudent.class)));
    }
}
