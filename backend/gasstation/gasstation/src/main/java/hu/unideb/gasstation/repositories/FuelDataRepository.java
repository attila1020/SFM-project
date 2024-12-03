package hu.unideb.gasstation.repositories;

import hu.unideb.gasstation.models.FuelData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelDataRepository extends JpaRepository<FuelData, Long> {
}
