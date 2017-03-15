package br.edu.model;

public class Usuario {

	private String usuario;
	private String password;
	private int tipos;
	
	//construtor default
	public Usuario() {
		
	}
	
	public Usuario(String usuario,String password,int tipos) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.tipos = tipos;
	}
	
	public int getTipos() {
		return tipos;
	}

	public void setTipos(int tipos) {
		this.tipos = tipos;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
}
