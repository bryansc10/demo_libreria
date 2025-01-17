package com.soca.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "isbn")
	private Integer isbn;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "anio")
	private Integer anio;
	
	@Column(name = "ejemplares")
	private Integer ejemplares;
	
	@Column(name = "alta")
	private Boolean alta;
	
	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;
	
	@ManyToOne
	@JoinColumn(name = "id_editorial")
	private Editorial editorial;

	// Void constructor
	public Libro() {
	}
	
	// Setters y getters
	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return String.format("%-4s %-50s %-5s %-5s %-4s %-50s %-50s", isbn, titulo, anio, ejemplares, alta, autor.getNombre(), editorial.getNombre());
	}
	
	
}
