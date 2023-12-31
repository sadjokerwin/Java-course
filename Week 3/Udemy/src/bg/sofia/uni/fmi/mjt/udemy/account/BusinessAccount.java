package bg.sofia.uni.fmi.mjt.udemy.account;

import bg.sofia.uni.fmi.mjt.udemy.course.Category;
import bg.sofia.uni.fmi.mjt.udemy.course.Course;

import bg.sofia.uni.fmi.mjt.udemy.exception.InsufficientBalanceException;
import bg.sofia.uni.fmi.mjt.udemy.exception.CourseAlreadyPurchasedException;
import bg.sofia.uni.fmi.mjt.udemy.exception.MaxCourseCapacityReachedException;

public class BusinessAccount extends AccountBase {
    private final Category[] allowedCategories;
    protected final int DISCOUNT_BUSINESS = 20;

    public BusinessAccount(String username, double balance, Category[] allowedCategories) {
        super(username, balance);
        this.allowedCategories = new Category[allowedCategories.length];
        int counter = 0;
        for (Category iter : allowedCategories) {
            this.allowedCategories[counter++] = iter;
        }
    }

    private boolean isFromSupportedTypes(Course course) {
        for (Category type : allowedCategories) {
            if (type.name().equals(course.toString())) {
                return true;
            }
        }
        return false;
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

        if (!isFromSupportedTypes(course)) {
            throw new IllegalArgumentException();
        } else if (balance <= 0 || balance - (course.getPrice() - course.getPrice() * (double)DISCOUNT_BUSINESS) < 0) {
            throw new InsufficientBalanceException();
        } else if (isCoursePurchased(course) != null) {
            throw new CourseAlreadyPurchasedException();
        } else if (currentNumberOfPurchsedCourses == 99) {
            throw new MaxCourseCapacityReachedException();
        }

        purchasedCourses[currentNumberOfPurchsedCourses++] = course;
        reduceBalance(course.getPrice() * (double)DISCOUNT_BUSINESS);

    }
}
