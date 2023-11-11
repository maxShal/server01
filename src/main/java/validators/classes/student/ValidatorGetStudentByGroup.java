package validators.classes.student;

import request.student.GetStudentsByGroup;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetStudentByGroup implements IValidator<GetStudentsByGroup> {
    private ValidateInt validateInt;

    public ValidatorGetStudentByGroup(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }
    @Override
    public List<String> validator(GetStudentsByGroup getStudentsByGroup) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result=validateInt.moreZero(getStudentsByGroup.getId());
        if(!result)
        {
            array.add("Less 0");
        }
        return array;
    }
}
