package bg.sofia.uni.fmi.mjt.udemy.account;


import bg.sofia.uni.fmi.mjt.udemy.course.Category;

public class BusinessAccount extends AccountBase{
    private Category[] allowedCategories;
    public BusinessAccount(String username, double balance, Category[] allowedCategories)
    {
        super(username, balance);
        this.allowedCategories = new Category[allowedCategories.length];
        int counter = 0;
        for(Category iter : allowedCategories)
        {
            this.allowedCategories[counter++] = iter;
        }
    }


    /**
     * Buys the given course for the account.
     *
     * @param course the course which will be bought.
     * @throws IllegalArgumentException if the account buyer is of type BusinessAccount and course has category which is not among the permitted for this account
     * @throws InsufficientBalanceException if the account does not have enough funds in its balance.
     * @throws CourseAlreadyPurchasedException if the course is already purchased for this account.
     * @throws MaxCourseCapacityReachedException if the account has reached the maximum allowed course capacity.
     */
    void buyCourse(Course course) throws InsufficientBalanceException, CourseAlreadyPurchasedException, MaxCourseCapacityReachedException;

    /**
     * Completes the given resources that belong to the given course provided that the course was previously purchased by this account.
     *
     * @param resourcesToComplete the resources which will be completed.
     * @param course the course in which the resources will be completed.
     * @throws IllegalArgumentException if course or resourcesToComplete are null.
     * @throws CourseNotPurchasedException if course is not currently purchased for this account.
     * @throws ResourceNotFoundException if a certain resource could not be found in the course.
     */
    void completeResourcesFromCourse(Course course, Resource[] resourcesToComplete) throws CourseNotPurchasedException, ResourceNotFoundException;

    /**
     * Completes the whole course.
     *
     * @param course the course which will be completed.
     * @param grade the grade with which the course will be completed.
     * @throws IllegalArgumentException if grade is not in range [2.00, 6.00] or course is null.
     * @throws CourseNotPurchasedException if course is not currently purchased for this account.
     * @throws CourseNotCompletedException if there is a resource in the course which is not completed.
     */
    void completeCourse(Course course, double grade) throws CourseNotPurchasedException, CourseNotCompletedException;

    /**
     * Gets the course with the least completion percentage.
     * Returns null if the account does not have any purchased courses.
     */
    Course getLeastCompletedCourse();
}
