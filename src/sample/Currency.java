package sample;

public class Currency {
    public Currency(Double saleRateNB, Double purchaseRateNB, String currency) {
        this.saleRateNB = saleRateNB;
        this.purchaseRateNB = purchaseRateNB;
        this.currency = currency;
    }

    public Currency() {
    }

    public Double getSaleRateNB() {
        return saleRateNB;
    }

    public void setSaleRateNB(Double saleRateNB) {
        this.saleRateNB = saleRateNB;
    }

    public Double getPurchaseRateNB() {
        return purchaseRateNB;
    }

    public void setPurchaseRateNB(Double purchaseRateNB) {
        this.purchaseRateNB = purchaseRateNB;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private Double saleRateNB;
    private Double purchaseRateNB;
    private String currency;


}
