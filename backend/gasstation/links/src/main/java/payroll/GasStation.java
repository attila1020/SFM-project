package payroll;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GasStation")
class GasStation {

	private @Id @GeneratedValue Long id;
	private String name;
	private int stockID;  // Changed from Long to int

	GasStation() {}

	GasStation(String name) {  // Constructor updated to accept int
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStockID() {  // Return type changed from Long to int
		return this.stockID;
	}

	public void setStockID(int stockID) {  // Parameter type changed from Long to int
		this.stockID = stockID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof GasStation))
			return false;
		GasStation gasStation = (GasStation) o;
		return this.id.equals(gasStation.id) &&
			   Objects.equals(this.name, gasStation.name) &&
			   this.stockID == gasStation.stockID;  // Comparison updated to use '==' for int
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.stockID);  // stockID now an int
	}

	@Override
	public String toString() {
		return "GasStation{" +
				"id=" + this.id +
				", name='" + this.name + '\'' +
				", stockID=" + this.stockID +  // stockID is now an int
				'}';
	}
}
