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
        validateInt.moreZero(editSubject.getId(),  array, "Id");
        validateString.lessMax(editSubject.getName(),255, array,"Name");
        validateString.notNull(editSubject.getName(),array,"Name");
        return array;
    }
}
