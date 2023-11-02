package bg.sofia.uni.fmi.mjt.udemy.account;

public abstract class AccountBase implements Account {
    protected final String username;
    protected double balance;
    protected int currentNumberOfCourses;

    public AccountBase(String username, double balance) {
        this.username = username;
        this.balance = balance;
        this.currentNumberOfCourses = 0;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public double getBalance() {
        return balance;
    }
    public int getCurrentNumberOfCourses()
    {
        return currentNumberOfCourses;
    }
    /**
     * Adds the given amount of money to the account's balance.
     *
     * @param amount the amount of money which will be added to the account's balance.
     * @throws IllegalArgumentException if amount has a negative value.
     */
    @Override
    public void addToBalance(double amount)
    {
        if(amount<0) throw new IllegalArgumentException("The given amount has a negative value");
        else balance+=amount;
    }
    /**
     * Completes the given resources that belong to the given course provided that the course was previously purchased by this account.
     *
     * @param resourcesToComplete the resources which will be completed.
     * @param course the course in which the resources will be completed.
     * @throws IllegalArgumentException if course or resourcesToComplete are null.
     * @throws CourseNotPurchasedException if course is not currently purchased for this account.
     * @throws ResourceNotFoundException if a certain resource could not be found in the course.
     */
    @Override
    public void completeResourcesFromCourse(Course course, Resource[] resourcesToComplete) throws CourseNotPurchasedException, ResourceNotFoundException
    {
        if(course == null || resourcesToComplete == null) throw new IllegalArgumentException("The course or resources are null");
        
    }


}
