package hu.unideb.gasstation.api.controllers;

import hu.unideb.gasstation.models.Avg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AvgController {

    @GetMapping("/averages")
    public List<Avg> getAverages() {
        // Hardcoded response for testing
        return Arrays.asList(
                new Avg(500, 300, 200, 100, 50, 30),
                new Avg(450, 350, 150, 120, 60, 40)
        );
    }
}