package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import entities.Formation;
import jxlsimportation.Entry;

public class FormationDAO {
	
	public Formation formationInjector(Entry entry){
		Formation formation = new Formation();
		formation.setExpectedStartingDate(entry.getExpectedStartingDate());
		formation.setTitle(entry.getFormationTitle());
		formation.setLocation(entry.getFormationLocation());
		formation.setFormationprovider(entry.getFormationProvider());

		Formation formationBdd = EmFactory.transaction(e -> {

			TypedQuery<Formation> query = e.createQuery(
					"SELECT f FROM Formation f WHERE f.title=:title AND f.location = :location AND f.expectedStartingDate ="
							+ ":expectedStartingDate AND"
							+ " f.formationprovider = :formationprovider",
					Formation.class);

			query = query.setParameter("title", formation.getTitle())
					.setParameter("location", formation.getLocation())
					.setParameter("expectedStartingDate", formation.getExpectedStartingDate())
					.setParameter("formationprovider", formation.getFormationprovider());

			List<Formation> resultlist = (List<Formation>) query.getResultList();

			if (resultlist.isEmpty()) {
				if(formation.getTitle()!="!INVALID"){
					e.persist(formation);
				}
				return formation;
			}

			return resultlist.get(0);

		});
		
		return formationBdd;
	}

}
