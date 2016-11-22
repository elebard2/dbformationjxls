package entities;

import java.math.BigDecimal;
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
	Date realStartingDate;
	BigDecimal duration;
	String formationprovider;

	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

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

	public Date getRealStartingDate() {
		return realStartingDate;
	}

	public void setRealStartingDate(Date realStartingDate) {
		this.realStartingDate = realStartingDate;
	}

	public String toString() {
		return this.duration + " " + this.expectedStartingDate + " " + this.formationprovider + " " + this.location
				+ " " + this.realStartingDate + " " + this.title;
	}

}
