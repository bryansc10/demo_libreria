package com.soca.servicios;

import java.util.List;

import com.soca.entidades.Libro;
import com.soca.persistencia.LibroDAO;

public class LibroServicio {
	private final LibroDAO daoLibro;
	
	public LibroServicio() {
		this.daoLibro = new LibroDAO();
	}
	
	public void encontrarLibroID(int id) {
		try {
			imprimirLibro(daoLibro.buscarLibroID(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se guardo el libro.");
		}
	}
	
	public void encontrarLibrosPorAutor(String nombre) {
		try {
			List<Libro> librosRecibidos = daoLibro.buscarLibroPorAutor(nombre);
			System.out.println("POR AUTOR: " + nombre);
			imprimirLibro(librosRecibidos);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se encontró el libro.");
		}
	}
	
	public void encontrarLibrosPorEditorial(String nombre) {
		try {
			List<Libro> librosRecibidos = daoLibro.buscarLibroPorEditorial(nombre);
			System.out.println("POR EDITORIAL: " + nombre);
			imprimirLibro(librosRecibidos);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se encontró el libro.");
		}
	}
	
	public void guardarLibro(String titulo, Integer anio, Integer ejemplares, Boolean alta, Integer autorID, Integer editorialID) {
		try {
			Libro libroNuevo = new Libro();
			AutorServicio autor = new AutorServicio();
			EditorialServicio editorial = new EditorialServicio();
			
			libroNuevo.setTitulo(titulo);
			libroNuevo.setAnio(anio);
			libroNuevo.setEjemplares(ejemplares);
			libroNuevo.setAlta(alta);
			libroNuevo.setAutor(autor.encontrarAutorID(autorID));
			libroNuevo.setEditorial(editorial.encontrarEditorialID(editorialID));
			
			daoLibro.crearLibro(libroNuevo);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se guardo el libro.");
		}
	}
	
	public void darAlta(int id) {
		try {
			daoLibro.actualizarAlta(id, true);
			System.out.println("Se dio de alta.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se realizo el alta del libro.");
		}
	}
	
	public void darBaja(int id) {
		try {
			daoLibro.actualizarAlta(id, false);
			System.out.println("Se dio de baja.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se realizo la baja del libro.");
		}
	}
	public void imprimirLibro(Libro libroRecibido) {
		System.out.println("LIBRO");
		System.out.printf("%-4s %-50s %-5s %-5s %-4s %-50s %-50s","ISBN", "Título", "Año", "Cant.", "Alta", "Autor", "Editorial");
		System.out.println(libroRecibido.toString());
	}
	
	public void imprimirLibro(List<Libro> librosRecibidos) {
		System.out.printf("%-4s %-50s %-5s %-5s %-4s %-50s %-50s","ISBN", "Título", "Año", "Cant.", "Alta", "Autor", "Editorial");
		for (Libro libro : librosRecibidos) {
			System.out.println(libro.toString());
		}
	}
	
}
