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

public class XMLDAO2 {

	private String filepath;

	public XMLDAO2(String filepath) {
		this.filepath = filepath;
	}

	public ArrayList<Livros> readStudents() throws Exception {
		return new ArrayList<Livros>(readStudentsMap().values());
	}

	@SuppressWarnings("unchecked")
	private Map<String, Livros> readStudentsMap() throws Exception {
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filepath)));
		Object obj = decoder.readObject();
		decoder.close();
		return (Map<String, Livros>) obj;
	}

	public void saveToFile(Livros livros) throws Exception {
		Map<String, Livros> map;
		try {
			map = readStudentsMap();
		} catch (Exception e) {
			// se deu exception, eu crio um map novo
			map = new HashMap<String,Livros>();
		}
		
		map.put(livros.getNome(),livros);
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
		encoder.writeObject(map);
		encoder.close();
	}
}
