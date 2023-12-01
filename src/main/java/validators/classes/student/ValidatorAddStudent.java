package validators.classes.student;

import request.student.AddStudent;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorAddStudent implements IValidator<AddStudent> {
    private final ValidateInt validateInt;
    private final ValidateString validateString;

    public ValidatorAddStudent(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(AddStudent addStudent) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        validateInt.moreZero(addStudent.groupId(), array, "groupId");
        validateString.lessMax(addStudent.firstName(),255, array,"first Name");
        validateString.lessMax(addStudent.middleName(),255, array, "middleName");
        validateString.lessMax(addStudent.lastName(),255,array,"lastName");
        validateString.notNull(addStudent.firstName(),array,"firstName");
        validateString.notNull(addStudent.middleName(),array, "middleName");
        validateString.notNull(addStudent.lastName(), array, "lastName");
        return array;
    }
}
