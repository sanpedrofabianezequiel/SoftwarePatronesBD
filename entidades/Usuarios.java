package com.curso.java.entidades;

public class Usuarios {

	private String correo;
	private String clave;
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Usuarios [correo=" + correo + ", clave=" + clave + "]";
	}


	public Usuarios() {
		
	}
	
	
	public Usuarios(String correo, String clave) {
		super();
		this.correo = correo;
		this.clave = clave;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}
