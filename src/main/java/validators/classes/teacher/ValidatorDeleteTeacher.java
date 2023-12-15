package validators.classes.teacher;

import request.teacher.DeleteTeacher;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorDeleteTeacher implements IValidator<DeleteTeacher> {
    private ValidateInt validateInt;

    public ValidatorDeleteTeacher(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }

    @Override
    public List<String> validator(DeleteTeacher deleteTeacher) {
        ArrayList<String> array= new ArrayList<>();
        validateInt.moreZero(deleteTeacher.getId(), array, "Id");
        return array;
    }
}
