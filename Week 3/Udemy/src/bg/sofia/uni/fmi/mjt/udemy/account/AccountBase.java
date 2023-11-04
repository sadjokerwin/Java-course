package bg.sofia.uni.fmi.mjt.udemy.account;

import bg.sofia.uni.fmi.mjt.udemy.course.Course;
import bg.sofia.uni.fmi.mjt.udemy.course.Resource;
import bg.sofia.uni.fmi.mjt.udemy.exception.*;


public abstract class AccountBase implements Account {
    protected final String username;
    protected double balance;
    protected int currentNumberOfPurchsedCourses;
    protected Course[] purchasedCourses;
    //    protected int numberOfCompletedCourses;
    protected int discount;

    public AccountBase(String username, double balance) {
        this.username = username;
        this.balance = balance;
        this.currentNumberOfPurchsedCourses = 0;
//        this.currentNumberCompletedCourses = 0;
        this.purchasedCourses = new Course[100];
//        this.grades = new double[100];
        this.discount = 0;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    protected void reduceBalance(double reduction) {
        this.balance -= reduction;
    }

    public int getCurrentNumberOfCourses() {
        return currentNumberOfPurchsedCourses;
    }

    /**
     * Adds the given amount of money to the account's balance.
     *
     * @param amount the amount of money which will be added to the account's balance.
     * @throws IllegalArgumentException if amount has a negative value.
     */
    @Override
    public void addToBalance(double amount) {
        if (amount < 0) throw new IllegalArgumentException("The given amount has a negative value");
        else balance += amount;
    }

    /**
     * Completes the given resources that belong to the given course provided that the course was previously purchased by this account.
     *
     * @param resourcesToComplete the resources which will be completed.
     * @param course              the course in which the resources will be completed.
     * @throws IllegalArgumentException    if course or resourcesToComplete are null.
     * @throws CourseNotPurchasedException if course is not currently purchased for this account.
     * @throws ResourceNotFoundException   if a certain resource could not be found in the course.
     */
    @Override
    public void completeResourcesFromCourse(Course course, Resource[] resourcesToComplete) throws CourseNotPurchasedException, ResourceNotFoundException {
        if (course == null || resourcesToComplete == null) {
            throw new IllegalArgumentException("The course or resources are null");
        }

        Course foundCourse = isCoursePurchased(course);

        if (foundCourse == null) {
            throw new CourseNotPurchasedException();
        } else {
            for (Resource iter : resourcesToComplete) {
                if (!iterThroughCourses(iter, foundCourse.getContent())) throw new ResourceNotFoundException();
            }
        }

    }

    protected Course isCoursePurchased(Course course) {
        if (currentNumberOfPurchsedCourses == 0) {
            return null;
        }
        for (Course iter : purchasedCourses) {
            if (iter.equals(course)) {
                return iter;
            }
        }
        return null;

    }

    protected boolean iterThroughCourses(Resource toComplete, Resource[] resources) {
        for (Resource iter : resources) {
            if (iter.equals(toComplete)) iter.complete();
            return true;
        }
        return false;
    }

    /**
     * Gets the course with the least completion percentage.
     * Returns null if the account does not have any purchased courses.
     */
    @Override
    public Course getLeastCompletedCourse() {
        int minPercentage = 100;
        Course currMinCourse = null;
        for (Course iter : purchasedCourses) {
            if (minPercentage > iter.getCompletionPercentage()) {
                currMinCourse = iter;
                minPercentage = iter.getCompletionPercentage();
            }
        }
        return currMinCourse;
    }

    /**
     * Buys the given course for the account.
     *
     * @param course the course which will be bought.
     * @throws IllegalArgumentException          if the account buyer is of type BusinessAccount and course has category which is not among the permitted for this account
     * @throws InsufficientBalanceException      if the account does not have enough funds in its balance.
     * @throws CourseAlreadyPurchasedException   if the course is already purchased for this account.
     * @throws MaxCourseCapacityReachedException if the account has reached the maximum allowed course capacity.
     */
    @Override
    public void buyCourse(Course course) throws InsufficientBalanceException, CourseAlreadyPurchasedException, MaxCourseCapacityReachedException {

        if (balance <= 0 || balance - (course.getPrice() - course.getPrice() * (double) discount) < 0) {
            throw new InsufficientBalanceException();
        } else if (isCoursePurchased(course) != null) {
            throw new CourseAlreadyPurchasedException();
        } else if (currentNumberOfPurchsedCourses == 99) {
            throw new MaxCourseCapacityReachedException();
        }

        purchasedCourses[currentNumberOfPurchsedCourses++] = course;
        reduceBalance(course.getPrice());

    }

    /**
     * Completes the whole course.
     *
     * @param course the course which will be completed.
     * @param grade  the grade with which the course will be completed.
     * @throws IllegalArgumentException    if grade is not in range [2.00, 6.00] or course is null.
     * @throws CourseNotPurchasedException if course is not currently purchased for this account.
     * @throws CourseNotCompletedException if there is a resource in the course which is not completed.
     */
    @Override
    public void completeCourse(Course course, double grade) throws CourseNotPurchasedException, CourseNotCompletedException {
        if (grade < 2d || grade > 6d) {
            throw new IllegalArgumentException();
        }
        Course foundCourse = isCoursePurchased(course);
        if (foundCourse == null) {
            throw new CourseNotPurchasedException();
        }
        for (Resource iter : foundCourse.getContent()) {
            if (!iter.isCompleted()) {
                throw new CourseNotCompletedException();
            }
        }
    }
}
