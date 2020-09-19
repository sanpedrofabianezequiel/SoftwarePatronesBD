package com.curso.java.interfaces;

import java.sql.Connection;
import java.util.List;

public interface DAO<E> {//el DAO NO  dbe ser utlizado porlas entidades
	
	
	
	
	//Metodo que inserte
	public void insertar(E elemento);
	public void actualizar(E elemento);
	public void eliminar(E elemento);
	Connection setConnection();
	public List<E> listar();
	
}
