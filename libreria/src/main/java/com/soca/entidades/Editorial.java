package com.soca.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "editorial")
public class Editorial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_editorial")
	private Integer id_editorial;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "alta")
	private Boolean alta;

	// Void constructor
	public Editorial() {
	}

	// Setters y getters
	public Integer getId_editorial() {
		return id_editorial;
	}

	public void setId_editorial(Integer id_editorial) {
		this.id_editorial = id_editorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

	@Override
	public String toString() {
		return String.format("%-4s %-50s %-10s", id_editorial, nombre, alta);
	}
}
