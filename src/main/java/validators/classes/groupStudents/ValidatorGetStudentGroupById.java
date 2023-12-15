package validators.classes.groupStudents;

import request.groupStudents.GetStudentGroupById;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetStudentGroupById implements IValidator<GetStudentGroupById>
{
    private final ValidateInt validateInt;

    public ValidatorGetStudentGroupById(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }

    @Override
    public List<String> validator(GetStudentGroupById getStudentGroupById) {
        ArrayList<String> array= new ArrayList<>();
        validateInt.moreZero(getStudentGroupById.getId(), array,"Id");
        return array;
    }
}
