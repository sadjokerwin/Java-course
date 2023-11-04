package bg.sofia.uni.fmi.mjt.udemy.account;

public class StandardAccount extends AccountBase {
    private int streakOfCompletedCourses;
    private final int NEEDED_STREAK_FOR_DISCOUNT = 5;
    private final double NEEDED_GRADE_FOR_DISCOUNT = 4.50;

    public StandardAccount(String username, double balance) {
        super(username, balance);
        streakOfCompletedCourses = 0;
    }


}
