package jxlsimportation;

public class StupidEntry {

	String formationMonth;
	String agenceID;
	String formationDuration;
	String expectedStartingDate;
	String realStartingDate;
	String formationTitle;
	String formationLocation;
	String lastName;
	String firstName;
	String formationProvider;

	public StupidEntry() {

	}

	public String getFormationMonth() {
		return formationMonth;
	}

	public void setFormationMonth(String formationMonth) {
		this.formationMonth = formationMonth;
	}

	public String getAgenceID() {
		return agenceID;
	}

	public void setAgenceID(String agenceID) {
		this.agenceID = agenceID;
	}

	public String getFormationDuration() {
		return formationDuration;
	}

	public void setFormationDuration(String formationDuration) {
		this.formationDuration = formationDuration;
	}

	public String getExpectedStartingDate() {
		return expectedStartingDate;
	}

	public void setExpectedStartingDate(String expectedStartingDate) {
		this.expectedStartingDate = expectedStartingDate;
	}

	public String getRealStartingDate() {
		return realStartingDate;
	}

	public void setRealStartingDate(String realStartingDate) {
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFormationProvider() {
		return formationProvider;
	}

	public void setFormationProvider(String formationProvider) {
		this.formationProvider = formationProvider;
	}

	public String toString() {

		return this.formationMonth + " " + this.agenceID + " " + this.expectedStartingDate + " " + this.realStartingDate
				+ " " + this.formationTitle + " " + this.formationLocation + " " + this.lastName + " " + this.firstName
				+ " " + this.formationProvider;

	}

}
