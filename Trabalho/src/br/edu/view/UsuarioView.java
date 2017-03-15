package br.edu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
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

public class UsuarioView extends JFrame {

	private Usuario usuario;
	
	private Controller control;
	private XMLDAO dao;
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioView(Controller control) {
		this.control = control;
	}
	
	private JPanel jGridBag = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnFlow = new JPanel();
		
	private JButton buttonConsulta = new JButton("Consultar disponibilidade livros");
	private JButton buttonAtraso = new JButton("Consultar itens em atraso e multas");
	private JButton buttonVoltar = new JButton("Voltar");
	private JButton buttonExit = new JButton("Sair");
		
	public void init(){
		tela();
		gbcsettings();
		eventButtonVoltar();
		eventButtonSair();
		eventButtonConsulta();
	}
	
	public void tela(){
		pnBorder.setLayout(new BorderLayout());
		pnFlow.setLayout(new FlowLayout());
		jGridBag.setLayout(new GridBagLayout());		
		setContentPane(pnBorder);
		pnBorder.add(jGridBag,BorderLayout.CENTER);
		pnBorder.add(pnFlow,BorderLayout.SOUTH);
		setTitle("Acesso - Usuário");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setResizable(false);
		setPreferredSize(new Dimension(400,200));
		setLocationRelativeTo(null);
		pack();
	}
	
	public void gbcsettings(){		
		GBC gbc1 = new GBC(1,1).setSpan(1,1);
		GBC gbc2 = new GBC(1,2).setSpan(1,1);
		
		jGridBag.add(buttonConsulta,gbc1);
		jGridBag.add(buttonAtraso,gbc2);
		
		pnFlow.add(buttonVoltar);
		pnFlow.add(buttonExit);
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
		control.UsuarioToLogin();
	}
	
	public void eventButtonSair(){
		
		ActionListener btExit = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					sair();
			}
		};
		buttonExit.addActionListener(btExit);
	}
	
	public void sair(){
		control.exit();
	}
	
	public void eventButtonConsulta(){
		ActionListener consulta = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				consulta();
			}
		};
		buttonConsulta.addActionListener(consulta);
	}
	
	public void consulta(){
		control.consultarLivros();
	}
	
}