package com.soca.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor")
	private Integer id_autor;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "alta")
	private Boolean alta;

	// Void constructor
	public Autor() {
	}

	// Setters y getters
	public Integer getId_autor() {
		return id_autor;
	}

	public void setId_autor(Integer id_autor) {
		this.id_autor = id_autor;
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
		return String.format("%-4s %-50s %-10s", id_autor, nombre, alta);
	}
}
