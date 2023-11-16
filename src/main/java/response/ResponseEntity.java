package response;

public class ResponseEntity <T> {
    private T data;
    private long httpStatus;

    public ResponseEntity(T data, long httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
    }

    public T getData() {
        return data;
    }

    public long getHttpStatus() {
        return httpStatus;
    }
}
