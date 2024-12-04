package payroll;

class NotFoundException extends RuntimeException {

	NotFoundException(Long id) {
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
class AvgNotFoundException extends RuntimeException {

	AvgNotFoundException(Long id) {
		super("Could not find stock with ID " + id);
	}
}