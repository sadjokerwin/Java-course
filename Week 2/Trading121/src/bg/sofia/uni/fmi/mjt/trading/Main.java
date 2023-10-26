package bg.sofia.uni.fmi.mjt.trading;

import bg.sofia.uni.fmi.mjt.trading.price.PriceChart;
import bg.sofia.uni.fmi.mjt.trading.price.PriceChartAPI;
import bg.sofia.uni.fmi.mjt.trading.stock.StockPurchase;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        PriceChartAPI priceChart = new PriceChart(100.0, 200.0, 300.0);
        Portfolio portfolioUser1 = new Portfolio("Ivan", priceChart, 250000, 20);
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        portfolioUser1.buyStock("AMZ", 1);
        int test = 0;
        test = myObj.nextInt();
        portfolioUser1.buyStock("AMZ", 1);
        test = myObj.nextInt();

        portfolioUser1.buyStock("AMZ", 1);
        test = myObj.nextInt();

        portfolioUser1.buyStock("AMZ", 1);
        System.out.println(portfolioUser1.getRemainingBudget());
//        System.out.println(portfolioUser1.getNetWorth());
        StockPurchase[] purchases = portfolioUser1.getAllPurchases();
//        System.out.println(purchases);
        for(int i =0; i< portfolioUser1.getNumberOfStocks(); i++)
        {
            System.out.println(purchases[i].getPurchasePricePerUnit());
            System.out.println(purchases[i].getPurchaseTimestamp());
        }
        StockPurchase[] specificPurchases = portfolioUser1.getAllPurchases(LocalDateTime.of(2023, 10, 26, 20, 40),LocalDateTime.of(2023, 10, 26, 20, 42));
//        System.out.println();
        if(specificPurchases != null)
        for(int i =0; i< specificPurchases.length; i++)
        {
            System.out.println(specificPurchases[i].getPurchasePricePerUnit());
//            System.out.println(purchases[i].getPurchaseTimestamp());
        }
        else System.out.println("qko mlqko");

    }
}
