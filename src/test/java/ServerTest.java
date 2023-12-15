import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import request.groupStudents.AddStudentGroup;

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

    }

    @Test
    void mainMethod1() throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(new AddStudentGroup("ММБ-104-02"));
        String s1=server.mainMethod("GetStudentGroups",json);

        assertEquals(s1, "{\"data\":{\"success\":true,\"data\":{\"name\":[]},\"error\":null,\"details\":null},\"httpStatus\":200}");
    }
}