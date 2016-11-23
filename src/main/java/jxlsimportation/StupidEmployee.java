package jxlsimportation;

public class StupidEmployee {

	String lastName;
	String firstName;
	String agenceID;

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

	public String getAgenceID() {
		return agenceID;
	}

	public void setAgenceID(String agenceID) {
		this.agenceID = agenceID;
	}

	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.agenceID;
	}
}
