package bg.sofia.uni.fmi.mjt.udemy.exception;

public class CourseAlreadyPurchasedException extends Exception {
    public CourseAlreadyPurchasedException() {
        super("This course has already been purchased");
    }
}
