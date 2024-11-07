package hu.unideb.gasstation.models;

public class TopSelling {
    private String product;
    private int sales;

    public TopSelling(String product, int sales) {
        this.product = product;
        this.sales = sales;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
