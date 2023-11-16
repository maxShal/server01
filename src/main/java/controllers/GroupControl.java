package controllers;

import entity.GroupStudents;
import request.IdRequest;
import response.CommonResponse;
import response.ResponseEntity;
import services.interfases.IGroupServ;
import services.interfases.ILessonServ;
import validators.classes.groupStudents.ValidatorAddStudentGroup;
import validators.classes.groupStudents.ValidatorEditStudentGroup;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class GroupControl
{
    private final IGroupServ groupServ;
    private final ValidatorAddStudentGroup validatorAddStudentGroup;
    private final ValidatorEditStudentGroup validatorEditStudentGroup;
    private final ValidateInt validateInt;


    public GroupControl(IGroupServ groupServ, ValidatorAddStudentGroup validatorAddStudentGroup, ValidatorEditStudentGroup validatorEditStudentGroup, ValidateInt validateInt) {
        this.groupServ = groupServ;
        this.validatorAddStudentGroup = validatorAddStudentGroup;
        this.validatorEditStudentGroup = validatorEditStudentGroup;
        this.validateInt = validateInt;
    }

    public ResponseEntity<CommonResponse<List<GroupStudents>>> getGroupStudents()
    {
        var problems =new ArrayList<String>();
        long status = 200L;
        CommonResponse<List<GroupStudents>> response;
        try{
            var groupList=groupServ.getGroups();
            response = new CommonResponse<>(groupList);
        }
        catch (Exception e)
        {
            status = 422L;
            response = new CommonResponse<>(e.getMessage());
        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<GroupStudents>>getGroupStudentsById(IdRequest idRequest)
    {

    }
}
