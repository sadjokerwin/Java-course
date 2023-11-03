package bg.sofia.uni.fmi.mjt.udemy.account;

import bg.sofia.uni.fmi.mjt.udemy.course.Category;
import bg.sofia.uni.fmi.mjt.udemy.course.Course;

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


}
