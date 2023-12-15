package validators.classes.lesson;

import request.lesson.AddLesson;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorAddLesson implements IValidator<AddLesson> {

    private ValidateInt validateInt;

    public ValidatorAddLesson(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }

    @Override
    public List<String> validator(AddLesson addLesson) {
        ArrayList<String> array= new ArrayList<>();
        validateInt.moreZero(addLesson.getTeacherId(),  array, "teacherId");
        validateInt.moreZero(addLesson.getGroupStudentsId(),  array, "groupStudentsId");
        return array;
    }
}
