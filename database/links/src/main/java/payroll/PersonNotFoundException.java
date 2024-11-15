package payroll;

class PersonNotFoundException extends RuntimeException {

	PersonNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}

class GasStationNotFoundException extends RuntimeException {

	GasStationNotFoundException(Long id) {
		super("Could not find gas station " + id);
	}
}

class PriceNotFoundException extends RuntimeException {

	PriceNotFoundException(Long id) {
		super("Could not find price with ID " + id);
	}
}

class StockNotFoundException extends RuntimeException {

	StockNotFoundException(Long id) {
		super("Could not find stock with ID " + id);
	}
}