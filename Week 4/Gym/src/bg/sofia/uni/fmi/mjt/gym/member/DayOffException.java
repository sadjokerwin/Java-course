package bg.sofia.uni.fmi.mjt.gym.member;

public class DayOffException extends RuntimeException {
    public DayOffException() {
        super("It is a day off");
    }
}
