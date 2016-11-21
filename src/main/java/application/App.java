package application;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;
import org.xml.sax.SAXException;

import entities.Employee;
import entities.Entry;
import entities.Formation;
import entities.FormationRequest;
import entities.StupidEntry;

import javax.persistence.EntityManager;

import jpa.EmFactory;

public class App {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		App app = new App();

		List<Entry> entries = app.xlsReadFromFile();

		EntityManager em = EmFactory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("  ========== STARTING WORK ======= ");

		for (int i = 0; i < entries.size(); i++) {
			Formation formation = new Formation();
			formation.setExpectedStartingDate(entries.get(i).getExpectedStartingDate());
			formation.setTitle(entries.get(i).getFormationTitle());
			formation.setLocation(entries.get(i).getFormationLocation());
			formation.setRealStartingDate(entries.get(i).getRealStartingDate());
			formation.setDuration(entries.get(i).getFormationDuration());
			formation.setFormationprovider(entries.get(i).getFormationProvider());

			EmFactory.transaction(e -> {

				String query = "SELECT f FROM Formation f WHERE f.title = :title";

				/**
				 * AND f.location = :location AND f.expectedStartingDate =
				 * :expectedStartingDate AND f.realStartingDate =
				 * :realStartingDate and f.duration =:duration AND
				 * f.formationprovider = :formationprovider
				 */
				
				System.out.println(formation);

				List list = e.createQuery(query).setParameter("title", formation.getTitle()).getResultList();
				
				/**
				 * .setParameter("location", formation.getLocation())
				 * .setParameter("expectedStartingDate",
				 * formation.getExpectedStartingDate()).setParameter("realStartingDate",
				 * formation.getRealStartingDate()) .setParameter("duration",
				 * formation.getDuration()) .setParameter("formationprovider",
				 * formation.getFormationprovider())
				 */

				if (list.isEmpty()) {
					em.persist(formation);
				}
				return null;

			});

			Employee employee = new Employee();
			employee.setAgenceID(entries.get(i).getEmployee().getAgenceID());
			employee.setFirstName(entries.get(i).getEmployee().getFirstName());
			employee.setLastName(entries.get(i).getEmployee().getLastName());

			FormationRequest formationrequest = new FormationRequest();
			formationrequest.setEmployee(employee);
			formationrequest.setFormation(formation);
		}

		em.getTransaction().commit();

		em.close();

	}

	public List<Entry> xlsReadFromFile() throws ParseException {

		InputStream xmlConfig = null;

		try {
			xmlConfig = new BufferedInputStream(new FileInputStream(
					"C://code//workspace//dbformationjxls//src//main//java//application//config.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XLSReader xlsReader = null;

		try {
			xlsReader = ReaderBuilder.buildFromXML(xmlConfig);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<StupidEntry> stupidentries = new ArrayList<StupidEntry>();

		Map<String, List<StupidEntry>> beans = new HashMap<String, List<StupidEntry>>();

		beans.put("stupidentries", stupidentries);

		InputStream xlsStream = null;

		try {
			xlsStream = new BufferedInputStream(
					new FileInputStream("C://code//workspace//dbformationjxls//sopra-modified.xlsx"));
			xlsReader.read(xlsStream, beans);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		stupidentries.remove(stupidentries.size() - 1);

		List<Entry> entries = new ArrayList<Entry>();

		for (int i = 0; i < stupidentries.size(); i++) {
			Entry entry = new Entry(stupidentries.get(i));
			entries.add(entry);
		}

		return entries;

	}

}
