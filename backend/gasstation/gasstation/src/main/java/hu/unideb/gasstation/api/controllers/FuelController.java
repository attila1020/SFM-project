package hu.unideb.gasstation.api.controllers;

import hu.unideb.gasstation.models.Fuel;
import hu.unideb.gasstation.models.FuelData;
import hu.unideb.gasstation.repositories.FuelDataRepository;
import hu.unideb.gasstation.repositories.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FuelController {

    @Autowired
    FuelDataRepository fuelDataRepository;

    @Autowired
    FuelRepository fuelRepository;


    @GetMapping("/fetch-fuel-data")
    public List<FuelData> fetchFuelDate() {
        return fuelDataRepository.findAll();
    }

    @PostMapping("/modify-fuel")
    public void modifyFuelData(@RequestBody FuelData fuelData) {
        fuelDataRepository.save(fuelData);
    }

    public int returnSale(List<Fuel> array) {
        Fuel firstEntity = array.get(array.size()-1);
        Fuel secondEntity = array.get(array.size()-2);

        return firstEntity.getSales() - secondEntity.getSales();
    }

    @GetMapping("/fuel-sales")
    public List<Fuel> fuelSales(){

        List<Fuel> gasSales = fuelRepository.findByFuelType("Gasoline");
        List<Fuel> dieselSales = fuelRepository.findByFuelType("Diesel");


        Fuel gasSale = new Fuel("Gasoline", returnSale(gasSales));
        Fuel dieselSale = new Fuel("Diesel", returnSale(dieselSales));

        return Arrays.asList(
                gasSale, dieselSale
        );

    }
}
