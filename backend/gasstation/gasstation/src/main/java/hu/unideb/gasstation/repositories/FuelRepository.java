package hu.unideb.gasstation.repositories;

import hu.unideb.gasstation.models.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuelRepository extends JpaRepository<Fuel, Long> {
    public List<Fuel> findByFuelType(String type);
}
