package controllers;

import entity.Discipline;
import request.discipline.*;
import response.CommonResponse;
import response.ResponseEntity;
import response.discipline.*;
import response.groupStudent.GetStudentGroupsResponse;
import services.interfases.IDisciplineServ;
import validators.classes.discipline.ValidatorAddSubject;
import validators.classes.discipline.ValidatorDeleteSubject;
import validators.classes.discipline.ValidatorEditSubject;
import validators.classes.discipline.ValidatorGetSubjectById;

import java.util.ArrayList;

public class DisciplineControl {
    private final IDisciplineServ disciplineServ;
    private final ValidatorAddSubject validatorAddSubject;
    private final ValidatorDeleteSubject validatorDeleteSubject;
    private final ValidatorEditSubject validatorEditSubject;
    private final ValidatorGetSubjectById validatorGetSubjectById;

    public DisciplineControl(IDisciplineServ iDisciplineServ, ValidatorAddSubject validatorAddSubject, ValidatorDeleteSubject validatorDeleteSubject, ValidatorEditSubject validatorEditSubject, ValidatorGetSubjectById validatorGetSubjectById) {
        this.disciplineServ = iDisciplineServ;
        this.validatorAddSubject = validatorAddSubject;
        this.validatorDeleteSubject = validatorDeleteSubject;
        this.validatorEditSubject = validatorEditSubject;
        this.validatorGetSubjectById = validatorGetSubjectById;
    }

    public ResponseEntity<CommonResponse<AddSubjectResponse>> addSubject(AddSubject addSubject)
    {
        var problems =validatorAddSubject.validator(addSubject);
        long status = 200L;
        CommonResponse<AddSubjectResponse> response;
        if(problems.isEmpty())
        {


        try{
            var id=disciplineServ.add(new Discipline(null,addSubject.getName()));
            response = new CommonResponse<>(new AddSubjectResponse(addSubject.getName()));
        }
        catch (Exception e)
        {
            status = 422L;
            response = new CommonResponse<>(e.getMessage());
        }   }
        else {
        status=422L;
        response=new CommonResponse<>("Problem while validate",problems);
    }
        return new ResponseEntity<>(response,status);
    }


    public ResponseEntity<CommonResponse<DeleteSubjectResponse>> deleteSubject(DeleteSubject deleteSubject)
    {
        var problems =validatorDeleteSubject.validator(deleteSubject);
        long status = 200L;
        CommonResponse<DeleteSubjectResponse> response;
        if(problems.isEmpty())
        {
            try{
                disciplineServ.deleteById(deleteSubject.getId());
                response = new CommonResponse<>(new DeleteSubjectResponse());
            }
            catch (Exception e)
            {
                status = 422L;
                response = new CommonResponse<>(e.getMessage());
            }
        }
        else {
            status=422L;
            response=new CommonResponse<>("Problem while validate", problems);

        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<EditSubjectResponse>> updateSubject(EditSubject editSubject)
    {
        var problems =validatorEditSubject.validator(editSubject);
        long status = 200L;
        CommonResponse<EditSubjectResponse> response;
        if(problems.isEmpty())
        {
            try{
                disciplineServ.update(new Discipline(editSubject.getId(), editSubject.getName()));
                response = new CommonResponse<>(new EditSubjectResponse(editSubject.getName()));
            }
            catch (Exception e)
            {
                status = 422L;
                response = new CommonResponse<>(e.getMessage());
            }
        }
        else {
            status=422L;
            response=new CommonResponse<>("Problem while validate", problems);

        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<GetSubjectsResponse>> getSubjects()
    {
        var problems =new ArrayList<String>();
        long status = 200L;
        CommonResponse<GetSubjectsResponse> response;
            try{
                var subjectList =disciplineServ.getAll();
                response = new CommonResponse<>(new GetSubjectsResponse(subjectList));
            }
            catch (Exception e)
            {
                status = 422L;
                response = new CommonResponse<>(e.getMessage());
            }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<GetSubjectByIdResponse>> getSubjectById(GetSubjectById getSubjectById)
    {
        var problems =validatorGetSubjectById.validator(getSubjectById);
        long status = 200L;
        CommonResponse<GetSubjectByIdResponse> response;
        if(problems.isEmpty())
        {
            try{
                var discipline =disciplineServ.getById(getSubjectById.getId());
                response = new CommonResponse<>(new GetSubjectByIdResponse(discipline.getTitle()));
            }
            catch (Exception e)
            {
                status = 422L;
                response = new CommonResponse<>(e.getMessage());
            }
        }
        else {
            status=422L;
            response=new CommonResponse<>("Problem while validate", problems);

        }
        return new ResponseEntity<>(response,status);
    }
}
