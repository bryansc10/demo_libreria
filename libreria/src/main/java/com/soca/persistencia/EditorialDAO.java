package com.soca.persistencia;

import com.soca.entidades.Editorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EditorialDAO {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
	private final EntityManager em = emf.createEntityManager();
	
	public void actualizarAlta(int id, boolean alta) throws Exception {
		Editorial editorial = em.find(Editorial.class, id);
		editorial.setAlta(alta);
		
		em.getTransaction().begin();
		em.merge(editorial);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
