package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer formationID = null;

	String title;
	String location;
	Date expectedStartingDate;
	String formationprovider;

	public String getFormationprovider() {
		return formationprovider;
	}

	public void setFormationprovider(String formationprovider) {
		this.formationprovider = formationprovider;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getExpectedStartingDate() {
		return expectedStartingDate;
	}

	public void setExpectedStartingDate(Date expectedStartingDate) {
		this.expectedStartingDate = expectedStartingDate;
	}

	public String toString() {
		return this.expectedStartingDate + " " + this.formationprovider + " " + this.location + " " + this.title;
	}

}
