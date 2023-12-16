package validators.classes.groupStudents;

import request.groupStudents.AddStudentGroup;
import validators.IValidator;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorAddStudentGroup implements IValidator<AddStudentGroup>
{
    private final ValidateString validateString;

    public ValidatorAddStudentGroup(ValidateString validateString) {
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(AddStudentGroup addStudentGroup) {
        ArrayList<String> array= new ArrayList<>();
        validateString.lessMax(addStudentGroup.name(), 255,array,"name");
        validateString.notNull(addStudentGroup.name(), array,"name");
        return array;
    }
}
