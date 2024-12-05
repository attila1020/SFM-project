package hu.unideb.gasstation.api.controllers;

import hu.unideb.gasstation.models.TimeOfDay;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TimeOfDayController {

    @GetMapping("/time-of-day-sales")
    public List<TimeOfDay> getTimeOfDaySales() {
        // Hardcoded response for testing
        return Arrays.asList(
                new TimeOfDay(200, 300, 150),
                new TimeOfDay(180, 250, 170)
        );
    }
}
