package validators.classes.lesson;

import request.lesson.GetLessonByGroup;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetLessonByGroup implements IValidator<GetLessonByGroup> {
    private ValidateInt validateInt;
    private ValidateString validateString;

    public ValidatorGetLessonByGroup(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }


    @Override
    public List<String> validator(GetLessonByGroup getLessonByGroup) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result=validateInt.moreZero(getLessonByGroup.getGroupId());
        if(!result)
        {
            array.add("less 0");
        }
        result=validateInt.moreZero((long) getLessonByGroup.getNumberofLesson());
        if(!result)
        {
            array.add("less 0");
        }
        result=validateString.notNull(getLessonByGroup.getTeacher().getSurename());
        if(!result)
        {
            array.add("Null");
        }
        result=validateString.notNull(getLessonByGroup.getTeacher().getName());
        if(!result)
        {
            array.add("Null");
        }
        result=validateString.notNull(getLessonByGroup.getTeacher().getFathername());
        if(!result)
        {
            array.add("Null");
        }
        result=validateInt.moreZero(getLessonByGroup.getTeacher().getId());
        if(!result)
        {
            array.add("less 0");
        }
        result=validateString.lessMax(getLessonByGroup.getTeacher().getSurename(), 255);
        if(!result)
        {
            array.add("More MAX");
        }
        result=validateString.lessMax(getLessonByGroup.getTeacher().getFathername(), 255);
        if(!result)
        {
            array.add("More MAX");
        }
        result=validateString.lessMax(getLessonByGroup.getTeacher().getName(), 255);
        if(!result)
        {
            array.add("More MAX");
        }
        return array;
    }
}
