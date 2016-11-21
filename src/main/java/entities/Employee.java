package entities;

public class Employee {
	
	String lastName;
	String firstName;
	Integer agenceID;
	
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
	public Integer getAgenceID() {
		return agenceID;
	}
	public void setAgenceID(Integer agenceID) {
		this.agenceID = agenceID;
	}
	
	public String toString(){
		return this.firstName + " " + this.lastName +  " " + this.agenceID;
	}

}
