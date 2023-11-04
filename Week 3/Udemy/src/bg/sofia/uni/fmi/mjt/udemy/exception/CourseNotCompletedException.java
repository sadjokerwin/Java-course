package bg.sofia.uni.fmi.mjt.udemy.exception;

public class CourseNotCompletedException extends Exception {
    public CourseNotCompletedException() {
        super("This course hasn't been completed");
    }
}
