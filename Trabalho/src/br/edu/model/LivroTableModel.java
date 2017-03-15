package br.edu.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class LivroTableModel extends DefaultTableModel {

	private ArrayList<Livros> internalList;
	private String[] header = new String[] {"Código","Nome","Autor","Genero","Quantidade"};

	public LivroTableModel(ArrayList<Livros> newList) {
		this.internalList = newList;
	}

	@Override
	public int getRowCount() {
		if (internalList == null) {
			return 0;
		}
		return internalList.size(); // quantidade de objetos/linhas na tabela
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public Object getValueAt(int row, int column) {
		Livros livro = internalList.get(row);
		if (column == 0) {
			return livro.getCodigo();
		} else if (column == 1) {
			return livro.getNome();
		} else if(column == 2) {
			return livro.getAutor();
		}else if(column == 3){
			return livro.getGenero();
		}else{
			return livro.getQuantidade();
		}
	}
}
