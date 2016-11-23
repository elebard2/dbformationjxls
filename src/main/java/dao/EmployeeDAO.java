package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import application.App;
import entities.Employee;
import jxlsimportation.Entry;

public class EmployeeDAO {

	public Employee employeeInjector(Entry entry) {

		Employee employee = new Employee();
		employee.setAgenceID(entry.getEmployee().getAgenceID());
		employee.setFirstName(entry.getEmployee().getFirstName());
		employee.setLastName(entry.getEmployee().getLastName());
		
		Employee employeeBdd = new Employee();
		
		if (!App.INVALID_ENTRY_MARKER.equals(employee.getFirstName())) {
			
			employeeBdd = EmFactory.transaction(e -> {

				TypedQuery<Employee> query = e.createQuery(
						"SELECT e FROM Employee e WHERE e.agenceID=:agenceID AND e.firstName = :firstName AND e.lastName ="
								+ ":lastName",
						Employee.class);

				query = query.setParameter("agenceID", employee.getAgenceID())
						.setParameter("firstName", employee.getFirstName())
						.setParameter("lastName", employee.getLastName());

				List<Employee> resultlist = (List<Employee>) query.getResultList();

				if (resultlist.isEmpty()) {
					
						e.persist(employee);

					return employee;
				}
				return resultlist.get(0);
			});
		}

		return employeeBdd;

	}

}
