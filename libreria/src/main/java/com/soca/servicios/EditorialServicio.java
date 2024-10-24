package com.soca.servicios;

import java.util.List;

import com.soca.entidades.Editorial;
import com.soca.persistencia.EditorialDAO;

public class EditorialServicio {
	private final EditorialDAO daoEditorial;
	
	public EditorialServicio() {
		this.daoEditorial = new EditorialDAO();
	}
	
	public Editorial encontrarEditorialID(int id) {
		Editorial editorial = null;
		try {
			editorial = daoEditorial.buscarEditorialID(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se encontro la editorial.");
		}
		return editorial;
	}
	
	public void listarPorNombre(String nombre) {
		try {
			List<Editorial> editorial = daoEditorial.buscarNombre(nombre);
			imprimirLista(editorial);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se listo la editorial.");
		}
	}
	
	public void guardarEditorial(String nombre, Boolean alta) {
		try {
			daoEditorial.crearEditorial(nombre, alta);
			System.out.println("Se añadio la editorial con exito.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se guardo la editorial.");
		}
	}
	
	public void darAlta(int id) {
		try {
			daoEditorial.actualizarAlta(id, true);
			System.out.println("Se dio de alta.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se realizo el alta de la editorial.");
		}
	}
	
	public void darBaja(int id) {
		try {
			daoEditorial.actualizarAlta(id, false);
			System.out.println("Se dio de baja.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se realizo la baja de la editorial.");
		}
	}
	
	public void imprimirLista(List<Editorial> listaRecibida) {
		System.out.println("EDITORIAL(ES)");
		System.out.printf("%-4s %-50s %-10s\n", "ID", "Nombre", "Alta");
		for (Editorial editorial : listaRecibida) {
			System.out.println(editorial.toString());
		}
	}
}
