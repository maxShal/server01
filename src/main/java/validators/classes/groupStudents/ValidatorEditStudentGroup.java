package validators.classes.groupStudents;

import request.groupStudents.EditStudentGroup;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorEditStudentGroup implements IValidator<EditStudentGroup> {
    private ValidateInt validateInt;
    private ValidateString validateString;

    public ValidatorEditStudentGroup(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(EditStudentGroup editStudentGroup) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result = validateInt.moreZero(editStudentGroup.getId());
        if(!result)
        {
            array.add("Less 0");
        }
        result = validateString.lessMax(editStudentGroup.getName(), 255);
        if(!result)
        {
            array.add(" More max");
        }
        result = validateString.notNull(editStudentGroup.getName());
        if(!result)
        {
            array.add("Is NULL");
        }
        return array;
    }
}
