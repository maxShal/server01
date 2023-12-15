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
        validateInt.moreZero(getLessonByGroup.getGroupId(),  array, "groupId");
        validateInt.moreZero((long) getLessonByGroup.getNumberofLesson(),  array, "groupId");
        return array;
    }
}
