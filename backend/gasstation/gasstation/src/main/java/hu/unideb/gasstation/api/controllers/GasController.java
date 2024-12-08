package hu.unideb.gasstation.api.controllers;

import hu.unideb.gasstation.models.*;
import hu.unideb.gasstation.repositories.TerminalRepository;
import hu.unideb.gasstation.repositories.TopSellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GasController {

    @Autowired
    TerminalRepository terminalRepository;

    @Autowired
    TopSellingRepository topSellingRepository;

    @GetMapping("/stock-levels")
    public List<Terminal> stockLevels() {

        List<Terminal> firstTerminalStock = terminalRepository.findByTerminal("Terminal 1");
        List<Terminal> secondTerminalStock = terminalRepository.findByTerminal("Terminal 2");

        return Arrays.asList(
                firstTerminalStock.get(firstTerminalStock.size()-1), secondTerminalStock.get(firstTerminalStock.size()-1)
        );
    }
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
