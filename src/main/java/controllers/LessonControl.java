package controllers;

import entity.Lesson;
import request.lesson.AddLesson;
import request.lesson.GetLessonByGroup;
import request.lesson.GetLessonById;
import request.lesson.GetLessonsByTeacher;
import response.CommonResponse;
import response.ResponseEntity;
import response.lesson.AddLessonResponse;
import response.lesson.GetLessonByGroupResponse;
import response.lesson.GetLessonByIdResponse;
import response.lesson.GetLessonByTeacherResponse;
import services.interfases.IGroupServ;
import services.interfases.ILessonServ;
import services.interfases.ITeacherServ;
import validators.classes.lesson.ValidatorAddLesson;
import validators.classes.lesson.ValidatorGetLessonByGroup;
import validators.classes.lesson.ValidatorGetLessonById;
import validators.classes.lesson.ValidatorGetLessonsByTeacher;

public class LessonControl
{
    private final ILessonServ lessonServ;
    private final ITeacherServ teacherServ;
    private final IGroupServ groupServ;

    private final ValidatorAddLesson validatorAddLesson;

    private final ValidatorGetLessonByGroup validatorGetLessonByGroup;
    private final ValidatorGetLessonById validatorGetLessonById;
    private final ValidatorGetLessonsByTeacher validatorGetLessonsByTeacher;

    public LessonControl(ILessonServ lessonServ, ITeacherServ teacherServ, IGroupServ groupServ, ValidatorAddLesson validatorAddLesson, ValidatorGetLessonByGroup validatorGetLessonByGroup, ValidatorGetLessonById validatorGetLessonById, ValidatorGetLessonsByTeacher validatorGetLessonsByTeacher) {
        this.lessonServ = lessonServ;
        this.teacherServ = teacherServ;
        this.groupServ = groupServ;
        this.validatorAddLesson = validatorAddLesson;
        this.validatorGetLessonByGroup = validatorGetLessonByGroup;
        this.validatorGetLessonById = validatorGetLessonById;
        this.validatorGetLessonsByTeacher = validatorGetLessonsByTeacher;
    }

    public ResponseEntity<CommonResponse<AddLessonResponse>> addLesson(AddLesson addLesson)
    {
        var problems = validatorAddLesson.validator(addLesson);
        long status=200L;
        CommonResponse<AddLessonResponse> response;
        if(problems.isEmpty())
        {
            try{
                var id = lessonServ.add(new Lesson(null,addLesson.getNumberOfLesson(),addLesson.getTeacher(),addLesson.getGroupStudents(),addLesson.getDate()));
                response = new CommonResponse<>(new AddLessonResponse(id));
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
            response=new CommonResponse<>("Problem while validate", problems);
        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<GetLessonByGroupResponse>> getLessonByGroup(GetLessonByGroup getLessonByGroup)
    {
        var problems = validatorGetLessonByGroup.validator(getLessonByGroup);
        long status=200L;
        CommonResponse<GetLessonByGroupResponse> response;
        if(problems.isEmpty())
        {
            try{
                var lessonList = lessonServ.getAllByIdGroup(getLessonByGroup.getGroupId());
                response = new CommonResponse<>(new GetLessonByGroupResponse(getLessonByGroup.getNumberofLesson(),getLessonByGroup.getTeacher(),getLessonByGroup.getDate()));
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
            response=new CommonResponse<>("Problem while validate", problems);
        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<GetLessonByIdResponse>> getLessonById(GetLessonById getLessonById)
    {
        var problems = validatorGetLessonById.validator(getLessonById);
        long status=200L;
        CommonResponse<GetLessonByIdResponse> response;
        if(problems.isEmpty())
        {
            try{
                var lesson = lessonServ.getById(getLessonById.getId());
                response = new CommonResponse<>(new GetLessonByIdResponse(lesson.getNumberOfLesson(),lesson.getTeacher(),lesson.getGroupStudents(),lesson.getDate()));
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
            response=new CommonResponse<>("Problem while validate", problems);
        }
        return new ResponseEntity<>(response,status);
    }

    public ResponseEntity<CommonResponse<GetLessonByTeacherResponse>> getLessonByTeacher(GetLessonsByTeacher getLessonsByTeacher)
    {
        var problems = validatorGetLessonsByTeacher.validator(getLessonsByTeacher);
        long status=200L;
        CommonResponse<GetLessonByTeacherResponse> response;
        if(problems.isEmpty())
        {
            try{
                var lesson = lessonServ.getAllByTeacher(getLessonsByTeacher.getTeacher());
                response = new CommonResponse<>(new GetLessonByTeacherResponse(getLessonsByTeacher.getNumberOfLesson(),getLessonsByTeacher.getGroupStudents(),getLessonsByTeacher.getLocalDate()));
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
            response=new CommonResponse<>("Problem while validate", problems);
        }
        return new ResponseEntity<>(response,status);
    }

}
