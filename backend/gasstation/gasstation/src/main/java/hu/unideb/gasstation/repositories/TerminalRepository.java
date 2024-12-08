package hu.unideb.gasstation.repositories;

import hu.unideb.gasstation.models.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TerminalRepository extends JpaRepository<Terminal, Long> {
    List<Terminal> findByTerminal(String s);
}
