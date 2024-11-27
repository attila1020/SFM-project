package hu.unideb.gasstation.api.controllers;

import hu.unideb.gasstation.models.Fuel;
import hu.unideb.gasstation.models.TopSelling;
import hu.unideb.gasstation.models.LowStockAlert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GasController {

    @GetMapping("/fuel-sales")
    public List<Fuel> fuelSales(){

        // Create business logic to get sales
        // ARGS: fuelType:String, currentStock:int, lastStock:int
        // RETURN: FuelType, currentStock - lastStock as a Array/List
        return Arrays.asList(
                new Fuel("Gasoline", 500),
                new Fuel("Diesel", 300)
        );
    }

//    @GetMapping("/stock-levels")
//    public List<Stock> stockLevels() {
//
//    }
    @GetMapping("/top-selling-products")
    public List<TopSelling> topSellingProducts() {
        return Arrays.asList(
                new TopSelling("Engine Oil", 450),
                new TopSelling("Coolant", 200)
        );
    }

    @GetMapping("/low-stock")
    public List<LowStockAlert> lowStockAlerts() {
        // Hardcoded response for testing
        return Arrays.asList(
                new LowStockAlert("Wiper Fluid", 10),
                new LowStockAlert("Antifreeze", 5),
                new LowStockAlert("Brake Fluid", 3)
        );

    }
}
