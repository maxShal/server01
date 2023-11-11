package validators;

import java.util.List;

public interface IValidator <T>
{
    List<String> validator(T t);
}
