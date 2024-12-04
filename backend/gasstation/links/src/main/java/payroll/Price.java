package payroll;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Price")
class Price {

	private @Id @GeneratedValue Long priceID;
	private float gasoline;        // Changed from double to float
	private float diesel;          // Changed from double to float
	private float windowCleaner;   // Changed from double to float
	private float engineOil;       // Changed from double to float
	private float coolant;         // Changed from double to float
	private float antiFreeze;      // Changed from double to float
	private String createdAt;

	Price() {}

	Price(float gasoline, float diesel, float windowCleaner, float engineOil, float coolant, float antiFreeze) {
		this.gasoline = gasoline;
		this.diesel = diesel;
		this.windowCleaner = windowCleaner;
		this.engineOil = engineOil;
		this.coolant = coolant;
		this.antiFreeze = antiFreeze;
	}

	public Long getPriceID() {
		return this.priceID;
	}

	public void setPriceID(Long priceID) {
		this.priceID = priceID;
	}

	public float getGasoline() {
		return this.gasoline;
	}

	public void setGasoline(float gasoline) {
		this.gasoline = gasoline;
	}

	public float getDiesel() {
		return this.diesel;
	}

	public void setDiesel(float diesel) {
		this.diesel = diesel;
	}

	public float getWindowCleaner() {
		return this.windowCleaner;
	}

	public void setWindowCleaner(float windowCleaner) {
		this.windowCleaner = windowCleaner;
	}

	public float getEngineOil() {
		return this.engineOil;
	}

	public void setEngineOil(float engineOil) {
		this.engineOil = engineOil;
	}

	public float getCoolant() {
		return this.coolant;
	}

	public void setCoolant(float coolant) {
		this.coolant = coolant;
	}

	public float getAntiFreeze() {
		return this.antiFreeze;
	}

	public void setAntiFreeze(float antiFreeze) {
		this.antiFreeze = antiFreeze;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Price))
			return false;
		Price price = (Price) o;
		return Objects.equals(this.priceID, price.priceID) &&
			   Float.compare(this.gasoline, price.gasoline) == 0 &&
			   Float.compare(this.diesel, price.diesel) == 0 &&
			   Float.compare(this.windowCleaner, price.windowCleaner) == 0 &&
			   Float.compare(this.engineOil, price.engineOil) == 0 &&
			   Float.compare(this.coolant, price.coolant) == 0 &&
			   Float.compare(this.antiFreeze, price.antiFreeze) == 0 &&
			   Objects.equals(this.createdAt, price.createdAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.priceID, this.gasoline, this.diesel, this.windowCleaner, this.engineOil, this.coolant, this.antiFreeze, this.createdAt);
	}

	@Override
	public String toString() {
		return "Price{" +
				"priceID=" + this.priceID +
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
