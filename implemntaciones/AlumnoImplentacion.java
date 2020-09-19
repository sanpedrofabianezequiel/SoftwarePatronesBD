package com.curso.java.implemntaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.curso.java.entidades.Alumno;
import com.curso.java.interfaces.DAO;
import com.curso.java.interfaces.DAOBuscar2;

public class AlumnoImplentacion implements DAO<Alumno>,DAOBuscar2<String,String>{

	private PreparedStatement psBuscar = null;
	private PreparedStatement psInsertar=null;
	private PreparedStatement psEliminar=null;
	private PreparedStatement psActualizar=null;
	private PreparedStatement psListar= null;
	private Connection connection = null;
	
	
	
	public AlumnoImplentacion() {
		
		this.connection = setConnection();
	}
	
	
	@Override
	public Connection setConnection() {
		
		return null;
	}
	
	
	
	@Override
	public String buscar(String TipoDoci, String documento) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insertar(Alumno elemento) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actualizar(Alumno elemento) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminar(Alumno elemento) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Alumno> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
