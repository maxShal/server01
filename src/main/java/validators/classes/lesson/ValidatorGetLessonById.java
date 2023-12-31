package validators.classes.lesson;

import request.lesson.GetLessonById;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetLessonById implements IValidator<GetLessonById> {
    private ValidateInt validateInt;

    public ValidatorGetLessonById(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }

    @Override
    public List<String> validator(GetLessonById getLessonById) {
        ArrayList<String> array= new ArrayList<>();
        validateInt.moreZero(getLessonById.getId(),   array, "groupId");

        return array;
    }
}
