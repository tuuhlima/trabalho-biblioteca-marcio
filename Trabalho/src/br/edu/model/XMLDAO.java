package br.edu.model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XMLDAO {

	private String filepath;

	public XMLDAO(String filepath) {
		this.filepath = filepath;
	}

	public ArrayList<Usuario> readStudents() throws Exception {
		return new ArrayList<Usuario>(readStudentsMap().values());
	}

	@SuppressWarnings("unchecked")
	private Map<String, Usuario> readStudentsMap() throws Exception {
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filepath)));
		Object obj = decoder.readObject();
		decoder.close();
		return (Map<String, Usuario>) obj;
	}

	public void saveToFile(Usuario usuario) throws Exception {
		Map<String, Usuario> map;
		try {
			map = readStudentsMap();
		} catch (Exception e) {
			// se deu exception, eu crio um map novo
			map = new HashMap<String,Usuario>();
		}
		
		map.put(usuario.getUsuario(),usuario);
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
		encoder.writeObject(map);
		encoder.close();
	}
}
