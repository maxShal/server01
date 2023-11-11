package validators.classes.student;

import request.student.DeleteStudent;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorDeleteStudent implements IValidator<DeleteStudent>{
    private ValidateInt validateInt;

    public ValidatorDeleteStudent(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }

    @Override
    public List<String> validator(DeleteStudent deleteStudent) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result=validateInt.moreZero(deleteStudent.getId());
        if(!result)
        {
            array.add("Less 0");
        }
        return array;
    }
}
