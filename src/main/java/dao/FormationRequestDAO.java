package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import entities.Employee;
import entities.Formation;
import entities.FormationRequest;
import jxlsimportation.Entry;

public class FormationRequestDAO {

	public FormationRequest formationrequestInjector(Entry entry, Employee employee, Formation formation) {

		FormationRequest formationrequest = new FormationRequest();
		formationrequest.setEmployee(employee);
		formationrequest.setFormation(formation);
		formationrequest.setDuration(entry.getFormationDuration());
		formationrequest.setRealStartingDate(entry.getRealStartingDate());

		FormationRequest formationrequestBdd = EmFactory.transaction(e -> {

			TypedQuery<FormationRequest> query = e.createQuery(
					"SELECT fr FROM FormationRequest fr WHERE fr.employee=:employee AND fr.formation = :formation AND fr.duration = :duration AND "
					+ "((:realStartingDate is null and fr.realStartingDate is null) or (:realStartingDate is not null and fr.realStartingDate=:realStartingDate))",
					FormationRequest.class);

			query = query.setParameter("employee", formationrequest.getEmployee())
					.setParameter("formation", formationrequest.getFormation())
					.setParameter("duration", entry.getFormationDuration())
					.setParameter("realStartingDate", entry.getRealStartingDate());

			List<FormationRequest> resultlist = (List<FormationRequest>) query.getResultList();

			if (resultlist.isEmpty()) {
				e.persist(formationrequest);
			}
			return null;

		});
		return formationrequestBdd;
	}

}
