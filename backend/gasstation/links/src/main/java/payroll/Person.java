package payroll;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
class Person {

	private @Id @GeneratedValue Long id;
	private int gasStationID;  // Modified from Long to int
	private String name;
	private String email;
	private String phoneNumber;
	private int level;
	private int points;
	private boolean isStaff;

	Person() {}
	Person(String name, String email, String phoneNumber, int level, int points, boolean isStaff) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.level = level;
		this.points = points;
		this.isStaff = isStaff;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGasStationID() {
		return this.gasStationID;
	}

	public void setGasStationID(int gasStationID) {
		this.gasStationID = gasStationID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isStaff() {
		return this.isStaff;
	}

	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Person))
			return false;
		Person person = (Person) o;
		return Objects.equals(this.id, person.id) && 
			   this.gasStationID == person.gasStationID &&
			   Objects.equals(this.name, person.name) &&
			   Objects.equals(this.email, person.email) &&
			   Objects.equals(this.phoneNumber, person.phoneNumber) &&
			   this.level == person.level &&
			   this.points == person.points &&
			   this.isStaff == person.isStaff;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.gasStationID, this.name, this.email, this.phoneNumber, this.level, this.points, this.isStaff);
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + this.id +
				", gasStationID=" + this.gasStationID +
				", name='" + this.name + '\'' +
				", email='" + this.email + '\'' +
				", phoneNumber='" + this.phoneNumber + '\'' +
				", level=" + this.level +
				", points=" + this.points +
				", isStaff=" + this.isStaff +
				'}';
	}
}
