package br.edu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.controller.Controller;
import br.edu.model.GBC;
import br.edu.model.Usuario;
import br.edu.model.XMLDAO;

public class FuncionarioView extends JFrame {

	private Usuario usuario;
	
	private Controller control;
	private XMLDAO dao;
	private EmprestimoView emprestimoview;
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	private JPanel jGridBag = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnFlow = new JPanel();
		
	private JButton buttonCadastroLivros = new JButton("Cadastrar livros");
	private JButton buttonEmprestimo = new JButton("Realizar empréstimo");
	private JButton buttonDevolucao = new JButton("Realizar devolução");
	private JButton buttonPagamento = new JButton("Registrar pagamento");
	private JButton buttonVoltar = new JButton("Voltar");
	private JButton buttonExit = new JButton("Sair");
		
	public FuncionarioView(Controller control) {
		this.control = control;
	}
	
	public void init(){
		tela();
		gbcsettings();
		eventButtonVoltar();
		eventButtonSair();
		eventCadastrarLivros();
		eventCadastrarQuantidade();
		eventDevolucao();
		eventButtonPagamento();
	}
	
	public void tela(){
		pnBorder.setLayout(new BorderLayout());
		pnFlow.setLayout(new FlowLayout());
		jGridBag.setLayout(new GridBagLayout());
		setContentPane(pnBorder);
		pnBorder.add(jGridBag,BorderLayout.CENTER);
		pnBorder.add(pnFlow,BorderLayout.SOUTH);
		setTitle("Acesso - Funcionário");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setResizable(false);
		setPreferredSize(new Dimension(400,300));
		setLocationRelativeTo(null);
		pack();
	}
	
	public void gbcsettings(){		
		GBC gbc1 = new GBC(1,1).setSpan(1,1);
		GBC gbc3 = new GBC(1,3).setSpan(1,1);
		GBC gbc4 = new GBC(1,4).setSpan(1,1);
		GBC gbc5 = new GBC(1,5).setSpan(1,1);
		
		jGridBag.add(buttonCadastroLivros,gbc1);
		jGridBag.add(buttonDevolucao,gbc3);
		jGridBag.add(buttonEmprestimo,gbc4);
		jGridBag.add(buttonPagamento,gbc5);
		
		pnFlow.add(buttonVoltar);
		pnFlow.add(buttonExit);
	}
	
	public void eventDevolucao(){
		ActionListener devolucao = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				devolver();
			}
		};
		buttonDevolucao.addActionListener(devolucao);
	}
	
	public void devolver(){
		control.FuncToDevolucao();
	}
	
	public void eventCadastrarQuantidade(){
		ActionListener btEmprestimo = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrarQuantidade();
			}
		};
		buttonEmprestimo.addActionListener(btEmprestimo);
	}
	
	public void cadastrarQuantidade(){
		control.FuncToQtd();
	}
	
	public void eventButtonVoltar(){
		
		ActionListener btvoltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		};
		buttonVoltar.addActionListener(btvoltar);
	}
	
	public void voltar(){
		control.funcionarioToLogin();
	}
	
	public void eventButtonSair(){
		
		ActionListener btSair = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		};
		buttonExit.addActionListener(btSair);
	}
	
	public void sair(){
		control.exit();
	}
	
	public void eventCadastrarLivros(){
		
		ActionListener btCadastroLivro = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrarLivros();
			}
		};
		buttonCadastroLivros.addActionListener(btCadastroLivro);
	}
	
	public void cadastrarLivros(){
		control.cadastroLivro();
	}
	
	public void eventButtonPagamento(){
		ActionListener btPagamento = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pagamento();
			}
		};
		buttonPagamento.addActionListener(btPagamento);
	}
	
	public void pagamento(){
		control.FuncToPagamento();
	}
	
}
