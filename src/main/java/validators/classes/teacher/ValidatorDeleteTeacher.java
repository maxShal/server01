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
        boolean result;
        result=validateInt.moreZero(deleteTeacher.getId());
        if(!result)
        {
            array.add("Less 0");
        }
        return array;
    }
}
