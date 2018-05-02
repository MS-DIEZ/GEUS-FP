package com.gestionusuariosfp.model;

public class UsuarioDto {
	
	private int id;
	private int puesto;
	private String nombre;
	private String apellido;
	private String password;
	private String email;
	private String fechaIncorporacion;
	private Long salario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPuesto() {
		return puesto;
	}
	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFechaIncorporacion() {
		return fechaIncorporacion;
	}
	public void setFechaIncorporacion(String fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}
	public Long getSalario() {
		return salario;
	}
	public void setSalario(Long salario) {
		this.salario = salario;
	}
	

}
