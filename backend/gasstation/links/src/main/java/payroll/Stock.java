package payroll;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stock")
class Stock {

	private @Id @GeneratedValue Long stockID;
	private Long currentPriceID;
	private int gasoline;
	private int diesel;
	private int windowCleaner;
	private int engineOil;
	private int coolant;
	private int antiFreeze;
	private String createdAt;  // Change LocalDateTime to String

	Stock() {
		this.createdAt = java.time.LocalDateTime.now().toString();  // Convert LocalDateTime to String
	}

	Stock(Long currentPriceID, int gasoline, int diesel, int windowCleaner, int engineOil, int coolant, int antiFreeze) {
		this.currentPriceID = currentPriceID;
		this.gasoline = gasoline;
		this.diesel = diesel;
		this.windowCleaner = windowCleaner;
		this.engineOil = engineOil;
		this.coolant = coolant;
		this.antiFreeze = antiFreeze;
		this.createdAt = java.time.LocalDateTime.now().toString();  // Convert LocalDateTime to String
	}

	public Long getStockID() {
		return this.stockID;
	}

	public void setStockID(Long stockID) {
		this.stockID = stockID;
	}

	public Long getCurrentPriceID() {
		return this.currentPriceID;
	}

	public void setCurrentPriceID(Long currentPriceID) {
		this.currentPriceID = currentPriceID;
	}

	public int getGasoline() {
		return this.gasoline;
	}

	public void setGasoline(int gasoline) {
		this.gasoline = gasoline;
	}

	public int getDiesel() {
		return this.diesel;
	}

	public void setDiesel(int diesel) {
		this.diesel = diesel;
	}

	public int getWindowCleaner() {
		return this.windowCleaner;
	}

	public void setWindowCleaner(int windowCleaner) {
		this.windowCleaner = windowCleaner;
	}

	public int getEngineOil() {
		return this.engineOil;
	}

	public void setEngineOil(int engineOil) {
		this.engineOil = engineOil;
	}

	public int getCoolant() {
		return this.coolant;
	}

	public void setCoolant(int coolant) {
		this.coolant = coolant;
	}

	public int getAntiFreeze() {
		return this.antiFreeze;
	}

	public void setAntiFreeze(int antiFreeze) {
		this.antiFreeze = antiFreeze;
	}

	public String getCreatedAt() {
		return this.createdAt;  // Return the String value
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;  // Set the String value
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Stock))
			return false;
		Stock stock = (Stock) o;
		return Objects.equals(this.stockID, stock.stockID) &&
			   Objects.equals(this.currentPriceID, stock.currentPriceID) &&
			   this.gasoline == stock.gasoline &&
			   this.diesel == stock.diesel &&
			   this.windowCleaner == stock.windowCleaner &&
			   this.engineOil == stock.engineOil &&
			   this.coolant == stock.coolant &&
			   this.antiFreeze == stock.antiFreeze &&
			   Objects.equals(this.createdAt, stock.createdAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.stockID, this.currentPriceID, this.gasoline, this.diesel, this.windowCleaner, this.engineOil, this.coolant, this.antiFreeze, this.createdAt);
	}

	@Override
	public String toString() {
		return "Stock{" +
				"stockID=" + this.stockID +
				", currentPriceID=" + this.currentPriceID +
				", gasoline=" + this.gasoline +
				", diesel=" + this.diesel +
				", windowCleaner=" + this.windowCleaner +
				", engineOil=" + this.engineOil +
				", coolant=" + this.coolant +
				", antiFreeze=" + this.antiFreeze +
				", createdAt='" + this.createdAt + '\'' +
				'}';
	}
}
