package br.edu.model;

import java.util.ArrayList;

public class UsuarioModel {

	private String login = "admin";
	private String password = "admin";

	public boolean checkUserAdim(String user, String pass) {
		if (user.equals(login) && pass.equals(password)) {
			return true;
		}
		return false;
	}

	public Usuario checkUser(String user, String pass) {
			XMLDAO dao = new XMLDAO("usuarios.xml");
			ArrayList<Usuario> list;
			try {
				list = dao.readStudents();
				for (Usuario usr : list) {
					if (usr.getUsuario().equals(user) && usr.getPassword().equals(pass)) {
						return usr;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
	}
	
	public Usuario checkUsuario(String user) {
		XMLDAO dao = new XMLDAO("usuarios.xml");
		ArrayList<Usuario> list;
		try {
			list = dao.readStudents();
			for (Usuario usr : list) {
				if (usr.getUsuario().equals(user)){
					return usr;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
