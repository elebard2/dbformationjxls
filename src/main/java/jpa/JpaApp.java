package jpa;

import javax.persistence.EntityManager;

import jpa.EmFactory;

public class JpaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = EmFactory.createEntityManager();
		em.getTransaction().begin();
		
		System.out.println("  ========== STARTING WORK ======= ");
		
		em.getTransaction().commit();
		
		em.close();
		
		EmFactory.getInstance().close();

	}

}
