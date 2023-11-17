import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.GroupControl;
import controllers.StudentControl;
import repositories.DataBase;
import repositories.entityRep.GroupRepos;
import repositories.entityRep.StudentsRepos;
import request.groupStudents.AddStudentGroup;
import request.groupStudents.DeleteStudentGroup;
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
        String result;
        switch(endPoint)
        {
            case "addStudentGroup":
            {
                result=mapper.writeValueAsString(groupControl.addStudentGroup(mapper.readValue(json, AddStudentGroup.class)));
                break;
            }
            case "deleteStudentGroup":
            {
                result=mapper.writeValueAsString(groupControl.deleteStudentGroup(mapper.readValue(json, DeleteStudentGroup.class)));
                break;
            }
        }
    }
}
