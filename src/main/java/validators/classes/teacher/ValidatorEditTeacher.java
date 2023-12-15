package validators.classes.teacher;

import request.student.EditStudent;
import request.teacher.EditTeacher;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorEditTeacher implements IValidator<EditTeacher> {
    private ValidateInt validateInt;
    private ValidateString validateString;

    public ValidatorEditTeacher(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(EditTeacher editTeacher) {
        ArrayList<String> array= new ArrayList<>();
        validateInt.moreZero(editTeacher.getGroupId(), array, "groupId");

        validateString.lessMax(editTeacher.getFirstName(), 255, array,"first Name");
        validateString.lessMax(editTeacher.getMiddleName(),255, array, "middleName");
        validateString.lessMax(editTeacher.getLastName(),255,array,"lastName");

        validateString.notNull(editTeacher.getFirstName(), array,"firstName");
        validateString.notNull(editTeacher.getMiddleName(), array, "middleName");
        validateString.notNull(editTeacher.getLastName(), array, "lastName");
        return array;
    }
}