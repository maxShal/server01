import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.GroupControl;
import controllers.StudentControl;
import entity.GroupStudents;
import entity.Student;
import repositories.DataBase;
import repositories.entityRep.GroupRepos;
import repositories.entityRep.StudentsRepos;
import request.groupStudents.*;
import request.student.*;
import response.CommonResponse;
import response.ResponseEntity;
import services.entityServ.GroupServ;
import services.entityServ.StudentServ;
import validators.classes.groupStudents.ValidatorAddStudentGroup;
import validators.classes.groupStudents.ValidatorDeleteStudentGroup;
import validators.classes.groupStudents.ValidatorEditStudentGroup;
import validators.classes.groupStudents.ValidatorGetStudentGroupById;
import validators.classes.student.*;
import validators.classes.teacher.ValidatorEditTeacher;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.HashMap;

public class Server
{
    private final ValidateString validateString;
    private final ValidateInt validateInt;
    private final ValidatorAddStudentGroup validatorAddStudentGroup;
    private final ValidatorDeleteStudentGroup validatorDeleteStudentGroup;
    private final ValidatorEditStudentGroup validatorEditStudentGroup;
    private final ValidatorGetStudentGroupById validatorGetStudentGroupById;
    private final ValidatorAddStudent validatorAddStudent;
    private final ValidatorDeleteStudent validatorDeleteStudent;
    private final ValidatorEditStudent validatorEditStudent;
    private final ValidatorGetStudentByGroup validatorGetStudentByGroup;
    private final ValidatorGetStudentById validatorGetStudentById;
    private final DataBase dataBase;
    private final GroupRepos groupRepos;
    private final GroupServ groupServ;
    private final StudentsRepos studentsRepos;
    private final StudentServ studentServ;
    private final GroupControl groupControl;
    private final StudentControl studentControl;

    public Server() {
        this.validateString =new ValidateString();
        this.validateInt = new ValidateInt();
        this.validatorAddStudentGroup=new ValidatorAddStudentGroup(validateString);
        this.validatorDeleteStudentGroup=new ValidatorDeleteStudentGroup(validateInt);
        this.validatorEditStudentGroup=new ValidatorEditStudentGroup(validateInt,validateString);
        this.validatorGetStudentGroupById=new ValidatorGetStudentGroupById(validateInt);

        this.validatorAddStudent=new ValidatorAddStudent(validateInt,validateString);
        this.validatorDeleteStudent=new ValidatorDeleteStudent(validateInt);
        this.validatorEditStudent=new ValidatorEditStudent(validateInt,validateString);
        this.validatorGetStudentByGroup=new ValidatorGetStudentByGroup(validateInt);
        this.validatorGetStudentById=new ValidatorGetStudentById(validateInt);

        this.dataBase=new DataBase(new HashMap<>(),new HashMap<>(),new HashMap<>(),new HashMap<>(),new HashMap<>());

        this.groupRepos=new GroupRepos(dataBase);
        this.studentsRepos=new StudentsRepos(dataBase);

        this.groupServ=new GroupServ(groupRepos);
        this.studentServ=new StudentServ(studentsRepos);

        this.groupControl=new GroupControl(groupServ,validatorAddStudentGroup,validatorGetStudentGroupById,validatorEditStudentGroup,validateInt,validatorDeleteStudentGroup);
        this.studentControl=new StudentControl(studentServ,groupServ,validatorAddStudent,validatorDeleteStudent,validatorEditStudent,validatorGetStudentByGroup,validatorGetStudentById);

    }

    public String mainMethod(String endPoint, String json) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        String result="";
        switch(endPoint)
        {
            case "AddStudentGroup":
            {
                result=mapper.writeValueAsString(groupControl.addStudentGroup(mapper.readValue(json, AddStudentGroup.class)));
                break;
            }
            case "DeleteStudentGroup":
            {
                result=mapper.writeValueAsString(groupControl.deleteStudentGroup(mapper.readValue(json, DeleteStudentGroup.class)));
                break;
            }
            case "EditStudentGroup":
            {
                result=mapper.writeValueAsString(groupControl.editStudentsGroup(mapper.readValue(json, EditStudentGroup.class)));
                break;
            }
            case "GetStudentGroupById":
            {
                result=mapper.writeValueAsString(groupControl.getGroupStudentsById(mapper.readValue(json, GetStudentGroupById.class)));
                break;
            }
            case "GetStudentGroups":
            {
                result=mapper.writeValueAsString(groupControl.getGroupStudents());
                break;
            }
            case "AddStudent":
            {
                result=mapper.writeValueAsString(studentControl.addStudent(mapper.readValue(json, AddStudent.class)));
                break;
            }
            case "DeleteStudent":
            {
                result=mapper.writeValueAsString(studentControl.deleteStudent(mapper.readValue(json, DeleteStudent.class)));
                break;
            }
            case "EditStudent":
            {
                result =mapper.writeValueAsString(studentControl.editStudent(mapper.readValue(json, EditStudent.class)));
                break;
            }
            case "GetStudentById":
            {
                result =mapper.writeValueAsString(studentControl.getBtId(mapper.readValue(json, GetStudentById.class)));
                break;
            }
            case "GetStudentsByGroup":
            {
                result =mapper.writeValueAsString(studentControl.getByGroup(mapper.readValue(json, GetStudentsByGroup.class)));
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) throws JsonProcessingException {
        Server server = new Server();
        ObjectMapper objectMapper = new ObjectMapper();
        //String jsonStudent = objectMapper.writeValueAsString(new Student(null, "Karabalin", "Ruslan", "kak-to tam", "Study", new GroupStudents(null, "ММБ-104_02")));
        String jsonStudent = objectMapper.writeValueAsString(new AddStudent("Karabalin", "Ruslan"," Kak-to tam",1L,"Study"));///1L?
        String json = new ObjectMapper().writeValueAsString(new AddStudentGroup("ММБ-104-02"));
        //System.out.println(jsonStudent);
        System.out.println(server.mainMethod("GetStudentGroups",json));

    }
}
