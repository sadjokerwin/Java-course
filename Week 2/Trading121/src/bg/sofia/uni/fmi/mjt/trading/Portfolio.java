package bg.sofia.uni.fmi.mjt.trading;

import bg.sofia.uni.fmi.mjt.trading.price.PriceChartAPI;
import bg.sofia.uni.fmi.mjt.trading.stock.AmazonStockPurchase;
import bg.sofia.uni.fmi.mjt.trading.stock.GoogleStockPurchase;
import bg.sofia.uni.fmi.mjt.trading.stock.MicrosoftStockPurchase;
import bg.sofia.uni.fmi.mjt.trading.stock.StockPurchase;

import java.time.LocalDateTime;

public class Portfolio implements PortfolioAPI {
    private final String owner;
    private final int maxSize;
    private final PriceChartAPI priceChart;
    private double budget;
    private final StockPurchase[] stockPurchases;
    private int numberOfStocks;
    private int numberOfStockPurchases;

    public Portfolio(String owner, PriceChartAPI priceChart, double budget, int maxSize) {
        this.owner = owner;
        this.priceChart = priceChart;
        this.budget = budget;
        this.maxSize = maxSize;
        this.stockPurchases = new StockPurchase[maxSize];
    }

    public Portfolio(String owner, PriceChartAPI priceChart, StockPurchase[] stockPurchases, double budget, int maxSize) {
        this.owner = owner;
        this.priceChart = priceChart;
        this.budget = budget;
        this.maxSize = maxSize;
        int counter = 0;
        this.stockPurchases = new StockPurchase[maxSize];
        for (StockPurchase iter : stockPurchases) {

            this.stockPurchases[counter++] = iter;
        }
    }

    @Override
    public StockPurchase attemptPurchase(String stockTicker, int quantity) {
        double purchaseTotal = Math.round(quantity * priceChart.getCurrentPrice(stockTicker) * 100.0) / 100.0;
        StockPurchase toBeAdded;
        if (purchaseTotal < 0 || quantity <= 0 || maxSize == 0 || numberOfStocks + quantity > maxSize) return null;
        else {
            budget -= purchaseTotal;
            numberOfStocks += quantity;
//            return
            switch (stockTicker) {
                case "AMZ":
                    if (priceChart.changeStockPrice(stockTicker, 5))
                        toBeAdded = new AmazonStockPurchase(quantity, LocalDateTime.now(), priceChart.getCurrentPrice(stockTicker));
                    else toBeAdded = null;
                    break;
                case "GOOG":
                    if (priceChart.changeStockPrice(stockTicker, 5))
                        toBeAdded = new GoogleStockPurchase(quantity, LocalDateTime.now(), priceChart.getCurrentPrice(stockTicker));
                    else toBeAdded = null;
                    break;
                case "MSFT":
                    if (priceChart.changeStockPrice(stockTicker, 5))
                        toBeAdded = new MicrosoftStockPurchase(quantity, LocalDateTime.now(), priceChart.getCurrentPrice(stockTicker));
                    else toBeAdded = null;
                    break;
                default:
                    return null;
            }
            if (toBeAdded != null) {
                stockPurchases[numberOfStockPurchases++] = toBeAdded;
                return toBeAdded;
            } else return null;
        }
    }

    /**
     * Purchases the provided quantity of stocks with the provided ticker. The budget in the portfolio should
     * decrease by the corresponding amount. If a stock is on-demand then naturally its price increases.
     * Every stock purchase should result in a 5% price increase of the purchased stock
     *
     * @param stockTicker the stock ticker
     * @param quantity    the quantity of stock that should be purchased
     * @return the stock purchase if it was successfully purchased. If the stock with the provided ticker is
     * not traded on the platform or the ticker is null, return null. If the budget is not enough to make the
     * purchase, return null. If quantity is not a positive number, return null. If the portfolio is already
     * at max size, return null.
     */
    @Override
    public StockPurchase buyStock(String stockTicker, int quantity) {

        return attemptPurchase(stockTicker, quantity);
    }

    /**
     * @return all stock purchases made so far.
     */
    @Override
    public StockPurchase[] getAllPurchases() {
        return stockPurchases;
    }

    /**
     * @return numberOfStocks
     */
    @Override
    public int getNumberOfStocks() {
        return numberOfStocks;
    }

    /**
     * @return numberOfStocksPurchases
     */
    @Override
    public int getNumberOfStocksPurchases() {
        return numberOfStockPurchases;
    }

    /**
     * Retrieves purchases made in the provided inclusive time interval
     *
     * @param startTimestamp the start timestamp of the interval
     * @param endTimestamp   the end timestamp of the interval
     * @return all stock purchases made so far in the provided time interval
     */
    @Override
    public StockPurchase[] getAllPurchases(LocalDateTime startTimestamp, LocalDateTime endTimestamp) {
        int counter = 0;
        for (int i = 0; i < numberOfStockPurchases; i++) {

            if (stockPurchases[i].getPurchaseTimestamp().isBefore(startTimestamp)) {
                counter++;
                continue;
            } else break;
        }
        StockPurchase[] helperPurchases = new StockPurchase[numberOfStockPurchases - counter];
        StockPurchase iterStock = stockPurchases[counter];
        int helperCounter = 0;
        while (!iterStock.getPurchaseTimestamp().isAfter(endTimestamp)) {
            helperPurchases[helperCounter++] = stockPurchases[counter++];
            iterStock = stockPurchases[counter];
        }
        if (helperCounter == 0 && counter == 0)
            return null;
        else
            return helperPurchases;

    }

    /**
     * @return the current total net worth of the portfolio: the sum of each purchases' quantity multiplied by
     * the current price of the stock identified by that purchase rounded to two decimal places
     */
    @Override
    public double getNetWorth() {
        double netWorth = 0;
        for (StockPurchase iter : stockPurchases) {
            netWorth += Math.round(priceChart.getCurrentPrice(iter.getStockTicker()) * iter.getQuantity() * 100.0) / 100.0;
        }
        return netWorth;
    }

    /**
     * @return the remaining budget in the portfolio rounded to two decimal places
     */
    @Override
    public double getRemainingBudget() {
        return Math.round(budget * 100.0) / 100.0;
    }

    /**
     * @return the owner of the portfolio
     */
    @Override
    public String getOwner() {
        return owner;
    }
}
