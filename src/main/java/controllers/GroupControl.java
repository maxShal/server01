package controllers;

import entity.GroupStudents;
import request.groupStudents.AddStudentGroup;
import request.groupStudents.DeleteStudentGroup;
import request.groupStudents.EditStudentGroup;
import request.groupStudents.GetStudentGroupById;
import response.CommonResponse;
import response.ResponseEntity;
import response.groupStudent.*;
import services.interfases.IGroupServ;
import validators.classes.groupStudents.ValidatorAddStudentGroup;
import validators.classes.groupStudents.ValidatorDeleteStudentGroup;
import validators.classes.groupStudents.ValidatorEditStudentGroup;
import validators.classes.groupStudents.ValidatorGetStudentGroupById;
import validators.primitive.ValidateInt;

import java.util.ArrayList;

public class GroupControl
{
    private final IGroupServ groupServ;
    private final ValidatorAddStudentGroup validatorAddStudentGroup;
    private final ValidatorGetStudentGroupById validatorGetStudentGroupById;
    private final ValidatorEditStudentGroup validatorEditStudentGroup;
    private final ValidatorDeleteStudentGroup validatorDeleteStudentGroup;


    public GroupControl(IGroupServ groupServ, ValidatorAddStudentGroup validatorAddStudentGroup, ValidatorGetStudentGroupById validatorGetStudentGroupById, ValidatorEditStudentGroup validatorEditStudentGroup, ValidateInt validateInt, ValidatorDeleteStudentGroup validatorDeleteStudentGroup) {
        this.groupServ = groupServ;
        this.validatorAddStudentGroup = validatorAddStudentGroup;
        this.validatorGetStudentGroupById = validatorGetStudentGroupById;
        this.validatorEditStudentGroup = validatorEditStudentGroup;
        this.validatorDeleteStudentGroup = validatorDeleteStudentGroup;
    }

    public ResponseEntity<CommonResponse<GetStudentGroupsResponse>> getGroupStudents()
    {
        var problems =new ArrayList<String>();
        long status = 200L;
        CommonResponse<GetStudentGroupsResponse> response;
        try{
            var groupList=groupServ.getGroups();
            response = new CommonResponse<>(new GetStudentGroupsResponse(groupList));
        }
        catch (Exception e)
        {
            status = 422L;
            response = new CommonResponse<>(e.getMessage());
        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<GetStudentGroupByIdResponse>>getGroupStudentsById(GetStudentGroupById getStudentGroupById)
    {
        var problems = validatorGetStudentGroupById.validator(getStudentGroupById);
        long status =200L;
        CommonResponse<GetStudentGroupByIdResponse> response;
        if(problems.isEmpty())
        {
            try{
                var group = groupServ.getGroup(getStudentGroupById.getId());
                response=new CommonResponse<>(new GetStudentGroupByIdResponse(group));
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

    public ResponseEntity<CommonResponse<AddStudentGroupResponse>> addStudentGroup(AddStudentGroup addStudentGroup)
    {
        var problems = validatorAddStudentGroup.validator(addStudentGroup);
        long status=201L;
        CommonResponse<AddStudentGroupResponse> response;
        if(problems.isEmpty())
        {
            try{
                var id = groupServ.addGroup(new GroupStudents(null,addStudentGroup.name()));
                response =new CommonResponse<>(new AddStudentGroupResponse(id));
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

    public ResponseEntity<CommonResponse<EditStudentGroupResponse>> editStudentsGroup(EditStudentGroup editStudentGroup)
    {
        var problems = validatorEditStudentGroup.validator(editStudentGroup);
        long status= 200L;
        CommonResponse<EditStudentGroupResponse> response;
        if(problems.isEmpty())
        {
            try{
                groupServ.updateGroup(new GroupStudents(editStudentGroup.getId(), editStudentGroup.getName()));
                response=new CommonResponse<>(new EditStudentGroupResponse(editStudentGroup.getName()));
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
    public ResponseEntity<CommonResponse<DeleteStudentGroupResponse>> deleteStudentGroup(DeleteStudentGroup deleteStudentGroup)
    {
        var problems = validatorDeleteStudentGroup.validator(deleteStudentGroup);
        long status =200L;
        CommonResponse<DeleteStudentGroupResponse> response;
        if(problems.isEmpty()){
            try{
                groupServ.deleteGroup(deleteStudentGroup.getId());
                response=new CommonResponse<>(new DeleteStudentGroupResponse());
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
