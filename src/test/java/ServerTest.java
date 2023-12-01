import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import request.groupStudents.AddStudentGroup;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    @Test
    void mainMethod1() throws JsonProcessingException {    Server server = new Server();
        String json = new ObjectMapper().writeValueAsString(new AddStudentGroup("ММБ-104-02"));
        String s1=server.mainMethod("GetStudentGroups",json);

        assertEquals(s1, "{\"data\":{\"success\":true,\"data\":{\"name\":[]},\"error\":null,\"details\":null},\"httpStatus\":200}");
    }
}