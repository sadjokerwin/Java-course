package bg.sofia.uni.fmi.mjt.udemy.exception;

import bg.sofia.uni.fmi.mjt.udemy.course.Resource;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException()
    {
        super("This resource wasn't found");
    }
}
