package validators.classes.groupStudents;

import request.groupStudents.AddStudentGroup;
import validators.IValidator;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorAddStudentGroup implements IValidator<AddStudentGroup>
{
    private ValidateString validateString;

    public ValidatorAddStudentGroup(ValidateString validateString) {
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(AddStudentGroup addStudentGroup) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result=validateString.lessMax(addStudentGroup.name(), 255);
        if (!result)
        {
            array.add("Name more Max");
        }
        result=validateString.notNull(addStudentGroup.name());
        if (!result)
        {
            array.add("Is NULL");
        }
        return array;
    }
}
