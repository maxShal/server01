package controllers;

import entity.Teacher;
import request.teacher.AddTeacher;
import request.teacher.DeleteTeacher;
import request.teacher.EditTeacher;
import request.teacher.GetteacherById;
import response.CommonResponse;
import response.ResponseEntity;
import response.groupStudent.GetStudentGroupsResponse;
import response.teacher.*;
import services.interfases.ITeacherServ;
import validators.classes.teacher.ValidatorAddTeacher;
import validators.classes.teacher.ValidatorDeleteTeacher;
import validators.classes.teacher.ValidatorEditTeacher;
import validators.classes.teacher.ValidatorGetTeacherById;

import java.util.ArrayList;

public class TeacherControl {
    private final ITeacherServ teacherServ;
    private final ValidatorAddTeacher validatorAddTeacher;
    private final ValidatorDeleteTeacher validatorDeleteTeacher;
    private final ValidatorEditTeacher validatorEditTeacher;
    private final ValidatorGetTeacherById validatorGetTeacherById;
    public TeacherControl(ITeacherServ teacherServ, ValidatorAddTeacher validatorAddTeacher, ValidatorDeleteTeacher validatorDeleteTeacher, ValidatorEditTeacher validatorEditTeacher, ValidatorGetTeacherById validatorGetTeacherById) {
        this.teacherServ = teacherServ;
        this.validatorAddTeacher = validatorAddTeacher;
        this.validatorDeleteTeacher = validatorDeleteTeacher;
        this.validatorEditTeacher = validatorEditTeacher;
        this.validatorGetTeacherById = validatorGetTeacherById;
    }

    public ResponseEntity<CommonResponse<AddTeacherResponse>> addTeacher (AddTeacher addTeacher)
    {
        var problems = validatorAddTeacher.validator(addTeacher);
        long status=201L;
        CommonResponse<AddTeacherResponse> response;
        if(problems.isEmpty())
        {
            try
            {
                var id=teacherServ.add(new Teacher(null, addTeacher.getLastName(), addTeacher.getFirstName(), addTeacher.getFirstName()));
                response=new CommonResponse<>(new AddTeacherResponse(id));
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

    public ResponseEntity<CommonResponse<DeleteTeacherResponse>> deleteTeacher (DeleteTeacher deleteTeacher)
    {
        var problems = validatorDeleteTeacher.validator(deleteTeacher);
        long status=201L;
        CommonResponse<DeleteTeacherResponse> response;
        if(problems.isEmpty())
        {
            try
            {
                teacherServ.deleteById(deleteTeacher.getId());
                response=new CommonResponse<>(new DeleteTeacherResponse());
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

    public ResponseEntity<CommonResponse<EditTeacherResponse>> editTeacher (EditTeacher editTeacher)
    {
        var problems = validatorEditTeacher.validator(editTeacher);
        long status=201L;
        CommonResponse<EditTeacherResponse> response;
        if(problems.isEmpty())
        {
            try
            {
                teacherServ.update(new Teacher(editTeacher.getGroupId(),editTeacher.getLastName(), editTeacher.getFirstName(), editTeacher.getFirstName()));
                response=new CommonResponse<>(new EditTeacherResponse(editTeacher.getLastName(), editTeacher.getFirstName(), editTeacher.getMiddleName()));
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

    public ResponseEntity<CommonResponse<GetTeacherByIdResponse>> getTeacherById (GetteacherById getteacherById)
    {
        var problems = validatorGetTeacherById.validator(getteacherById);
        long status=201L;
        CommonResponse<GetTeacherByIdResponse> response;
        if(problems.isEmpty())
        {
            try
            {
                var teacher =teacherServ.gatById(getteacherById.getId());
                response=new CommonResponse<>(new GetTeacherByIdResponse(teacher.getSurename(), teacher.getName(),teacher.getFathername()));
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

    public ResponseEntity<CommonResponse<GetTeacherResponse>> getTeachers()
    {
        var problems =new ArrayList<String>();
        long status = 200L;
        CommonResponse<GetTeacherResponse> response;
        try{
            var teacherList=teacherServ.getAll();
            response = new CommonResponse<>(new GetTeacherResponse(teacherList));
        }
        catch (Exception e)
        {
            status = 422L;
            response = new CommonResponse<>(e.getMessage());
        }
        return new ResponseEntity<>(response,status);
    }
}
