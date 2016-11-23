package dao;

import java.util.List;

import entities.Employee;
import entities.Formation;
import entities.FormationRequest;
import jxlsimportation.Entry;

public class JpaApp {

	public void dataInjector(List<Entry> entries) {
		System.out.println("  ========== STARTING WORK ======= ");

		EmployeeDAO employeedao = new EmployeeDAO();

		FormationDAO formationdao = new FormationDAO();

		FormationRequestDAO formationrequestdao = new FormationRequestDAO();

		for (int i = 0; i < entries.size(); i++) {

			Employee employeeBdd = employeedao.employeeInjector(entries.get(i));

			Formation formationBdd = formationdao.formationInjector(entries.get(i));

			if (employeeBdd.getFirstName() != null && formationBdd.getTitle() != null) {

				formationrequestdao.formationrequestInjector(entries.get(i),
						employeeBdd, formationBdd);

			}

		}

		EmFactory.getInstance().close();
	}

}
