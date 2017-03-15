package br.edu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.controller.Controller;
import br.edu.model.GBC;

public class AdmView extends JFrame {

	private JPanel pnGridbag = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnFlow = new JPanel();
	
	
	private Controller control;
	
	public AdmView(Controller control) {
		this.control = control;
	}
	
	private JButton buttonCadastroUser = new JButton("Cadastrar");
	private JButton buttonVoltar = new JButton("Voltar");
	private JButton buttonSair = new JButton("Sair");
	
	public void start(){
		tela();
		addgbc();
		cadastrar();
		functionButtonVoltar();
		functionButtonSair();
	}
	
	public void tela(){
		pnBorder.setLayout(new BorderLayout());
		pnGridbag.setLayout(new GridBagLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnGridbag,BorderLayout.CENTER);
		pnBorder.add(pnFlow,BorderLayout.SOUTH);
		setPreferredSize(new Dimension(400,200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Acesso - Administrador");
		setResizable(false);
		pack();
	}
		
	public void addgbc(){
		GBC gbc1 = new GBC(1,1).setSpan(1,1);
		GBC gbc2 = new GBC(1,2).setSpan(1,1);
		GBC gbc3 = new GBC(1,3).setSpan(1,1);
		
		pnGridbag.add(buttonCadastroUser,gbc1);
		
		pnFlow.add(buttonVoltar);
		pnFlow.add(buttonSair);
	}
	
	public void functionButtonVoltar(){
		
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		};
		buttonVoltar.addActionListener(voltar);
	}
	
	public void functionButtonSair(){
		
		ActionListener sair = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sair();
			}
		};
		buttonSair.addActionListener(sair);
	}
	
	public void sair(){
		control.exit();
	}
	
	public void voltar(){
		control.AdmToLogin();
	}
	
	public void cadastrar(){
		
		ActionListener usuario = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrouser();
			}
		};
		buttonCadastroUser.addActionListener(usuario);
	}
	
	public void cadastrouser(){
		control.cadastroUser();
	}
	
}
