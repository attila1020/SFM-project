package hu.unideb.gasstation.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TimeOfDay")
public class TimeOfDay {

    private @Id @GeneratedValue Long id;
    private int morningSales;
    private int afternoonSales;
    private int nightSales;


    public TimeOfDay() {
    }

    public TimeOfDay(int morningSales, int afternoonSales, int nightSales) {
        this.morningSales = morningSales;
        this.afternoonSales = afternoonSales;
        this.nightSales = nightSales;
       
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMorningSales() {
        return this.morningSales;
    }

    public void setMorningSales(int morningSales) {
        this.morningSales = morningSales;
    }

    public int getAfternoonSales() {
        return this.afternoonSales;
    }

    public void setAfternoonSales(int afternoonSales) {
        this.afternoonSales = afternoonSales;
    }

    public int getNightSales() {
        return this.nightSales;
    }

    public void setNightSales(int nightSales) {
        this.nightSales = nightSales;
    }
}