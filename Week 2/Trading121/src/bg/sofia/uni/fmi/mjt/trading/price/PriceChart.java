package bg.sofia.uni.fmi.mjt.trading.price;

public class PriceChart implements PriceChartAPI {
    private double microsoftStockPrice;
    private double googleStockPrice;
    private double amazonStockPrice;

    PriceChart(double microsoftStockPrice, double googleStockPrice, double amazonStockPrice) {
        this.microsoftStockPrice = microsoftStockPrice;
        this.googleStockPrice = googleStockPrice;
        this.amazonStockPrice = amazonStockPrice;
    }

    /**
     * Gets the current price of the stock identified by the provided stock ticker rounded to two decimal places
     *
     * @param stockTicker the stock ticker
     * @return current price of stock. If the stock with the provided ticker is not traded on the platform
     * or the ticker is null, return 0.0
     */
    @Override
    public double getCurrentPrice(String stockTicker) {
        double returnValue;
        switch (stockTicker) {
            case "MSFT" -> returnValue = microsoftStockPrice;
            case "AMZ" -> returnValue = amazonStockPrice;
            case "GOOG" -> returnValue = googleStockPrice;
            default -> returnValue = 0d;
        }
        return returnValue;
    }

    @Override
    public boolean isFromSupportedStocks(String[] stocks, String stockTicker) {
        if (stockTicker == null) return false;
        for (String iter : stocks)
            if (stockTicker.equals(iter)) return true;

        return false;
    }

    /**
     * Changes the current price of the stock identified by the provided stock ticker by the provided percentage.
     * As we are creating a thriving trading platform, the percentage can only be a positive number
     *
     * @param stockTicker   the ticker of the stock for which the price is changing
     * @param percentChange positive number denoting the percentage increase of stock price
     * @return true, if the price was increased successfully. If the stock with the provided ticker is not traded
     * on the platform or the ticker is null, return false. If the provided percentChange is not a positive
     * number, return false.
     */
    @Override
    public boolean changeStockPrice(String stockTicker, int percentChange) {
        if (!isFromSupportedStocks(new String[]{"MSFT", "AMZ", "GOOG"}, stockTicker) || percentChange <= 0)
            return false;
        else {
            switch (stockTicker) {
                case "MSFT" -> microsoftStockPrice += (double)percentChange / 100;
                case "AMZ" -> amazonStockPrice += (double)percentChange / 100;
                case "GOOG" -> googleStockPrice += (double)(percentChange / 100);

            }
            return true;
        }
    }
}
