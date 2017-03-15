package br.edu.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.edu.model.LivroModel;
import br.edu.model.Livros;
import br.edu.model.Usuario;
import br.edu.model.UsuarioModel;
import br.edu.model.XMLDAO;
import br.edu.model.XMLDAO2;
import br.edu.view.AdmView;
import br.edu.view.CadastroLivrosView;
import br.edu.view.CadastroUsuarioView;
import br.edu.view.DevolucaoView;
import br.edu.view.FuncionarioView;
import br.edu.view.LivroView;
import br.edu.view.LoginView;
import br.edu.view.PagamentoView;
import br.edu.view.EmprestimoView;
import br.edu.view.UsuarioView;

public class Controller {
	private LoginView loginview = new LoginView(this);
	private AdmView admView = new AdmView(this); 
	private CadastroUsuarioView cadastroview = new CadastroUsuarioView(this);
	private UsuarioView usuarioview = new UsuarioView(this);
	private FuncionarioView funcionarioview = new FuncionarioView(this);
	private CadastroLivrosView cadastrolivrosview = new CadastroLivrosView(this);
	private EmprestimoView emprestimoview = new EmprestimoView(this);
	private LivroView livroview = new LivroView(this);
	private DevolucaoView devolucaoview = new DevolucaoView(this);
	private PagamentoView pagamentoview = new PagamentoView(this);
	
	private Usuario usuario;
	private XMLDAO dao;
	private XMLDAO2 dao2;
	
	private ArrayList<Usuario> list = new ArrayList<Usuario>();
	private ArrayList<Livros> lista = new ArrayList<Livros>();
	
	
	public void inicia(){
		dao2 = new XMLDAO2("livros.xml");
		dao = new XMLDAO("usuarios.xml");
		loginview.init();
		
		admView.start();
		admView.setVisible(false);
		
		cadastroview.init();
		cadastroview.setVisible(false);
		
		usuarioview.init();
		usuarioview.setVisible(false);
		
		funcionarioview.init();
		funcionarioview.setVisible(false);
		
		cadastrolivrosview.init();
		cadastrolivrosview.setVisible(false);
		
		emprestimoview.init();
		emprestimoview.setVisible(false);
		
		livroview.init();
		livroview.setVisible(false);
		
		devolucaoview.init();
		devolucaoview.setVisible(false);
		
		pagamentoview.init();
		pagamentoview.setVisible(false);
	}
	
	public void login(String user, String pass){
		UsuarioModel model = new UsuarioModel();
		if(model.checkUserAdim(user, pass)) {
			loginview.setVisible(false);
			admView.setVisible(true);			
		} else {
			Usuario usuario = model.checkUser(user, pass);
			if(usuario != null) {
				loginview.setVisible(false);
				
				if(usuario.getTipos() == 1){
					usuarioview.setVisible(true);
					return;
				}
				
				funcionarioview.setVisible(true);
				
			} else {
				loginview.showMessageLabel("Usuario e senha inválidos!");
			}
		}
	}
	
	public void join(Usuario usuario,String name){
		int resposta;
		resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente cadastrar?");
		if(resposta == JOptionPane.YES_OPTION){
			try {
				UsuarioModel model = new UsuarioModel();
				Usuario usr = model.checkUsuario(name);
				if(usr!=null){
					JOptionPane.showMessageDialog(null, "Usuário já existente");
				}else{
					dao.saveToFile(usuario);
					JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso!");
					cadastroview.clearFields();					
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro ao salvar o arquivo");
				return;
			}
		}
	}
	
	public void cadastrarLivro(Livros livro,int cod){
		int resposta;
		resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente cadastrar?");
		if(resposta == JOptionPane.YES_OPTION){
			try {
				LivroModel model = new LivroModel();
				Livros book = model.checkLivro(cod);
				if(book!=null){
					JOptionPane.showMessageDialog(null,"Código já existente");
				}else{
					dao2.saveToFile(livro);
					JOptionPane.showMessageDialog(null,"Livro cadastrado com sucesso!");
					cadastrolivrosview.clearField();					
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro ao salvar o arquivo");
			}
		}
	}
	
	public void cadastroLivro(){
		funcionarioview.setVisible(false);
		cadastrolivrosview.setVisible(true);
	}
	
	public void cadastroUser(){
		admView.setVisible(false);
		cadastroview.setVisible(true);
	}
	
	public void exit(){
		int resposta;
		resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente sair?");
		if(resposta == JOptionPane.YES_OPTION){
			System.exit(0);
		}else{
			return;
		}	
	}
	
	public void AdmToLogin(){
		admView.setVisible(false);
		loginview.loginClearField();
		loginview.setVisible(true);
	}
	
	public void tipos(int tipo){
		usuario.setTipos(tipo);
	}
	
	public void CadastroToAdm(){
		cadastroview.setVisible(false);
		admView.setVisible(true);
	}
	
	public void UsuarioToLogin(){
		usuarioview.setVisible(false);
		loginview.loginClearField();
		loginview.setVisible(true);
	}
	
	public void funcionarioToLogin(){
		funcionarioview.setVisible(false);
		loginview.loginClearField();
		loginview.setVisible(true);
	}
	
	public void LivrosToFunc(){
		cadastrolivrosview.setVisible(false);
		funcionarioview.setVisible(true);
	}
	
	public void FuncToQtd(){
		funcionarioview.setVisible(false);
		emprestimoview.setVisible(true);
	}
	
	public void qtdToFunc(){
		emprestimoview.setVisible(false);
		funcionarioview.setVisible(true);
	}
	
	public void DevolucaoToFun(){
		devolucaoview.setVisible(false);
		funcionarioview.setVisible(true);
	}
	
	public void consultarLivros(){
		usuarioview.setVisible(false);
		livroview.setVisible(true);
	}
	
	public void FuncToDevolucao(){
		funcionarioview.setVisible(false);
		devolucaoview.setVisible(true);
	}
	
	public void livroToUser(){
		livroview.setVisible(false);
		usuarioview.setVisible(true);
	}
	
	public void emprestar(int cod,int qtd){
		LivroModel model = new LivroModel();
		
		Livros livro = model.checkLivro(cod);
		if(livro!=null){
			if(qtd > livro.getQuantidade()){
				JOptionPane.showMessageDialog(null,"Valor inválido");
			}else{				
				livro.setQuantidade(livro.getQuantidade()-qtd);
				JOptionPane.showMessageDialog(null,"Empréstimo realizado com sucesso!");			
			}
		}else{
			JOptionPane.showMessageDialog(null,"Codigo não encontrado");
		}
	}
	
	public void devolucao(int cod,int qtd){
		LivroModel model = new LivroModel();
		Livros livro = model.checkLivro(cod);
		if(livro!=null){
			if(qtd > livro.getQuantidade()){
				JOptionPane.showMessageDialog(null,"Valor inválido!");				
			}else{
				livro.setQuantidade(livro.getQuantidade()+qtd);
				JOptionPane.showMessageDialog(null,"Devolução realizada com sucesso!");											
			}
		}else{			
			JOptionPane.showMessageDialog(null,"Codigo não encontrado");				
		}
	}

	public void FuncToPagamento() {
		funcionarioview.setVisible(false);
		pagamentoview.setVisible(true);
	}

	public void PagamentoToFunc() {
		pagamentoview.setVisible(false);
		funcionarioview.setVisible(true);
	}

	public void pagamento(String user) {
		UsuarioModel model = new UsuarioModel();
		Usuario usr = model.checkUsuario(user);
		if(usr!=null){
			JOptionPane.showMessageDialog(null,"Pagamento realizado com sucesso");
		}else{
			JOptionPane.showMessageDialog(null,"Usuário não encontrado");
		}
	}
}
