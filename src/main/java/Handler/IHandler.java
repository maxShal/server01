package Handler;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IHandler
{
    String hande(String string) throws JsonProcessingException;
}
