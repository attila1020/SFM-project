package hu.unideb.gasstation.repositories;

import hu.unideb.gasstation.models.TimeOfDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeOfDayRepository extends JpaRepository<TimeOfDay, Long> {
}
