package validators.primitive;

public class ValidateString
{
    public boolean lessMax(String string, int max)
    {
        return string.length() < max;
    }
    public boolean notNull(String string)
    {
        return !"".equals(string);
    }
}
