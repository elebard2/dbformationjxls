package entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FormationRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer formationRequestID = null;

	@ManyToOne
	Employee employee;

	@ManyToOne
	Formation formation;

	Date realStartingDate;
	BigDecimal duration;

	public Date getRealStartingDate() {
		return realStartingDate;
	}

	public void setRealStartingDate(Date realStartingDate) {
		this.realStartingDate = realStartingDate;
	}

	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public String toString() {
		return this.duration + " " + this.employee + " " + this.formationRequestID + " " + this.realStartingDate;
	}

}
