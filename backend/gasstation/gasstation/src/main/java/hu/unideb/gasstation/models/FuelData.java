package hu.unideb.gasstation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FuelData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int gasolineAmount;
    private double gasolinePrice;
    private int dieselAmount;
    private double dieselPrice;


    public FuelData(int gasolineAmount, double gasolinePrice, int dieselAmount, double dieselPrice) {
        this.gasolineAmount = gasolineAmount;
        this.gasolinePrice = gasolinePrice;
        this.dieselAmount = dieselAmount;
        this.dieselPrice = dieselPrice;
    }

    public FuelData() {

    }

    public int getGasolineAmount() {
        return gasolineAmount;
    }

    public void setGasolineAmount(int gasolineAmount) {
        this.gasolineAmount = gasolineAmount;
    }

    public double getGasolinePrice() {
        return gasolinePrice;
    }

    public void setGasolinePrice(double gasolinePrice) {
        this.gasolinePrice = gasolinePrice;
    }

    public int getDieselAmount() {
        return dieselAmount;
    }

    public void setDieselAmount(int dieselAmount) {
        this.dieselAmount = dieselAmount;
    }

    public double getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(double dieselPrice) {
        this.dieselPrice = dieselPrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
