package com.soca.servicios;

import com.soca.persistencia.LibroDAO;

public class LibroServicio {
	private final LibroDAO daoLibro;
	
	public LibroServicio() {
		this.daoLibro = new LibroDAO();
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
}
