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
        result=validateString.notNull(getLessonByGroup.getStartDate());
        if(!result)
        {
            array.add("Is NULL");
        }
        result=validateString.lessMax(getLessonByGroup.getStartDate(), 255);
        if(!result)
        {
            array.add("More MAX");
        }

        result=validateString.notNull(getLessonByGroup.getEndDate());
        if(!result)
        {
            array.add("Is NULL");
        }
        result=validateString.lessMax(getLessonByGroup.getEndDate(), 255);
        if(!result)
        {
            array.add("More MAX");
        }
        return array;
    }
}
