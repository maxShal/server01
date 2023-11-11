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
        boolean result;
        result=validateInt.moreZero(addLesson.getTeacherId());
        if(!result)
        {
            array.add("less 0");
        }
        result=validateInt.moreZero(addLesson.getGroupStudentsId());
        if(!result)
        {
            array.add("less 0");
        }
        return array;
    }
}
