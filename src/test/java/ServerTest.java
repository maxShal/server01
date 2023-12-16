import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import request.IdRequest;
import request.groupStudents.AddStudentGroup;
import request.groupStudents.DeleteStudentGroup;
import request.groupStudents.EditStudentGroup;
import response.CommonResponse;
import response.ResponseEntity;
import response.groupStudent.AddStudentGroupResponse;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {


    Server server;
    ObjectMapper mapper;
    @BeforeEach
    void setUp(){
        server= new Server();
        mapper = new ObjectMapper();
    }

    @Test
    void testAddGroup() throws JsonProcessingException{
        String string = mapper.writeValueAsString(new ResponseEntity<>(new CommonResponse<>(new AddStudentGroupResponse(1L)),201L));

        String json = mapper.writeValueAsString(new AddStudentGroup("ММБ-104"));
        String result = server.mainMethod("addGroup",json);
        assertEquals(string,result);
    }

    @Test
    void testDeleteGroup() throws JsonProcessingException{
        server.mainMethod("addGroup", mapper.writeValueAsString(new AddStudentGroup("ММБ-104")));
        String string = mapper.writeValueAsString(new ResponseEntity<>(new CommonResponse<>(new DeleteStudentGroup(1L)),200L));

        String json =mapper.writeValueAsString(new DeleteStudentGroup(1L));
        String result = server.mainMethod("deleteGroup",json);
        assertEquals(string,result);

    }

    @Test
    void testEditGroup() throws JsonProcessingException{
        server.mainMethod("addGroup", mapper.writeValueAsString(new AddStudentGroup("ММБ-104")));
        String s=mapper.writeValueAsString(new ResponseEntity<>(new CommonResponse<>(new EditStudentGroup(1L,"ММБ-103")),200L));

        String json = mapper.writeValueAsString(new EditStudentGroup(1L,"ММБ-103"));
        String result = server.mainMethod("editGroup",json);
        assertEquals(s,result);
    }

    @Test
    void mainMethod1() throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(new AddStudentGroup("ММБ-104-02"));
        String s1=server.mainMethod("getGroups",json);

        assertEquals(s1, "{\"data\":{\"success\":true,\"data\":{\"name\":[]},\"error\":null,\"details\":null},\"httpStatus\":200}");
    }
}