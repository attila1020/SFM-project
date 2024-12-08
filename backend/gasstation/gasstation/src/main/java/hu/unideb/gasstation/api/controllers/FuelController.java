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

    @GetMapping("/fuel-sales")
    public List<Fuel> fuelSales(){

        List<Fuel> gasSales = fuelRepository.findByFuelType("Gasoline");
        List<Fuel> dieselSales = fuelRepository.findByFuelType("Diesel");

        Fuel firstGas = gasSales.get(gasSales.size()-1);
        Fuel firstDiesel = dieselSales.get(dieselSales.size()-1);

        Fuel secondGas = gasSales.get(gasSales.size()-2);
        Fuel secondDiesel = dieselSales.get(dieselSales.size()-2);

        Fuel gasSale = new Fuel("Gasoline", firstGas.getSales()-secondGas.getSales());
        Fuel dieselSale = new Fuel("Diesel", firstDiesel.getSales()-secondDiesel.getSales());

        return Arrays.asList(
                gasSale, dieselSale
        );

    }
}
