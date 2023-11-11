package validators.classes.groupStudents;

import request.groupStudents.DeleteStudentGroup;
import validators.IValidator;
import validators.primitive.ValidateInt;

import java.util.ArrayList;
import java.util.List;

public class ValidatorDeleteStudentGroup implements IValidator<DeleteStudentGroup> {

    private ValidateInt validateInt;

    public ValidatorDeleteStudentGroup(ValidateInt validateInt) {
        this.validateInt = validateInt;
    }


    @Override
    public List<String> validator(DeleteStudentGroup deleteStudentGroup) {
        ArrayList<String> array= new ArrayList<>();
        boolean result;
        result=validateInt.moreZero(deleteStudentGroup.getId());
        if(!result)
        {
            array.add("less 0");
        }
        return array;
    }
}
