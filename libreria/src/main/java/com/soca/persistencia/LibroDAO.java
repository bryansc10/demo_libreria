package com.soca.persistencia;

import java.util.List;

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

	public void crearLibro(Libro libro) throws Exception {
		em.getTransaction().begin();
		em.persist(libro);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public Libro buscarLibroID(int id) throws Exception {
		return em.find(Libro.class, id);
	}

	public List<Libro> buscarLibroPorAutor(String nombre) throws Exception {
		String sql = "SELECT l FROM Libro l WHERE l.autor.nombre LIKE :nombre";
		return em.createQuery(sql, Libro.class).setParameter("nombre", "%" + nombre + "%").getResultList();
	}
	
	public List<Libro> buscarLibroPorEditorial(String nombre) throws Exception {
		String sql = "SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :nombre";
		return em.createQuery(sql, Libro.class).setParameter("nombre", "%" + nombre + "%").getResultList();
	}
}
