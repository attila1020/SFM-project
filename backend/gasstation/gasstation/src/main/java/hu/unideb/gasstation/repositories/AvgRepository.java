package hu.unideb.gasstation.repositories;

import hu.unideb.gasstation.models.Avg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvgRepository extends JpaRepository<Avg, Long> {
}
