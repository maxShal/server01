package validators.classes.student;

import request.student.GetStudentsByGroup;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetStudentByGroup implements IValidator<GetStudentsByGroup> {
    private final ValidateInt validateInt;

    public ValidatorGetStudentByGroup(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }
    @Override
    public List<String> validator(GetStudentsByGroup getStudentsByGroup) {
        ArrayList<String> array= new ArrayList<>();
        validateInt.moreZero(getStudentsByGroup.getId(),array,"studentId");
        return array;
    }
}
