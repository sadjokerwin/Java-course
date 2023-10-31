package bg.sofia.uni.fmi.mjt.trading.stock;

import java.time.LocalDateTime;

public class GoogleStockPurchase implements StockPurchase {
    private final int quantity;
    private final LocalDateTime purchaseTimestamp;
    double pricePerUnit;

    public GoogleStockPurchase(int quantity, LocalDateTime purchaseTimestamp, double purchasePricePerUnit) {
        this.quantity = quantity;
        this.purchaseTimestamp = purchaseTimestamp;
        this.pricePerUnit = Math.round(purchasePricePerUnit * 100.0) / 100.0;

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
    public String getStockTicker() {
        return "GOOG";
    }

}
