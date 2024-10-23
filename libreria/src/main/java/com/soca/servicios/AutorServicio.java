package com.soca.servicios;

import com.soca.persistencia.AutorDAO;

public class AutorServicio {
	private final AutorDAO daoAutor;
	
	public AutorServicio() {
		this.daoAutor = new AutorDAO();
	}
	
	public void guardarAutor(String nombre, Boolean alta) {
		try {
			daoAutor.crearAutor(nombre, alta);
			
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
}
