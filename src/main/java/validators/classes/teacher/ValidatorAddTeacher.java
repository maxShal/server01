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
        validateInt.moreZero(addTeacher.getGroupId(),  array, "groupId");

        validateString.lessMax(addTeacher.getFirstName(),255, array,"first Name");
        validateString.lessMax(addTeacher.getMiddleName(),255, array, "middleName");
        validateString.lessMax(addTeacher.getLastName(), 255,array,"lastname");

        validateString.notNull(addTeacher.getFirstName(),array,"firstName");
        validateString.notNull(addTeacher.getMiddleName(), array, "middleName");
        validateString.notNull(addTeacher.getLastName(), array, "lastName");

        return array;
    }
}
