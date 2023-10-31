package bg.sofia.uni.fmi.mjt.udemy.course;

public class Resource implements Completable{/**
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
     * Marks the resource as completed.
     */
    public void complete() {
        // TODO: add implementation here
    }
}
