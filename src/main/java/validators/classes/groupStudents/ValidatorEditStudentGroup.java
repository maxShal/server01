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
        validateInt.moreZero(editStudentGroup.getId(), array, "groupId");
        validateString.lessMax(editStudentGroup.getName(),255, array," Name");
        validateString.notNull(editStudentGroup.getName(),array,"Name");
        return array;
    }
}
