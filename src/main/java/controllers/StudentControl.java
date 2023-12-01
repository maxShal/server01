package controllers;

import entity.Student;
import request.student.*;
import response.CommonResponse;
import response.ResponseEntity;
import response.student.*;
import services.interfases.IGroupServ;
import services.interfases.IStudentServ;
import validators.classes.student.*;

public class StudentControl
{
    private final IStudentServ studentServ;
    private final IGroupServ groupServ;
    private final ValidatorAddStudent validatorAddStudent;
    private final ValidatorDeleteStudent validatorDeleteStudent;
    private final ValidatorEditStudent validatorEditStudent;
    private final ValidatorGetStudentByGroup validatorGetStudentByGroup;
    private final ValidatorGetStudentById validatorGetStudentById;

    public StudentControl(IStudentServ studentServ, IGroupServ groupServ, ValidatorAddStudent validatorAddStudent, ValidatorDeleteStudent validatorDeleteStudent, ValidatorEditStudent validatorEditStudent, ValidatorGetStudentByGroup validatorGetStudentByGroup, ValidatorGetStudentById validatorGetStudentById) {
        this.studentServ = studentServ;
        this.groupServ = groupServ;
        this.validatorAddStudent = validatorAddStudent;
        this.validatorDeleteStudent = validatorDeleteStudent;
        this.validatorEditStudent = validatorEditStudent;
        this.validatorGetStudentByGroup = validatorGetStudentByGroup;
        this.validatorGetStudentById = validatorGetStudentById;
    }

    public ResponseEntity<CommonResponse<AddStudentResponse>> addStudent(AddStudent addStudent)
    {
        var problems = validatorAddStudent.validator(addStudent);
        long status =200L;
        CommonResponse<AddStudentResponse> response;
        if(problems.isEmpty())
        {
            try{
                var group = groupServ.getGroup(addStudent.groupId());
                var id = studentServ.add(new Student(addStudent.groupId(),addStudent.lastName(), addStudent.firstName(), addStudent.middleName(), addStudent.status(),group));
                response=new CommonResponse<>(new AddStudentResponse(id));
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

    public ResponseEntity<CommonResponse<DeleteStudentResponse>> deleteStudent(DeleteStudent deleteStudent)
    {
        var problems = validatorDeleteStudent.validator(deleteStudent);
        long status =200L;
        CommonResponse<DeleteStudentResponse> response;
        if (problems.isEmpty())
        {
            try{
                studentServ.deleteById(deleteStudent.getId());
                response =new CommonResponse<>(new DeleteStudentResponse());
            }catch(Exception e )
            {
                status=422L;
                response = new CommonResponse<>(e.getMessage());
            }
        }
        else{
            status=422L;
            response=new CommonResponse<>("Problem while validate",problems);
        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<EditStudentResponse>> editStudent(EditStudent editStudent)
    {
        var problems = validatorEditStudent.validator(editStudent);
        long status =200L;
        CommonResponse<EditStudentResponse> response;

        if(problems.isEmpty())
        {
            try{
                var group = groupServ.getGroup(editStudent.getGroupId());
                var id = studentServ.add(new Student(editStudent.getGroupId(),editStudent.getLastName(), editStudent.getFirstName(), editStudent.getMiddleName(), editStudent.getStatus(),group));
                response=new CommonResponse<>(new EditStudentResponse(editStudent.getLastName(), editStudent.getFirstName(), editStudent.getMiddleName(), editStudent.getGroupId(),editStudent.getStatus()));
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

    public ResponseEntity<CommonResponse<GetStudentByGroupResponse>> getByGroup(GetStudentsByGroup getStudentsByGroup)
    {
        var problems = validatorGetStudentByGroup.validator(getStudentsByGroup);
        long status =200L;
        CommonResponse<GetStudentByGroupResponse> response;
        if(problems.isEmpty())
        {
            try
            {
                var studentList = studentServ.getAllGroupId(getStudentsByGroup.getId());
                response = new CommonResponse<>(new GetStudentByGroupResponse(studentList));
            }
            catch(Exception e)
            {
                status=422L;
                response = new CommonResponse<>(e.getMessage());
            }
        }
        else
        {
            status=422L;
            response=new CommonResponse<>("Problem while validate",problems);
        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<GetStudentByIdResponse>> getBtId(GetStudentById getStudentById)
    {
        var problems = validatorGetStudentById.validator(getStudentById);
        long status =200L;
        CommonResponse<GetStudentByIdResponse> response;
        if(problems.isEmpty())
        {
            try
            {
                var student = studentServ.getById(getStudentById.getId());
                response = new CommonResponse<>(new GetStudentByIdResponse(student.getSurename(),student.getName(),student.getFathername(),student.getId(),student.getStatus()));
            }
            catch(Exception e)
            {
                status=422L;
                response = new CommonResponse<>(e.getMessage());
            }
        }
        else
        {
            status=422L;
            response=new CommonResponse<>("Problem while validate",problems);
        }
        return new ResponseEntity<>(response,status);
    }
}
