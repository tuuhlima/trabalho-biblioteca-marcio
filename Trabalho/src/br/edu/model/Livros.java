package br.edu.model;

public class Livros {

	private int codigo;
	private String nome;
	private String autor;
	private String genero;
	private int quantidade;
	
	public Livros(int codigo,String nome,String autor,String genero,int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.autor = autor;
		this.genero = genero;
		this.quantidade = quantidade;
	}
	
	public Livros() {
		
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
}
