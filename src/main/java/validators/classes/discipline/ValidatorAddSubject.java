package validators.classes.discipline;

import request.discipline.AddSubject;
import validators.IValidator;
import validators.primitive.ValidateString;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ValidatorAddSubject implements IValidator<AddSubject>
{
    private final ValidateString validateString;

    public ValidatorAddSubject(ValidateString validateString) {
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(AddSubject addSubject) {
        ArrayList<String> array= new ArrayList<>();
        validateString.lessMax(addSubject.getName(), 255,array,"Name");
        validateString.notNull(addSubject.getName(),array,"Name");
        return array;
    }
}
