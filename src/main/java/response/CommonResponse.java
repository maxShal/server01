package response;

import java.util.List;

public class CommonResponse <T>
{
    private final boolean success;
    private T data;
    private String error;
    private List<String> details;

    public CommonResponse( T data) {

        this.success = true;
        this.data = data;
    }

    public CommonResponse( String error) {
        this.success = false;
        this.error = error;
    }

    public CommonResponse(boolean success, List<String> details) {
        this.success = false;
        this.details = details;
    }

    public CommonResponse(String error, List<String> details) {
        this.success = false;
        this.error = error;
        this.details = details;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public List<String> getDetails() {
        return details;
    }
}
