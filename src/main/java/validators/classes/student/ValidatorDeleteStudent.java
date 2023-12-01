package validators.classes.student;

import request.student.DeleteStudent;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorDeleteStudent implements IValidator<DeleteStudent>{
    private final ValidateInt validateInt;

    public ValidatorDeleteStudent(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }

    @Override
    public List<String> validator(DeleteStudent deleteStudent) {
        ArrayList<String> array= new ArrayList<>();
        validateInt.moreZero(deleteStudent.getId(),array, "studentId");
        return array;
    }
}
