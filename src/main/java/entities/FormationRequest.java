package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FormationRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer formationRequestID =null;
	
	@ManyToOne
	Employee employee;
	
	@ManyToOne
	Formation formation;

}
