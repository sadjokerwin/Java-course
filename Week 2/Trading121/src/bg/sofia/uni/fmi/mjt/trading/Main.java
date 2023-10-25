package bg.sofia.uni.fmi.mjt.trading;

import bg.sofia.uni.fmi.mjt.trading.price.PriceChart;
import bg.sofia.uni.fmi.mjt.trading.price.PriceChartAPI;


public class Main {
    public static void main(String[] args) {
        PriceChartAPI priceChart = new PriceChart(100.0, 200.0, 300.0);
        Portfolio portfolioUser1 = new Portfolio("Ivan", priceChart, 2000, 20);
        portfolioUser1.buyStock("AMZ", 20);
        System.out.println();
    }
}
