package bg.sofia.uni.fmi.mjt.udemy.exception;

public class CourseNotFoundException extends Exception{
    public CourseNotFoundException()
    {
        super("The course couldn't be found");
    }
}
