package com.soca.persistencia;

import com.soca.entidades.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LibroDAO {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
	private final EntityManager em = emf.createEntityManager();
	
	public void actualizarAlta(int id, boolean alta) throws Exception {
		Libro libro = em.find(Libro.class, id);
		libro.setAlta(alta);
		
		em.getTransaction().begin();
		em.merge(libro);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
