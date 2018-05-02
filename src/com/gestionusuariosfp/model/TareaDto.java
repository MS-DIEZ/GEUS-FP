package com.gestionusuariosfp.model;

public class TareaDto {
	
	private String nombreTarea;
	private String descripcionTarea;
	private int emisorTarea;
	private int idTarea;
	
	public String getNombreTarea() {
		return nombreTarea;
	}
	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
	public String getDescripcionTarea() {
		return descripcionTarea;
	}
	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}
	public int getEmisorTarea() {
		return emisorTarea;
	}
	public void setEmisorTarea(int emisorTarea) {
		this.emisorTarea = emisorTarea;
	}
	public int getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}

}
