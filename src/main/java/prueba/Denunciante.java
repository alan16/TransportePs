package prueba;

// Generated 23-jul-2015 20:36:17 by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Denunciante generated by hbm2java
 */
@Entity
@Table(name = "denunciante")
public class Denunciante implements java.io.Serializable {

	private int idDenunciante;
	private Region region;
	private String apenom;
	private Integer dni;
	private String genero;
	private String domicilio;
	private String detalle;
	private Set<Formulario> formularios = new HashSet<Formulario>(0);

	public Denunciante() {
	}

	public Denunciante(int idDenunciante, Region region) {
		this.idDenunciante = idDenunciante;
		this.region = region;
	}

	public Denunciante(int idDenunciante, Region region, String apenom,
			Integer dni, String genero, String domicilio, String detalle,
			Set<Formulario> formularios) {
		this.idDenunciante = idDenunciante;
		this.region = region;
		this.apenom = apenom;
		this.dni = dni;
		this.genero = genero;
		this.domicilio = domicilio;
		this.detalle = detalle;
		this.formularios = formularios;
	}

	@Id
	@Column(name = "idDenunciante", unique = true, nullable = false)
	public int getIdDenunciante() {
		return this.idDenunciante;
	}

	public void setIdDenunciante(int idDenunciante) {
		this.idDenunciante = idDenunciante;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Region_idRegion", nullable = false)
	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Column(name = "apenom", length = 45)
	public String getApenom() {
		return this.apenom;
	}

	public void setApenom(String apenom) {
		this.apenom = apenom;
	}

	@Column(name = "dni")
	public Integer getDni() {
		return this.dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	@Column(name = "genero", length = 45)
	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Column(name = "domicilio", length = 45)
	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	@Column(name = "detalle", length = 45)
	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "denunciante")
	public Set<Formulario> getFormularios() {
		return this.formularios;
	}

	public void setFormularios(Set<Formulario> formularios) {
		this.formularios = formularios;
	}

}