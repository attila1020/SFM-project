package hu.unideb.gasstation.repositories;

import hu.unideb.gasstation.models.BoxedItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxedItemRepository extends JpaRepository<BoxedItems, Long> {
}
