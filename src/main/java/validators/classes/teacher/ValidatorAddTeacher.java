package validators.classes.teacher;

import request.teacher.AddTeacher;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorAddTeacher implements IValidator<AddTeacher> {
    private ValidateInt validateInt;
    private ValidateString validateString;

    public ValidatorAddTeacher(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }
    @Override
    public List<String> validator(AddTeacher addTeacher) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result=validateInt.moreZero(addTeacher.getGroupId());
        if(!result)
        {
            array.add("Less 0");
        }
        result=validateString.notNull(addTeacher.getFirstName());
        if(!result)
        {
            array.add("Is NULL FirstName");
        }
        result=validateString.notNull(addTeacher.getMiddleName());
        if(!result)
        {
            array.add("Is NULL MiddleName");
        }
        result=validateString.notNull(addTeacher.getLastName());
        if(!result)
        {
            array.add("Is NULL LastName");
        }
        result=validateString.lessMax(addTeacher.getFirstName(), 255);
        if(!result)
        {
            array.add("More MAX FirstName");
        }
        result=validateString.lessMax(addTeacher.getMiddleName(), 255);
        if(!result)
        {
            array.add("More MAX MiddleName");
        }
        result=validateString.lessMax(addTeacher.getLastName(), 255);
        if(!result)
        {
            array.add("More MAX LastName");
        }
        return array;
    }
}
