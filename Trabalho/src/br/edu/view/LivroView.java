package br.edu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.edu.controller.Controller;
import br.edu.model.LivroTableModel;
import br.edu.model.Livros;
import br.edu.model.XMLDAO2;


public class LivroView extends JFrame {

	ArrayList<Livros> newList = new ArrayList<Livros>();
	private Controller control;
	
	private JButton btvoltar = new JButton("Voltar");
	private JButton btSair = new JButton("Sair");
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnFlow = new JPanel();
	
	public LivroView(Controller control) {
		this.control = control;
	}
	
	public void init(){
		tela();
		addButton();
		livro();
		eventVoltar();
		eventSair();
	}
	
	public void tela(){
		LivroTableModel model = new LivroTableModel(newList);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		pnBase.add(scroll);
		pnBorder.setLayout(new BorderLayout());
		pnFlow.setLayout(new FlowLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnBase,BorderLayout.CENTER);
		pnBorder.add(pnFlow, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(480,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Consulta - Livro");
		setResizable(false);
		pack();
	}
	
	public void addButton(){
		pnFlow.add(btvoltar);
		pnFlow.add(btSair);
	}
	
	public void livro(){
		XMLDAO2 dao2 = new XMLDAO2("livros.xml");
		ArrayList<Livros> list = new ArrayList<Livros>();
		try {
			list = dao2.readStudents();
			for (Livros livros : list) {
				newList.add(new Livros(livros.getCodigo(),livros.getNome(),livros.getAutor()
						,livros.getGenero(),livros.getQuantidade()));
			}			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Livro não encontrado");
		}
	}
	
	public void eventVoltar(){
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				volta();
			}
		};
		btvoltar.addActionListener(voltar);
	}
	
	public void volta(){
		control.livroToUser();
	}
	
	public void eventSair(){
		ActionListener sair = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sair();
			}
		};
		btSair.addActionListener(sair);
	}
	
	public void sair(){
		control.exit();
	}
	
}
