package validators.classes.discipline;

import request.discipline.AddSubject;
import validators.IValidator;
import validators.primitive.ValidateString;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ValidatorAddSubject implements IValidator<AddSubject>
{
    private ValidateString validateString;

    public ValidatorAddSubject(ValidateString validateString) {
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(AddSubject addSubject) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
       result=validateString.lessMax(addSubject.getName(), 255);
       if (!result)
       {
           array.add("Name more Max");
       }
       result=validateString.notNull(addSubject.getName());
        if (!result)
        {
            array.add("Is NULL");
        }
        return array;
    }
}
