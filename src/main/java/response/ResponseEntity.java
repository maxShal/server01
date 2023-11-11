package response;

public class ResponseEntity <T> {
    private T data;
    private int httpStatus;

    public ResponseEntity(T data, int httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
    }

    public T getData() {
        return data;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
