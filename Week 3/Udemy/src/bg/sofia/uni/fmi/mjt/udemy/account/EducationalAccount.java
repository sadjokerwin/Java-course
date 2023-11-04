package bg.sofia.uni.fmi.mjt.udemy.account;

import bg.sofia.uni.fmi.mjt.udemy.course.Course;
import bg.sofia.uni.fmi.mjt.udemy.course.Resource;
import bg.sofia.uni.fmi.mjt.udemy.exception.CourseAlreadyPurchasedException;
import bg.sofia.uni.fmi.mjt.udemy.exception.CourseNotCompletedException;
import bg.sofia.uni.fmi.mjt.udemy.exception.CourseNotPurchasedException;
import bg.sofia.uni.fmi.mjt.udemy.exception.InsufficientBalanceException;
import bg.sofia.uni.fmi.mjt.udemy.exception.MaxCourseCapacityReachedException;

public class EducationalAccount extends AccountBase {
//    private double[] grades;
    private int streakOfCompletedCourses;
    private final int NEEDED_STREAK_FOR_DISCOUNT = 5;
    private final double NEEDED_GRADE_FOR_DISCOUNT = 4.50;

    public EducationalAccount(String username, double balance) {
        super(username, balance);
        streakOfCompletedCourses = 0;
    }

    private void calculateDiscount() {
        if (streakOfCompletedCourses == NEEDED_STREAK_FOR_DISCOUNT) {
            streakOfCompletedCourses = 0;
            discount = 15;
        }
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
        } else if (currentNumberOfPurchsedCourses == 100) {
            throw new MaxCourseCapacityReachedException();
        }

        purchasedCourses[currentNumberOfPurchsedCourses++] = course;
        calculateDiscount();
        reduceBalance(course.getPrice() * (double) discount);

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

        if (grade >= NEEDED_GRADE_FOR_DISCOUNT) {
            streakOfCompletedCourses++;
//        grade[numberOfCompletedCourses++] =
        } else {
            streakOfCompletedCourses = 0;
        }
    }
}
