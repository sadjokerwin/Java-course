package bg.sofia.uni.fmi.mjt.udemy.course;

import bg.sofia.uni.fmi.mjt.udemy.course.duration.ResourceDuration;

public class Resource implements Completable {
    private String name;
    private ResourceDuration duration;
    private int completionPercentage;
    public Resource(String name, ResourceDuration duration)
    {
        this.name = name;
        this.duration = duration;
    }
    /**
     * Returns the resource name.
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the total duration of the resource.
     */
    public ResourceDuration getDuration() {
        return duration;
    }

    /**
     * Returns the completion percentage of the resource.
     * The percentage is an integer in the range [0, 100].
     */
    @Override
    public int getCompletionPercentage()
    {
        return completionPercentage;
    }
    /**
     * Marks the resource as completed.
     */
    public void complete() {
        completionPercentage = 100;
    }
}
