package br.edu.model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class UsuarioTableModel extends DefaultListModel<Usuario> {

	private ArrayList<Usuario> internalList = new ArrayList<Usuario>();
	
	public UsuarioTableModel(ArrayList<Usuario> newList){
		internalList = newList;
	}
	
	@Override
	public Usuario getElementAt(int index){
		return internalList.get(index);
	}
	
	@Override
	public int getSize(){
		return internalList.size();
	}
	
}
