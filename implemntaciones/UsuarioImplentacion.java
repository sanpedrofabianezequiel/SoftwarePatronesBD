package com.curso.java.implemntaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso.java.entidades.Usuarios;
import com.curso.java.interfaces.Constantes;
import com.curso.java.interfaces.DAO;
import com.curso.java.interfaces.DAOBuscar1;

public class UsuarioImplentacion  implements DAO<Usuarios>,DAOBuscar1<String,Usuarios>{

	private PreparedStatement psBuscar = null;
	private PreparedStatement psInsertar=null;
	private PreparedStatement psEliminar=null;
	private PreparedStatement psActualizar=null;
	private PreparedStatement psListar= null;
	
	//Creamos una CONEXION
	
	private Connection connection=null;
	
	
	
	
	
	
	//Constructor
	public UsuarioImplentacion() {
		//cuando instancio llame al metodo getConnection()
		this.connection= setConnection();
	}
	
	
	@Override
	public Connection setConnection() {
		
		Connection conector=null;
		try {
			 conector= DriverManager.getConnection(Constantes.URL,Constantes.USER,Constantes.CLAVE);
			 System.out.println("Conexion establecida ...." + this.getClass());//Esto devuelve la clase donde se conecto
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conector;
	}
	
	
	
	@Override
	public Usuarios buscar(String correoR) {
		Usuarios usuario=null;
		String query= "SELECT correo,clave FROM usuarios WHERE correo = ? ";
		
		
		try {
			if(this.psBuscar == null){
				this.psBuscar =getConnection().prepareStatement(query);
			}
			
			
			psBuscar.setString(1, correoR);
			
			ResultSet rs= psBuscar.executeQuery();
			
			while (rs.next()) {
				
				String correo= rs.getString("correo");
				String clave= rs.getString("clave");
				
				usuario = new Usuarios(correo, clave);//llenamos los datos en el cosntructor
			
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	
	
	@Override
	public void insertar(Usuarios usuario) {
		String query="INSERT INTO usuarios (correo, clave) VALUES (?,?)";
		
		try {
			if(this.psInsertar == null) {
				this.psInsertar = getConnection().prepareStatement(query);
			}
			
			this.psInsertar.setString(1, usuario.getCorreo());
			this.psInsertar.setString(2, usuario.getClave());
			
			this.psInsertar.execute();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void actualizar(Usuarios usuario) {
		String query= "UPDATE usuarios SET clave = ? WHERE correo= ?";
		
		
			
			try {
				
				if(this.psActualizar == null) {
				this.psActualizar = getConnection().prepareStatement(query);
				}
				
				
				this.psActualizar.setString(1, usuario.getClave());
				this.psActualizar.setString(2, usuario.getCorreo());
				
				
				this.psActualizar.execute();//Ejecutamos la consulta, ya que no devolvemos nada
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
	}

	@Override
	public void eliminar(Usuarios usuario) {
		String query= "DELETE FROM usuarios WHERE correo= ? ";
		
		try {
			if (this.psEliminar==null) {
				
				this.psEliminar = getConnection().prepareStatement(query);
			}
			
			this.psEliminar.setString(1, usuario.getCorreo());
			
			this.psEliminar.execute();//Execute query
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}



	@Override
	public List<Usuarios> listar() {

		String query="SELECT correo, clave FROM usuarios";
		
		ArrayList<Usuarios> listaUsuarios= new ArrayList<Usuarios>();
		
		
		try {
			if (this.psListar == null) {
				this.psListar= getConnection().prepareStatement(query);
			}
			
			ResultSet rs= this.psListar.executeQuery();//Devuelve la lista
			
			while (rs.next()) {
				;
				
				String correo= rs.getString("correo");
				
				String clave= rs.getString("clave");
				
				listaUsuarios.add(new Usuarios(correo,clave));//En cada Iteracion le agrego un OBJETO a la lista
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaUsuarios;
	}

	//------------------------------------------

	public PreparedStatement getPsBuscar() {
		return psBuscar;
	}


	public void setPsBuscar(PreparedStatement psBuscar) {
		this.psBuscar = psBuscar;
	}


	public PreparedStatement getPsInsertar() {
		return psInsertar;
	}


	public void setPsInsertar(PreparedStatement psInsertar) {
		this.psInsertar = psInsertar;
	}


	public PreparedStatement getPsEliminar() {
		return psEliminar;
	}


	public void setPsEliminar(PreparedStatement psEliminar) {
		this.psEliminar = psEliminar;
	}


	public PreparedStatement getPsActualizar() {
		return psActualizar;
	}


	public void setPsActualizar(PreparedStatement psActualizar) {
		this.psActualizar = psActualizar;
	}


	public PreparedStatement getPsListar() {
		return psListar;
	}


	public void setPsListar(PreparedStatement psListar) {
		this.psListar = psListar;
	}


	public Connection getConnection() {
		return connection;
	}


	
	
	
}
