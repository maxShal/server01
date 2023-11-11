package validators.classes.student;

import request.student.AddStudent;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorAddStudent implements IValidator<AddStudent> {
    private ValidateInt validateInt;
    private ValidateString validateString;

    public ValidatorAddStudent(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(AddStudent addStudent) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result=validateInt.moreZero(addStudent.getGroupId());
        if(!result)
        {
            array.add("Less 0");
        }
        result=validateString.lessMax(addStudent.getFirstName(),255);
        if(!result)
        {
            array.add("More MAX FirstName");
        }
        result=validateString.lessMax(addStudent.getMiddleName(),255);
        if(!result)
        {
            array.add("More MAX MiddleName");
        }
        result=validateString.lessMax(addStudent.getLastName(),255);
        if(!result)
        {
            array.add("More MAX LastName");
        }
        result=validateString.notNull(addStudent.getFirstName());
        if(!result)
        {
            array.add("NULL FirstName");
        }

        result=validateString.notNull(addStudent.getMiddleName());
        if(!result)
        {
            array.add("NULL MiddleName");
        }
        result=validateString.notNull(addStudent.getLastName());
        if(!result)
        {
            array.add("NULL LastName");
        }
        return array;
    }
}
