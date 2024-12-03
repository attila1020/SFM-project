package hu.unideb.gasstation.repositories;

import hu.unideb.gasstation.models.TopSelling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopSellingRepository extends JpaRepository<TopSelling, Long> {
}
