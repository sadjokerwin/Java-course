package bg.sofia.uni.fmi.mjt.udemy.exception;

public class CourseNotPurchasedException extends Exception{
    public CourseNotPurchasedException()
    {
        super("This course hasn't been purchased");
    }
}
