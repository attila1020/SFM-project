package hu.unideb.gasstation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TopSelling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String product;
    private int sales;

    public TopSelling(String product, int sales) {
        this.product = product;
        this.sales = sales;
    }

    public TopSelling() {

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
