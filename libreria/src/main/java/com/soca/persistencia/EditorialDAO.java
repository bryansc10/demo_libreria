package com.soca.persistencia;

import java.util.List;

import com.soca.entidades.Editorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EditorialDAO {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
	private final EntityManager em = emf.createEntityManager();
	
	public Editorial buscarEditorialID(int id) throws Exception {
		return em.find(Editorial.class, id);
	}
	
	public void actualizarAlta(int id, boolean alta) throws Exception {
		Editorial editorial = em.find(Editorial.class, id);
		editorial.setAlta(alta);
		
		em.getTransaction().begin();
		em.merge(editorial);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public void crearEditorial(String nombre, Boolean alta) throws Exception {
		Editorial editorialNueva = new Editorial();
		editorialNueva.setNombre(nombre);
		editorialNueva.setAlta(alta);
		
		em.getTransaction().begin();
		em.persist(editorialNueva);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public List<Editorial> buscarNombre(String nombre) throws Exception {
		String sql = "SELECT e FROM Editorial e WHERE e.nombre = :nombre";
		return em.createQuery(sql, Editorial.class).setParameter("nombre", nombre).getResultList();
	}
}
