package com.transporte.ps.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Marca")
public class Marca {

	@Id
	@GeneratedValue(generator = "clave")
	@org.hibernate.annotations.GenericGenerator(name = "clave", strategy = "increment")
	@Column(name = "idMarca")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Marca_idMarca")
	private Set<Movil> moviles;

	public Marca(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Marca(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Marca() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Movil> getMoviles() {
		return moviles;
	}

	public void setMoviles(Set<Movil> moviles) {
		this.moviles = moviles;
	}

}
