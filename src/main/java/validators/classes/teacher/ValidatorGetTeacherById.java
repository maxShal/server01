package validators.classes.teacher;

import request.teacher.GetteacherById;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetTeacherById implements IValidator<GetteacherById> {

    private ValidateInt validateInt;

    public ValidatorGetTeacherById(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }

    @Override
    public List<String> validator(GetteacherById getteacherById) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result=validateInt.moreZero(getteacherById.getId());
        if(!result)
        {
            array.add("Less 0");
        }
        return array;
    }
}
