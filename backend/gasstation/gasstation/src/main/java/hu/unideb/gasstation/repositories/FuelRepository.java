package hu.unideb.gasstation.repositories;

import hu.unideb.gasstation.models.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel, Long> {
}
