package com.curso.java.entidades;

public class Alumno {

	private String tipoDoc;
	private String documento;
	private String razonSocia;
	private byte activo;
	
	
	public Alumno() {
		
		
	}
	
	
	public Alumno(String tipoDoc, String documento, String razonSocia, byte activo) {
		super();
		this.tipoDoc = tipoDoc;
		this.documento = documento;
		this.razonSocia = razonSocia;
		this.activo = activo;
	}
	@Override
	public String toString() {
		return "Alumno [Tipo=" + tipoDoc + ", documento=" + documento + ", razonSocia=" + razonSocia + ", activo="
				+ activo + "]";
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getRazonSocia() {
		return razonSocia;
	}
	public void setRazonSocia(String razonSocia) {
		this.razonSocia = razonSocia;
	}
	public byte getActivo() {
		return activo;
	}
	public void setActivo(byte activo) {
		this.activo = activo;
	}
	
}
