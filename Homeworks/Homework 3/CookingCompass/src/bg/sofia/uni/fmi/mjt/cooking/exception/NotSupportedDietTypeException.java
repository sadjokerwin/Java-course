package bg.sofia.uni.fmi.mjt.cooking.exception;

public class NotSupportedDietTypeException extends RuntimeException {
    public NotSupportedDietTypeException(String message) {
        super(message);
    }

    public NotSupportedDietTypeException(String message, Exception cause) {
        super(message, cause);
    }
}
