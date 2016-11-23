package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import application.App;
import entities.Formation;
import jxlsimportation.Entry;

public class FormationDAO {

	public Formation formationInjector(Entry entry) {
		Formation formation = new Formation();
		formation.setExpectedStartingDate(entry.getExpectedStartingDate());
		formation.setTitle(entry.getFormationTitle());
		formation.setLocation(entry.getFormationLocation());
		formation.setFormationprovider(entry.getFormationProvider());

		Formation formationBdd = new Formation();

		if (!App.INVALID_ENTRY_MARKER.equals(formation.getTitle())) {

			formationBdd = EmFactory.transaction(e -> {

				TypedQuery<Formation> query = e.createQuery(
						"SELECT f FROM Formation f WHERE f.title=:title AND f.location = :location AND f.formationprovider = :formationprovider AND"
								+ "((:expectedStartingDate is null and f.expectedStartingDate is null) or (:expectedStartingDate is not null and f.expectedStartingDate=:expectedStartingDate))",
						Formation.class);

				query = query.setParameter("title", formation.getTitle())
						.setParameter("location", formation.getLocation())
						.setParameter("expectedStartingDate", formation.getExpectedStartingDate())
						.setParameter("formationprovider", formation.getFormationprovider());

				List<Formation> resultlist = (List<Formation>) query.getResultList();

				if (resultlist.isEmpty()) {

					e.persist(formation);

					return formation;
				}

				return resultlist.get(0);

			});
		}

		return formationBdd;
	}

}
