package validators.classes.lesson;

import request.lesson.GetLessonsByTeacher;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetLessonsByTeacher implements IValidator<GetLessonsByTeacher>
{
    private final ValidateInt validateInt;
    private final ValidateString validateString;

    public ValidatorGetLessonsByTeacher(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }
    @Override
    public List<String> validator(GetLessonsByTeacher getLessonsByTeacher) {
        ArrayList<String> array= new ArrayList<>();
        validateInt.moreZero(getLessonsByTeacher.getTeacherId(), array,"teacherId");
        validateString.lessMax(getLessonsByTeacher.getStartDate(),255,array,"StartDate");
        validateString.lessMax(getLessonsByTeacher.getEndDate(),255,array,"EndDate");
        validateString.lessMax(getLessonsByTeacher.getTeacher().getName(),255,array,"name");
        validateString.lessMax(getLessonsByTeacher.getTeacher().getFathername(),255,array,"father-name");
        validateString.lessMax(getLessonsByTeacher.getTeacher().getSurename(),255,array,"surname");

        validateString.notNull(getLessonsByTeacher.getStartDate(),array,"StartDate");
        validateString.notNull(getLessonsByTeacher.getEndDate(),array,"EndDate");
        validateString.notNull(getLessonsByTeacher.getTeacher().getName(),array,"name");
        validateString.notNull(getLessonsByTeacher.getTeacher().getFathername(),array,"father-name");
        validateString.notNull(getLessonsByTeacher.getTeacher().getSurename(),array,"surname");
        return array;
    }
}
