package hu.unideb.gasstation.models;

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


	Avg() {
	}

	Avg(int gasoline, int diesel, int windowCleaner, int engineOil, int coolant, int antiFreeze) {
		this.gasoline = gasoline;
		this.diesel = diesel;
		this.windowCleaner = windowCleaner;
		this.engineOil = engineOil;
		this.coolant = coolant;
		this.antiFreeze = antiFreeze;
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
}