package jxlsimportation;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;

public class Entry {

	SimpleDateFormat isoFormat = new SimpleDateFormat("dd-MM-yyyy");

	Integer formationMonth;
	BigDecimal formationDuration;
	Date expectedStartingDate;
	Date realStartingDate;
	String formationTitle;
	String formationLocation;
	StupidEmployee employee;
	String formationProvider;

	public Entry() {

	}

	public Entry(StupidEntry stupidentry) throws ParseException {

		try {
			setFormationMonth(Integer.valueOf(stupidentry.formationMonth));
		} catch (Exception e) {
			setFormationMonth(null);
		}

		try {
			setFormationDuration(new BigDecimal(stupidentry.formationDuration));
		} catch (Exception e) {
			setFormationDuration(new BigDecimal("0"));
			;
		}

		try {
			double xlsDate = Double.valueOf(stupidentry.expectedStartingDate);
			this.expectedStartingDate = DateUtil.getJavaDate(xlsDate);
		} catch (Exception e) {
			// no date if nothing is written
			setExpectedStartingDate(null);
		}

		try {
			double xlsDate = Double.valueOf(stupidentry.realStartingDate);
			this.realStartingDate = DateUtil.getJavaDate(xlsDate);
		} catch (Exception e) {
			// no date if it was not written or if the employee didn't go
			setRealStartingDate(null);
		}

		if (stupidentry.lastName != null && stupidentry.firstName != null && stupidentry.agenceID != null) {
			this.employee = new StupidEmployee();
			this.employee.setFirstName(stupidentry.firstName);
			this.employee.setLastName(stupidentry.lastName);
			this.employee.setAgenceID(stupidentry.agenceID);
		} else {
			this.employee = new StupidEmployee();
			this.employee.setFirstName("!INVALID");
			this.employee.setLastName("!INVALID");
			this.employee.setAgenceID("!INVALID");
		}

		try {

			this.formationTitle = stupidentry.formationTitle;

		} catch (Exception e) {

			this.formationLocation = "!INVALID";

		}

		try {

			this.formationLocation = stupidentry.formationLocation;

		} catch (Exception e) {

			this.formationLocation = "undetermined";

		}

		try {

			if (stupidentry.formationProvider != null) {

				this.formationProvider = stupidentry.formationProvider;

			} else {
				
				this.formationProvider = "undetermined";
				
			}

		} catch (Exception e) {

			this.formationProvider = "undetermined";

		}
	}

	public Integer getFormationMonth() {
		return formationMonth;
	}

	public void setFormationMonth(Integer formationMonth) {
		this.formationMonth = formationMonth;
	}

	public BigDecimal getFormationDuration() {
		return formationDuration;
	}

	public void setFormationDuration(BigDecimal bigDecimal) {
		this.formationDuration = bigDecimal;
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

	public String getFormationTitle() {
		return formationTitle;
	}

	public void setFormationTitle(String formationTitle) {
		this.formationTitle = formationTitle;
	}

	public String getFormationLocation() {
		return formationLocation;
	}

	public void setFormationLocation(String formationLocation) {
		this.formationLocation = formationLocation;
	}

	public StupidEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(StupidEmployee employee) {
		this.employee = employee;
	}

	public String getFormationProvider() {
		return formationProvider;
	}

	public void setFormationProvider(String formationProvider) {
		this.formationProvider = formationProvider;
	}

	public String toString() {
		return this.formationMonth + " " + this.employee + " " + this.formationDuration + " "
				+ this.expectedStartingDate + " " + this.realStartingDate + " " + this.formationTitle + " "
				+ this.formationLocation + " " + this.formationProvider;
	}

}
