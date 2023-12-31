package validators.classes.student;

import request.student.GetStudentById;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetStudentById implements IValidator<GetStudentById>
{
    private final ValidateInt validateInt;

    public ValidatorGetStudentById(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }

    @Override
    public List<String> validator(GetStudentById getStudentById) {
        ArrayList<String> array= new ArrayList<>();
        validateInt.moreZero(getStudentById.getId(),array,"studentId");
        return array;
    }
}
