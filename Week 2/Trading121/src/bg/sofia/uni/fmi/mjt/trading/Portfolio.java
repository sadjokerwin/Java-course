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
    private final StockPurchase[] stockPurchases;
    private double budget;
    private int numberOfStocks;
    private int numberOfStockPurchases;

    public Portfolio(String owner, PriceChartAPI priceChart, double budget, int maxSize) {
        this.owner = owner;
        this.priceChart = priceChart;
        this.budget = budget;
        this.maxSize = maxSize;
        this.numberOfStockPurchases = 0;
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
            if (iter != null)
                this.stockPurchases[counter++] = buyStock(iter.getStockTicker(), iter.getQuantity());
            else break;
        }
        numberOfStockPurchases = counter;
    }

    @Override
    public StockPurchase attemptPurchase(String stockTicker, int quantity) {
        if (stockTicker == null ) return null;
        double purchaseTotal = Math.round(quantity* priceChart.getCurrentPrice(stockTicker) * 100.0) / 100.0;
        StockPurchase toBeAdded;
        double price = priceChart.getCurrentPrice(stockTicker);

        if (quantity <= 0 || numberOfStocks + quantity > maxSize || budget - purchaseTotal < 0)
            return null;
        else {
            if (purchaseTotal != 0d) {
                budget -= purchaseTotal;
                numberOfStocks += quantity;
            }
            switch (stockTicker) {
                case "AMZ":
                    if (priceChart.changeStockPrice(stockTicker, 5))
                        toBeAdded = new AmazonStockPurchase(quantity, LocalDateTime.now(), price);
                    else toBeAdded = null;
                    break;
                case "GOOG":
                    if (priceChart.changeStockPrice(stockTicker, 5))
                        toBeAdded = new GoogleStockPurchase(quantity, LocalDateTime.now(), price);
                    else toBeAdded = null;
                    break;
                case "MSFT":
                    if (priceChart.changeStockPrice(stockTicker, 5))
                        toBeAdded = new MicrosoftStockPurchase(quantity, LocalDateTime.now(), price);
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
        if (numberOfStockPurchases == 0 || stockPurchases[0] == null) return new StockPurchase[0];
        else if (stockPurchases[0].getPurchaseTimestamp().isAfter(endTimestamp) || stockPurchases[numberOfStockPurchases - 1].getPurchaseTimestamp().isBefore(startTimestamp))
            return new StockPurchase[0];
        else {

            int counter = 0;
            int firstOccur = 0;
            for (int i = 0; i < numberOfStockPurchases; i++) {

                if (stockPurchases[i]!=null && stockPurchases[i].getPurchaseTimestamp().isBefore(startTimestamp) && stockPurchases[i].getPurchaseTimestamp().equals(startTimestamp)) {
                    counter++;
                } else {firstOccur = i;
                    break;
                }
            }
            for (int i = numberOfStockPurchases; i > 0; i--) {

                if (stockPurchases[i]!=null && stockPurchases[i].getPurchaseTimestamp().isAfter(endTimestamp)&& stockPurchases[i].getPurchaseTimestamp().equals(endTimestamp)) {
                    counter++;
                } else break;
            }
            int sizeOfNewArray = numberOfStockPurchases - counter;
            StockPurchase[] helperPurchases = new StockPurchase[sizeOfNewArray];
            for (int i = 0; i < sizeOfNewArray; i++) {
                helperPurchases[i] = stockPurchases[firstOccur++];

            }
            return helperPurchases;

        }
    }

    /**
     * @return the current total net worth of the portfolio: the sum of each purchases' quantity multiplied by
     * the current price of the stock identified by that purchase rounded to two decimal places
     */
    @Override
    public double getNetWorth() {
        double netWorth = 0;
        if (numberOfStockPurchases == 0) return 0d;
        for (int i = 0; i < numberOfStockPurchases; i++) {
            netWorth += Math.round(priceChart.getCurrentPrice(stockPurchases[i].getStockTicker()) * stockPurchases[i].getQuantity() * 100.0) / 100.0;
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
