package dao;

import java.util.function.Consumer;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmFactory {

	private static EntityManagerFactory instance;

	public EmFactory() {
		instance = Persistence.createEntityManagerFactory("formationsopra");
	}

	public EntityManager getEntityManager() {
		return instance.createEntityManager();
	}

	public void close() {
		instance.close();
	}

	public static EntityManagerFactory getInstance() {
		if (instance == null) {
			instance = Persistence.createEntityManagerFactory("formationsopra");
		}
		return instance;
	}

	public static EntityManager createEntityManager() {
		return getInstance().createEntityManager();
	}

	public static <T> T transaction(Function<EntityManager, T> worker) {

		EntityManager em = createEntityManager();
		em.getTransaction().begin();

		T result = worker.apply(em);

		em.getTransaction().commit();
		em.close();

		return result;
	}

	public static void voidTransaction(Consumer<EntityManager> worker) {

		EntityManager em = createEntityManager();
		em.getTransaction().begin();

		worker.accept(em);

		em.getTransaction().commit();
		em.close();
	}

}
