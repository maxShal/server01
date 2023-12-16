package response;

public record ResponseEntity<T>(T data, long httpStatus) {
}
