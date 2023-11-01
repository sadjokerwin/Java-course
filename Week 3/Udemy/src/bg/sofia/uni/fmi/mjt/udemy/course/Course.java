package bg.sofia.uni.fmi.mjt.udemy.course;

import bg.sofia.uni.fmi.mjt.udemy.course.duration.CourseDuration;
import bg.sofia.uni.fmi.mjt.udemy.course.duration.ResourceDuration;
import bg.sofia.uni.fmi.mjt.udemy.exception.ResourceNotFoundException;

public class Course implements Completable, Purchasable {
    private final String name;
    private final String description;
    private final double price;
    private final Category category;
    private Resource[] content;
    private final CourseDuration totalTime;
    private boolean isPurchased;

    public Course(String name, String description, double price, Resource[] content, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.content = new Resource[content.length];
        int counter = 0;
        int minutes = 0;
        ResourceDuration[] duration = new ResourceDuration[content.length];
        for (Resource iter : content) {
            this.content[counter++] = new Resource(iter.getName(), iter.getDuration());
            duration[counter] = new ResourceDuration(iter.getDuration().minutes());
        }
        counter = 0;
        this.totalTime = CourseDuration.of(duration);
        this.isPurchased = false; 
        this.category = category;

    }

    /**
     * Returns the name of the course.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the course.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the price of the course.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the category of the course.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Returns the content of the course.
     */
    public Resource[] getContent() {
        return content;
    }

    /**
     * Returns the total duration of the course.
     */
    public CourseDuration getTotalTime() {
        return totalTime;
    }

    /**
     * Returns true if and only if the course is completed.
     */
    @Override
    public boolean isCompleted() {
        for (Resource iter : content)
            if (!iter.isCompleted()) return false;
        return true;
    }
    /**
     * Marks the object as purchased.
     */
    void purchase();

    /**
     * Returns true if and only if the object is purchased.
     */
    boolean isPurchased();
    /**
     * Completes a resource from the course.
     *
     * @param resourceToComplete the resource which will be completed.
     * @throws IllegalArgumentException  if resourceToComplete is null.
     * @throws ResourceNotFoundException if the resource could not be found in the course.
     */
    public void completeResource(Resource resourceToComplete) throws ResourceNotFoundException {
        if (resourceToComplete == null) throw new IllegalArgumentException("resourceToComplete is null");
        else {
            for (Resource iter : content) {
                if (iter.getName().equals(resourceToComplete.getName())) resourceToComplete.complete();
                break;
            }
            throw new ResourceNotFoundException();
        }
    }
}
