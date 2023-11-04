package bg.sofia.uni.fmi.mjt.udemy.exception;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException() {
        super("The balance isn't enough to purchase this course");
    }
}
