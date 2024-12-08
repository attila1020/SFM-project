package hu.unideb.gasstation.api.controllers;

import hu.unideb.gasstation.GasstationApplication;
import hu.unideb.gasstation.models.Fuel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class FuelControllerTest extends GasstationApplication {


    public int returnSale(List<Fuel> array) {
        Fuel firstEntity = array.get(array.size()-1);
        Fuel secondEntity = array.get(array.size()-2);

        return firstEntity.getSales() - secondEntity.getSales();
    }
    @Test
    void returnSaleTest() {
        List<Fuel> fuels = new ArrayList<>();

        fuels.add(new Fuel("Gasoline", 1200));
        fuels.add(new Fuel("Gasoline", 1500));

        assert returnSale(fuels) == 300;
    }
}