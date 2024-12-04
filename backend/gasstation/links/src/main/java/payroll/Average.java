package payroll;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Avg")
class Avg {

	private @Id @GeneratedValue Long id;
	private int gasoline;
	private int diesel;
	private int windowCleaner;
	private int engineOil;
	private int coolant;
	private int antiFreeze;
	private String createdAt;

	Avg() {
		this.createdAt = java.time.LocalDateTime.now().toString();
	}

	Avg(int gasoline, int diesel, int windowCleaner, int engineOil, int coolant, int antiFreeze) {
		this.gasoline = gasoline;
		this.diesel = diesel;
		this.windowCleaner = windowCleaner;
		this.engineOil = engineOil;
		this.coolant = coolant;
		this.antiFreeze = antiFreeze;
		this.createdAt = java.time.LocalDateTime.now().toString();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Avg))
			return false;
		Avg avg = (Avg) o;
		return this.gasoline == avg.gasoline &&
			   this.diesel == avg.diesel &&
			   this.windowCleaner == avg.windowCleaner &&
			   this.engineOil == avg.engineOil &&
			   this.coolant == avg.coolant &&
			   this.antiFreeze == avg.antiFreeze &&
			   Objects.equals(this.id, avg.id) &&
			   Objects.equals(this.createdAt, avg.createdAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.gasoline, this.diesel, this.windowCleaner, this.engineOil, this.coolant, this.antiFreeze, this.createdAt);
	}

	@Override
	public String toString() {
		return "Avg{" +
				"id=" + this.id +
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
