package validators.classes.student;

import request.student.AddStudent;
import validators.IValidator;
import validators.primitive.ValidateInt;
import validators.primitive.ValidateString;

import java.util.ArrayList;
import java.util.List;

public class ValidatorAddStudent implements IValidator<AddStudent> {
    private ValidateInt validateInt;
    private ValidateString validateString;

    public ValidatorAddStudent(ValidateInt validateInt, ValidateString validateString) {
        this.validateInt = validateInt;
        this.validateString = validateString;
    }

    @Override
    public List<String> validator(AddStudent addStudent) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        
    }
}
