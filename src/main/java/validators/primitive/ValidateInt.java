package validators.primitive;

import java.util.List;

public class ValidateInt
{
    public boolean moreZero(Long i, List<String> error, String fieldName )
    {
        if (i <= 0) {
            error.add(fieldName + " isn't positive");
            return false;
        };
        return true;
    }
}
