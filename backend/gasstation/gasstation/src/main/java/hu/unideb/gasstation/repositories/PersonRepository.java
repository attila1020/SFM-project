package hu.unideb.gasstation.repositories;

import hu.unideb.gasstation.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
