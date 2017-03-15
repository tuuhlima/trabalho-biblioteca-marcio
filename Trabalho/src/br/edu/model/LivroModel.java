package br.edu.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LivroModel {
	
	public Livros checkLivro(int cod) {
		XMLDAO2 dao2 = new XMLDAO2("livros.xml");
		ArrayList<Livros> list;
		try {
			list = dao2.readStudents();
			for (Livros livro : list) {
				if (livro.getCodigo() == cod){
					return livro;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
