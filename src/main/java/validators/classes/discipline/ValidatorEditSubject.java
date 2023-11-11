package validators.classes.discipline;

import request.discipline.EditSubject;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorEditSubject implements IValidator<EditSubject>
{
    private ValidateInt validateInt;
    private ValidateString validateString;

    public ValidatorEditSubject(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(EditSubject editSubject) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result = validateInt.moreZero(editSubject.getId());
        if(!result)
        {
            array.add("Less 0");
        }
        result = validateString.lessMax(editSubject.getName(), 255);
        if(!result)
        {
            array.add(" More max");
        }
        result = validateString.notNull(editSubject.getName());
        if(!result)
        {
            array.add("Is NULL");
        }
        return array;
    }
}
