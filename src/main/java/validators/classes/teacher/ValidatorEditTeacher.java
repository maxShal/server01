package validators.classes.teacher;

import request.student.EditStudent;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorEditTeacher implements IValidator<EditStudent> {
    private ValidateInt validateInt;
    private ValidateString validateString;

    public ValidatorEditTeacher(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(EditStudent editStudent) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result = validateInt.moreZero(editStudent.getGroupId());
        if(!result)
        {
            array.add("Less 0");
        }
        result=validateString.notNull(editStudent.getFirstName());
        if(!result)
        {
            array.add("Is NULL FirstName");
        }
        result=validateString.notNull(editStudent.getMiddleName());
        if(!result)
        {
            array.add("Is NULL MiddleName");
        }
        result=validateString.notNull(editStudent.getLastName());
        if(!result)
        {
            array.add("Is NULL LastName");
        }

        result=validateString.lessMax(editStudent.getFirstName(),255);
        if(!result)
        {
            array.add("More MAX FirstName");
        }
        result=validateString.lessMax(editStudent.getMiddleName(), 255);
        if(!result)
        {
            array.add("More MAX MiddleName");
        }
        result=validateString.lessMax(editStudent.getLastName(),255);
        if(!result)
        {
            array.add("More MAX LastName");
        }
        return array;
    }
}