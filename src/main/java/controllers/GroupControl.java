package controllers;

import entity.GroupStudents;
import request.groupStudents.AddStudentGroup;
import request.groupStudents.DeleteStudentGroup;
import request.groupStudents.EditStudentGroup;
import request.groupStudents.GetStudentGroupById;
import response.CommonResponse;
import response.ResponseEntity;
import services.interfases.IGroupServ;
import validators.classes.groupStudents.ValidatorAddStudentGroup;
import validators.classes.groupStudents.ValidatorDeleteStudentGroup;
import validators.classes.groupStudents.ValidatorEditStudentGroup;
import validators.classes.groupStudents.ValidatorGetStudentGroupById;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class GroupControl
{
    private final IGroupServ groupServ;
    private final ValidatorAddStudentGroup validatorAddStudentGroup;
    private final ValidatorGetStudentGroupById validatorGetStudentGroupById;
    private final ValidatorEditStudentGroup validatorEditStudentGroup;
    private final ValidatorDeleteStudentGroup validatorDeleteStudentGroup;
    //private final ValidateInt validateInt;


    public GroupControl(IGroupServ groupServ, ValidatorAddStudentGroup validatorAddStudentGroup, ValidatorGetStudentGroupById validatorGetStudentGroupById, ValidatorEditStudentGroup validatorEditStudentGroup, ValidateInt validateInt, ValidatorDeleteStudentGroup validatorDeleteStudentGroup) {
        this.groupServ = groupServ;
        this.validatorAddStudentGroup = validatorAddStudentGroup;
        this.validatorGetStudentGroupById = validatorGetStudentGroupById;
        this.validatorEditStudentGroup = validatorEditStudentGroup;
       // this.validateInt = validateInt;
        this.validatorDeleteStudentGroup = validatorDeleteStudentGroup;
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

    public ResponseEntity<CommonResponse<GroupStudents>>getGroupStudentsById(GetStudentGroupById getStudentGroupById)
    {
        var problems = validatorGetStudentGroupById.validator(getStudentGroupById);
        long status =200L;
        CommonResponse<GroupStudents> response;
        if(problems.isEmpty())
        {
            try{
                var group = groupServ.getGroup(getStudentGroupById.getId());
                response=new CommonResponse<>(group);
            }
            catch (Exception e)
            {
                status=422L;
                response=new CommonResponse<>(e.getMessage());
            }
        }
        else {
            status=422L;
            response=new CommonResponse<>("Problem while validate",problems);
        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<Long>> addStudentGroup(AddStudentGroup addStudentGroup)
    {
        var problems = validatorAddStudentGroup.validator(addStudentGroup);
        long status=201L;
        CommonResponse<Long> response;
        if(problems.isEmpty())
        {
            try{
                var id = groupServ.addGroup(new GroupStudents(null,addStudentGroup.getName()));
                response =new CommonResponse<>(id);
            }
            catch (Exception e)
            {
                status=422L;
                response = new CommonResponse<>(e.getMessage());
            }
        }
        else {
            status=422L;
            response=new CommonResponse<>("Problem while validate", problems);
        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<Long>> editStudentsGroup(EditStudentGroup editStudentGroup)
    {
        var problems = validatorEditStudentGroup.validator(editStudentGroup);
        long status= 200L;
        CommonResponse<Long> response;
        if(problems.isEmpty())
        {
            try{
                groupServ.updateGroup(new GroupStudents(editStudentGroup.getId(), editStudentGroup.getName()));
                response=new CommonResponse<>(editStudentGroup.getId());
            }catch (Exception e)
            {
                status=404L;
                response=new CommonResponse<>(e.getMessage());
            }
        }
        else {
            status=422L;
            response=new CommonResponse<>("Problem while validate", problems);
        }
        return new ResponseEntity<>(response,status);
    }
    public ResponseEntity<CommonResponse<Long>> deleteStudentGroup(DeleteStudentGroup deleteStudentGroup)
    {
        var problems = validatorDeleteStudentGroup.validator(deleteStudentGroup);
        long status =200L;
        CommonResponse<Long> response;
        if(problems.isEmpty()){
            try{
                groupServ.deleteGroup(deleteStudentGroup.getId());
                response=new CommonResponse<>(deleteStudentGroup.getId());
            }catch (Exception e)
            {
                status=422L;
                response=new CommonResponse<>(e.getMessage());
            }
        }
        else {
            status=422L;
            response=new CommonResponse<>("Problem while validate", problems);
        }
        return new ResponseEntity<>(response,status);
    }
}
