package validators.classes.student;

import request.student.EditStudent;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorEditStudent implements IValidator<EditStudent> {
    private final ValidateInt validateInt;
    private final ValidateString validateString;

    public ValidatorEditStudent(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }
    @Override
    public List<String> validator(EditStudent editStudent) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        validateInt.moreZero(editStudent.getGroupId(),array,"groupId");
        validateString.lessMax(editStudent.getFirstName(),255, array,"firstName");
        validateString.lessMax(editStudent.getMiddleName(),255,array,"middleName");
        validateString.lessMax(editStudent.getLastName(),255,array,"lastName");
        validateString.notNull(editStudent.getFirstName(),array,"firstName");
        validateString.notNull(editStudent.getMiddleName(),array,"middleName");
        validateString.notNull(editStudent.getLastName(),array,"lastName");
        return array;
    }
}
