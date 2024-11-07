package hu.unideb.gasstation.models;

public class Fuel {
    private String fuelType;
    private int sales;

    public Fuel(String fuelType, int sales) {
        this.fuelType = fuelType;
        this.sales = sales;
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
}
