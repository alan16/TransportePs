package com.transporte.ps.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movil")
public class Movil {

	@Id
	@Column(name = "tuc")
	private Integer tuc;
	@Column(name = "num_chasis")
	private Integer chasis;
	@Column(name = "num_motor")
	private Integer motor;
	@Column(name = "num_patente")
	private Integer patente;
	@Column(name = "observacion")
	private String observacion;
	@Column(name = "anio")
	private Date anio;
	@ManyToOne
	@JoinColumn(name = "Tipo_idTipo")
	private Tipo tipo;
	@ManyToOne
	@JoinColumn(name = "Marca_idMarca")
	private Marca marca;
	@ManyToOne
	@JoinColumn(name = "Modelo_idModelo")
	private Modelo modelo;

	public Movil(Integer tuc, Integer chasis, Integer motor, Integer patente,
			String observacion, Date anio) {
		super();
		this.tuc = tuc;
		this.chasis = chasis;
		this.motor = motor;
		this.patente = patente;
		this.observacion = observacion;
		this.anio = anio;
	}

	public Integer getTuc() {
		return tuc;
	}

	public void setTuc(Integer tuc) {
		this.tuc = tuc;
	}

	public Integer getChasis() {
		return chasis;
	}

	public void setChasis(Integer chasis) {
		this.chasis = chasis;
	}

	public Integer getMotor() {
		return motor;
	}

	public void setMotor(Integer motor) {
		this.motor = motor;
	}

	public Integer getPatente() {
		return patente;
	}

	public void setPatente(Integer patente) {
		this.patente = patente;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getAnio() {
		return anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

}
