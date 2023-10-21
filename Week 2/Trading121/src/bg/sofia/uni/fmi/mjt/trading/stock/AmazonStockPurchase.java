package bg.sofia.uni.fmi.mjt.trading.stock;

import java.time.LocalDateTime;

public class AmazonStockPurchase implements StockPurchase{
    private final int quantity;
    private final LocalDateTime purchaseTimestamp;
    double pricePerUnit;
    public AmazonStockPurchase(int quantity, LocalDateTime purchaseTimestamp, double purchasePricePerUnit)
    {
        this.quantity = quantity;
        this.purchaseTimestamp = purchaseTimestamp;
        this.pricePerUnit = purchasePricePerUnit;
    }
    @Override
    public int getQuantity()
    {
        return quantity;
    }
    @Override
    public LocalDateTime getPurchaseTimestamp()
    {
        return purchaseTimestamp;
    }
    @Override
    public double getPurchasePricePerUnit()
    {
        return pricePerUnit;
    }
    @Override
    public double getTotalPurchasePrice()
    {
        return pricePerUnit*quantity;
    }
    @Override
    public String getStockTicker()
    {
        return "AMZ";
    }

}
