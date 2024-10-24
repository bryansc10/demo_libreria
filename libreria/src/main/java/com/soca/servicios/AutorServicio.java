package com.soca.servicios;

import java.util.List;

import com.soca.entidades.Autor;
import com.soca.persistencia.AutorDAO;

public class AutorServicio {
	private final AutorDAO daoAutor;
	
	public AutorServicio() {
		this.daoAutor = new AutorDAO();
	}
	
	public Autor encontrarAutorID(int id) {
		Autor autor = null;
		try {
			autor = daoAutor.buscarAutorID(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se encontro el autor.");
		}
		return autor;
	}
	
	public void listarPorNombre(String nombre) {
		try {
			List<Autor> autor = daoAutor.buscarNombre(nombre);
			imprimirLista(autor);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se listo el autor.");
		}
	}
	
	public void guardarAutor(String nombre, Boolean alta) {
		try {
			daoAutor.crearAutor(nombre, alta);
			System.out.println("Se añadio el autor con exito.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se guardo el autor.");
		}
	}
	
	public void darAlta(int id) {
		try {
			daoAutor.actualizarAlta(id, true);
			System.out.println("Se dio de alta.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se realizo el alta del autor.");
		}
	}
	
	public void darBaja(int id) {
		try {
			daoAutor.actualizarAlta(id, false);
			System.out.println("Se dio de baja.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se realizo la baja del autor.");
		}
	}
	
	public void imprimirLista(List<Autor> listaRecibida) {
		System.out.println("AUTOR(ES)");
		System.out.printf("%-4s %-50s %-10s\n", "ID", "Nombre", "Alta");
		for (Autor autor : listaRecibida) {
			System.out.println(autor.toString());
		}
	}
}
