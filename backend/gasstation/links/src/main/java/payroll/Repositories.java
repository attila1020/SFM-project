package payroll;

import org.springframework.data.jpa.repository.JpaRepository;

interface PersonRepository extends JpaRepository<Person, Long> {}
interface StockRepository extends JpaRepository<Stock, Long> {}
interface GasStationRepository extends JpaRepository<GasStation, Long> {}
interface PriceRepository extends JpaRepository<Price, Long> {}
interface AvgRepository extends JpaRepository<Avg, Long> {}