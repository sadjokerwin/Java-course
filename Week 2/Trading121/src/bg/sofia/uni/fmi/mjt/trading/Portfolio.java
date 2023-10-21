package bg.sofia.uni.fmi.mjt.trading;

import bg.sofia.uni.fmi.mjt.trading.price.PriceChartAPI;
import bg.sofia.uni.fmi.mjt.trading.stock.StockPurchase;

public class Portfolio implements PortfolioAPI{
    private String owner;
    private double budget;
    private int maxSize;
    private PriceChartAPI priceChart;
    private StockPurchase[] stockPurchases;
    public Portfolio(String owner, PriceChartAPI priceChart, double budget, int maxSize)
    {
        this.owner = owner;
        this.priceChart = priceChart;
        this.budget = budget;
        this.maxSize = maxSize;
    }
    public Portfolio(String owner, PriceChartAPI priceChart, StockPurchase[] stockPurchases, double budget, int maxSize)
    {
        this.owner = owner;
        this.priceChart = priceChart;
        this.budget = budget;
        this.maxSize = maxSize;
        int counter = 0;
        for(StockPurchase iter : stockPurchases)
        {

            this.stockPurchases[counter++] = iter;
        }
    }
}
