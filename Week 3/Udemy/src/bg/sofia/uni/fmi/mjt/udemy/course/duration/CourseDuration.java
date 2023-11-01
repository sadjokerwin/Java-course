package bg.sofia.uni.fmi.mjt.udemy.course.duration;

public record CourseDuration(int hours, int minutes) {
    public CourseDuration {
        if(hours<0 || hours > 24 || minutes <0 || minutes >60)
        {
            throw new IllegalArgumentException("Hours should be in the interval [0,24] and minutes in [0,60]");
        }
    }
    public static CourseDuration of(ResourceDuration[] content)
    {
        int minutes =0;
        for(ResourceDuration iter : content)
        {
            minutes += iter.minutes();
        }
        int hours = minutes/60;
        minutes %= 60;
        return new CourseDuration(hours, minutes);
    }
}
