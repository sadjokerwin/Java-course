package bg.sofia.uni.fmi.mjt.cooking.exception;

public class NotSupportedMealTypeException extends RuntimeException {
    public NotSupportedMealTypeException(String message) {
        super(message);
    }

    public NotSupportedMealTypeException(String message, Exception cause) {
        super(message, cause);
    }
}
