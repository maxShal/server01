package validators.primitive;

import java.util.List;

public class ValidateString
{
    public boolean lessMax(String string, int max, List<String> error, String fieldName)
    {
        if (string.length() < max)
        {
            error.add(fieldName + " less max ");
            return false;
        }
        return true;
    }
    public boolean notNull(String string, List<String> error, String fieldName)
    {
        if(!"".equals(string))
        {
            error.add(fieldName+" is NULL");
            return false;
        }
        return true;
    }
}
