package validators.classes.lesson;

import request.lesson.GetLessonsByTeacher;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetLessonsByTeacher implements IValidator<GetLessonsByTeacher>
{
    private ValidateInt validateInt;
    private ValidateString validateString;

    public ValidatorGetLessonsByTeacher(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }
    @Override
    public List<String> validator(GetLessonsByTeacher getLessonsByTeacher) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result=validateInt.moreZero(getLessonsByTeacher.getTeacherId());
        if(!result)
        {
            array.add("less 0");
        }
        result=validateString.notNull(getLessonsByTeacher.getStartDate());
        if(!result)
        {
            array.add("Is NULL");
        }
        result=validateString.lessMax(getLessonsByTeacher.getStartDate(), 255);
        if(!result)
        {
            array.add("More MAX");
        }

        result=validateString.notNull(getLessonsByTeacher.getEndDate());
        if(!result)
        {
            array.add("Is NULL");
        }
        result=validateString.lessMax(getLessonsByTeacher.getEndDate(), 255);
        if(!result)
        {
            array.add("More MAX");
        }
        return array;
    }
}
