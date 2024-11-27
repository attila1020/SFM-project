package hu.unideb.gasstation.models;

public class LowStockAlert {
    private String product;
    private int stock;

    public LowStockAlert(String product, int stock) {
        this.product = product;
        this.stock = stock;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
