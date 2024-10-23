package com.soca.servicios;

import com.soca.persistencia.EditorialDAO;

public class EditorialServicio {
	private final EditorialDAO daoEditorial;
	
	public EditorialServicio() {
		this.daoEditorial = new EditorialDAO();
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
}
