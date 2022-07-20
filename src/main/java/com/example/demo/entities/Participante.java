package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Participante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellidos;
	private String cedula;
	private String ciudadania;
	private String edad;
	private String genero;
	private String numeroEmergencia;
	private String email;
	private String telefono;
	private String domicilio;
	private String tipoSangre;
	private String talla;
	private String categoria;
	private String team;
	private String codigo;
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	public Participante(Long id, String nombre, String apellidos, String cedula, String ciudadania, String edad,
			String genero, String numeroEmergencia, String email, String telefono, String domicilio, String tipoSangre,
			String talla, String categoria, String team, Evento evento, String codigo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.ciudadania = ciudadania;
		this.edad = edad;
		this.genero = genero;
		this.numeroEmergencia = numeroEmergencia;
		this.email = email;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.tipoSangre = tipoSangre;
		this.talla = talla;
		this.evento = evento;
		this.codigo = codigo;
	}

	public Participante() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getNumeroEmergencia() {
		return numeroEmergencia;
	}

	public void setNumeroEmergencia(String numeroEmergencia) {
		this.numeroEmergencia = numeroEmergencia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCiudadania() {
		return ciudadania;
	}

	public void setCiudadania(String ciudadania) {
		this.ciudadania = ciudadania;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
