package validators.classes.discipline;

import request.discipline.DeleteSubject;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorDeleteSubject implements IValidator<DeleteSubject>
{

    private ValidateInt validateInt;

    public ValidatorDeleteSubject(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }

    @Override
    public List<String> validator(DeleteSubject deleteSubject) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result=validateInt.moreZero(deleteSubject.getId());
        if(!result)
        {
            array.add("less 0");
        }
        return array;
    }
}
