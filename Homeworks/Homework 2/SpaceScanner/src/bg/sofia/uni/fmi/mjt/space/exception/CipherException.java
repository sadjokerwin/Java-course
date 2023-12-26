package bg.sofia.uni.fmi.mjt.space.exception;

public class CipherException extends Exception {
    public CipherException (String message) throws CipherException {
        throw new CipherException(message);
    }
}
