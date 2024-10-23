package com.soca.persistencia;

import com.soca.entidades.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AutorDAO {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
	private final EntityManager em = emf.createEntityManager();
	
	public void actualizarAlta(int id, boolean alta) throws Exception {
		Autor autor = em.find(Autor.class, id);
		autor.setAlta(alta);
		
		em.getTransaction().begin();
		em.merge(autor);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public void crearAutor(String nombre, Boolean alta) throws Exception {
		Autor autorNuevo = new Autor();
		autorNuevo.setNombre(nombre);
		autorNuevo.setAlta(alta);
		
		em.getTransaction().begin();
		em.persist(autorNuevo);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
