package hu.unideb.gasstation.repositories;

import hu.unideb.gasstation.models.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminalRepository extends JpaRepository<Terminal, Long> {
}
