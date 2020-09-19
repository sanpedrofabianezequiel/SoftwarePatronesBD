package com.curso.java.Clase10;

import java.util.List;

import javax.swing.JOptionPane;

import com.curso.java.entidades.Usuarios;
import com.curso.java.implemntaciones.UsuarioImplentacion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
    	UsuarioImplentacion usuarioImp= new UsuarioImplentacion();//Me ayuda  buscar usuarios
    	/*usuarioImp.getConnection();*/
    	Usuarios user1= usuarioImp.buscar("user1");
    	
    //	System.out.println(user1);
    	
    //	user1.setClave("9856");//setiamos en el objeto
    //	usuarioImp.actualizar(user1);//Actualizamos el Objeto en la BASE DE DATOS //Persistimos los cambios
    	
    	
    //	Usuarios user2= usuarioImp.buscar("user5");
    //	System.out.println(user2);
    	
    	/*Usuarios userAux= usuarioImp.buscar(JOptionPane.showInputDialog("Usuario a buscar:"));
    	JOptionPane.showMessageDialog(null, userAux);*/
    	
    	
    	String correo= JOptionPane.showInputDialog(null, "Correo Usuario nuevo: ");
    	String clave= JOptionPane.showInputDialog("Clave nueva");
    	
    	
  	
    	usuarioImp.insertar(new Usuarios(correo,clave));
    	
    	
    	//usuarioImp.eliminar(new Usuarios(correo, clave));
    	
    	List<Usuarios> usuarios= usuarioImp.listar();
    	
    	for (Usuarios var : usuarios) {
			JOptionPane.showMessageDialog(null, var);
		}
    	
    	
    }
}
