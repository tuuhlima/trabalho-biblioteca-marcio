package br.edu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.oracle.jrockit.jfr.client.EventSettingsBuilder;

import br.edu.controller.Controller;
import br.edu.model.GBC;
import br.edu.model.Livros;

public class CadastroLivrosView extends JFrame {

	private JPanel pnFlow = new JPanel();
	private JPanel pnGridBag = new JPanel();
	private JPanel pnBorder = new JPanel();
	
	private Controller control;
	
	private JLabel lbCodigoLivro = new JLabel("Código:");
	private JLabel lbNomeLivro = new JLabel("Nome:");
	private JLabel lbAutorLivro = new JLabel("Autor:");
	private JLabel lbGeneroLivro = new JLabel("Gênero:");
	private JLabel lbQuantidadeLivro = new JLabel("Quantidade:");
	
	private JTextField txCodigoLivro = new JTextField(10);
	private JTextField txNomeLivro = new JTextField(10);
	private JTextField txAutorLivro = new JTextField(10);
	private JTextField txGeneroLivro = new JTextField(10);
	private JTextField txQuantidadeLivro = new JTextField(10);
	
	private JButton btCadastro = new JButton("Cadastrar");
	private JButton btVoltar = new JButton("Voltar");
	
	public CadastroLivrosView(Controller control) {
		this.control = control;
	}
	
	public void init(){
		tela();
		addgbc();
		eventButtonCadastrar();
		eventButtonVoltar();
	}
	
	public void tela(){
		pnBorder.setLayout(new BorderLayout());
		pnGridBag.setLayout(new GridBagLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnGridBag,BorderLayout.CENTER);
		pnBorder.add(pnFlow,BorderLayout.SOUTH);
		setPreferredSize(new Dimension(400,250));
		setTitle("Cadastrar Livros");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
	}
	
	public void addgbc(){
		GBC lbCodigo = new GBC(1,1);
		GBC lbNome = new GBC(1,2);
		GBC lbAutor = new GBC(1,3);
		GBC lbGenero = new GBC(1,4);
		GBC lbQuantidade = new GBC(1,5);
		
		GBC txCodigo = new GBC(2,1);
		GBC txNome = new GBC(2,2);
		GBC txAutor = new GBC(2,3);
		GBC txGenero = new GBC(2,4);
		GBC txQuantidade = new GBC(2,5);
		
		pnGridBag.add(lbCodigoLivro,lbCodigo);
		pnGridBag.add(txCodigoLivro, txCodigo);
		
		pnGridBag.add(lbNomeLivro,lbNome);
		pnGridBag.add(txNomeLivro, txNome);
		
		pnGridBag.add(lbAutorLivro,lbAutor);
		pnGridBag.add(txAutorLivro, txAutor);
		
		pnGridBag.add(lbGeneroLivro,lbGenero);
		pnGridBag.add(txGeneroLivro, txGenero);
		
		pnGridBag.add(lbQuantidadeLivro, lbQuantidade);
		pnGridBag.add(txQuantidadeLivro,txQuantidade);
		
		pnFlow.add(btCadastro);
		pnFlow.add(btVoltar);
		
	}
	
	public void eventButtonCadastrar(){
		ActionListener cadastrar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();	
			}
		};
		btCadastro.addActionListener(cadastrar);
	}
	
	public void cadastrar(){
		if(txCodigoLivro.getText().isEmpty() || txNomeLivro.getText().isEmpty() || txAutorLivro.getText().isEmpty() ||
				txGeneroLivro.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos!");
		}else{
			
			int cod = Integer.parseInt(txCodigoLivro.getText());
			String nome = txNomeLivro.getText();
			String autor = txAutorLivro.getText();
			String genero = txGeneroLivro.getText();
			int quantidade = Integer.parseInt(txQuantidadeLivro.getText());
			
			Livros livro = new Livros(cod, nome, autor, genero,quantidade);
			control.cadastrarLivro(livro,cod);			
		}
	}
	
	public void eventButtonVoltar(){
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		};
		btVoltar.addActionListener(voltar);
	}
	
	public void voltar(){
		control.LivrosToFunc();
	}
	
	public void clearField(){
		txCodigoLivro.setText("");
		txNomeLivro.setText("");
		txAutorLivro.setText("");
		txGeneroLivro.setText("");
		txQuantidadeLivro.setText("");
	}
	
}
