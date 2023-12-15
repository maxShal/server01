package validators.classes.discipline;

import request.discipline.GetSubjectById;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetSubjectById implements IValidator<GetSubjectById>
{
    private ValidateInt validateInt;

    public ValidatorGetSubjectById(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }

    @Override
    public List<String> validator(GetSubjectById getSubjectById) {
        ArrayList<String> array= new ArrayList<>();
        validateInt.moreZero(getSubjectById.getId(),  array, "Id");
        return array;
    }
}
