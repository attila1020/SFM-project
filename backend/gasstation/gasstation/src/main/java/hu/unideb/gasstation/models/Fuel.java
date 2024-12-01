package hu.unideb.gasstation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fuelType;
    private int sales;


    public Fuel(String fuelType, int sales) {
        this.fuelType = fuelType;
        this.sales = sales;
    }

    public Fuel() {

    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
