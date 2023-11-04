package bg.sofia.uni.fmi.mjt.udemy;

import bg.sofia.uni.fmi.mjt.udemy.account.Account;
import bg.sofia.uni.fmi.mjt.udemy.course.Category;
import bg.sofia.uni.fmi.mjt.udemy.course.Course;
import bg.sofia.uni.fmi.mjt.udemy.exception.AccountNotFoundException;
import bg.sofia.uni.fmi.mjt.udemy.exception.CourseNotFoundException;

public class Udemy implements LearningPlatform {
    private Account[] accounts;
    private int accountsCounter;
    private Course[] courses;
    private int coursesCounter;

    public Udemy(Account[] accounts, Course[] courses) {
        this.accounts = new Account[accounts.length];
        accountsCounter = 0;
        for (Account account : accounts) {
            this.accounts[accountsCounter++] = account;
        }

        this.courses = new Course[courses.length];
        coursesCounter = 0;
        for (Course course : courses) {
            this.courses[coursesCounter++] = course;
        }
    }

    /**
     * Returns the course with the given name.
     *
     * @param name the exact name of the course.
     * @throws IllegalArgumentException if name is null or blank.
     * @throws CourseNotFoundException  if course with the specified name is not present in the platform.
     */
    @Override
    public Course findByName(String name) throws CourseNotFoundException {
        if (name == null) {
            throw new IllegalArgumentException("Name is null or blank");
        }

        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        throw new CourseNotFoundException();
    }

    /**
     * Returns all courses which name or description containing keyword.
     * A keyword is a word that consists of only small and capital latin letters.
     *
     * @param keyword the exact keyword for which we will search.
     * @throws IllegalArgumentException if keyword is null, blank or not a keyword.
     */
    @Override
    public Course[] findByKeyword(String keyword) {
        if (keyword == null) {
            throw new IllegalArgumentException("Keyword is null or blank");
        }

        Course[] coursesWithKeyword = new Course[courses.length];
        int numOfCoursesContainingKeyword = 0;

        for (Course course : courses) {
            if (course.getName().contains(keyword)) {
                coursesWithKeyword[numOfCoursesContainingKeyword++] = course;
            }
        }
        return coursesWithKeyword;
    }

    /**
     * Returns all courses from a given category.
     *
     * @param category the exact category the courses for which we want to get.
     * @throws IllegalArgumentException if category is null.
     */
    @Override
    public Course[] getAllCoursesByCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category is null");
        } else if (coursesCounter == 0) {
            return null;
        }

        Course[] coursesFromCategory = new Course[courses.length];
        int numOfCoursesFromCategory = 0;

        for (int counter = 0; counter < coursesCounter; counter++) {
            if (courses[counter].getCategory().equals(category)) {
                coursesFromCategory[numOfCoursesFromCategory] = courses[counter];
                numOfCoursesFromCategory++;
            }
        }

        return coursesFromCategory;
    }

    /**
     * Returns the account with the given name.
     *
     * @param name the exact name of the account.
     * @throws IllegalArgumentException if name is null or blank.
     * @throws AccountNotFoundException if account with such a name does not exist in the platform.
     */
    @Override
    public Account getAccount(String name) throws AccountNotFoundException {
        if (name == null) {
            throw new IllegalArgumentException("Name is null or blank");
        } else if (accountsCounter == 0) {
            return null;
        }

        for (Account account : accounts) {
            if (account.getUsername().equals(name)) {
                return account;
            }
        }

        throw new AccountNotFoundException();
    }

    /**
     * Returns the course with the longest duration in the platform.
     * Returns null if the platform has no courses.
     */
    @Override
    public Course getLongestCourse() {
        if (courses == null) {
            return null;
        }

        Course longest = courses[0];
        int longestTime = -1;

        for (Course course : courses) {
            if (longest.getTotalTime().compare(course.getTotalTime()) == -1) {
                longest = course;
            }
        }

        return longest;
    }

    /**
     * Returns the cheapest course from the given category.
     * Returns null if the platform has no courses.
     *
     * @param category the exact category for which we want to find the cheapest course.
     * @throws IllegalArgumentException if category is null.
     */
    @Override
    public Course getCheapestByCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category is null");
        }

        Course[] categoryCourses = new Course[courses.length];
        categoryCourses = getAllCoursesByCategory(category);
        Course cheapest = categoryCourses[0];

        for (Course course : courses) {
            if (cheapest.getPrice() > course.getPrice()) {
                cheapest = course;
            }
        }

        return cheapest;
    }
}
