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
        boolean result;
        result = validateInt.moreZero(getSubjectById.getId());
        if(!result)
        {
            array.add("Less 0");
        }
        return array;
    }
}
