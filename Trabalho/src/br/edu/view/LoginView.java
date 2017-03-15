package br.edu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.controller.Controller;
import br.edu.model.Usuario;
import br.edu.model.XMLDAO;

public class LoginView extends JFrame {

	private Usuario usuario;
	
	private Controller control;
	private XMLDAO dao;
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public LoginView(Controller control) {
		this.control = control;
	}
	
	private JPanel JBorder = new JPanel();
	private JPanel jGridBag = new JPanel();
	private JPanel JFlow = new JPanel();
	
//	private JLabel labelLogin = new JLabel("Username:");
	private JLabel labelLogin;
	private JLabel labelpassword;
	private JLabel labelaviso = new JLabel("");
	
	private JButton buttonCadastro = new JButton("Entrar");
	private JButton buttonExit = new JButton("Sair");
	
	private JTextField textLogin = new JTextField(10);
	private JPasswordField textPassword = new JPasswordField(10);
	
	private GridBagConstraints lbAvisoCon = new GridBagConstraints();
	private GridBagConstraints lbUserCon = new GridBagConstraints();
	private GridBagConstraints lbPassCon = new GridBagConstraints();
	
	private GridBagConstraints txUserCon = new GridBagConstraints();
	private GridBagConstraints txPassCon = new GridBagConstraints();
	
	public void init(){
		image();
		tela();
		gbcsettings();
		addgbc();
		addButton();
		buttonCadastro();
		buttonExit();
	}
	
	public void tela(){
		JBorder.setLayout(new BorderLayout());
		jGridBag.setLayout(new GridBagLayout());
		JFlow.setLayout(new FlowLayout());
		setTitle("Biblioteca - Acesso");
		setContentPane(JBorder);
		JBorder.add(jGridBag,BorderLayout.CENTER);
		JBorder.add(JFlow,BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setResizable(false);
		setPreferredSize(new Dimension(300,200));
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	
	
	public void gbcsettings(){
		
		lbUserCon.gridx = 0;
		lbUserCon.gridy = 0;
		lbUserCon.insets = new Insets(5,5,5,5);
		
		txUserCon.gridx = 1;
		txUserCon.gridy = 0;
		
		lbPassCon.gridx = 0;
		lbPassCon.gridy = 1;
		lbPassCon.insets = new Insets(5,5,5,5);
		
		txPassCon.gridx = 1;
		txPassCon.gridy = 1;
		
		lbAvisoCon.gridx = 0;
		lbAvisoCon.gridy = 2;
		
	}
	
	public void addgbc(){
		jGridBag.add(labelLogin,lbUserCon);
		jGridBag.add(textLogin,txUserCon);
		
		jGridBag.add(labelpassword,lbPassCon);		
		jGridBag.add(textPassword,txPassCon);
		
		jGridBag.add(labelaviso,lbAvisoCon);
	}
	
	public void addButton(){
		JFlow.add(buttonCadastro);
		JFlow.add(buttonExit);
	}
	
	public void image(){
		
//		jGridBag.setBackground(Color.blue,Color.TRANSLUCENT);
		
		ImageIcon ii = new ImageIcon("Image/user-icon-45917.png");
		Image i = ii.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		labelLogin = new JLabel("Usuário",new ImageIcon(i), JLabel.RIGHT);
		
		ImageIcon ii2 = new ImageIcon("Image/lock.png");
		Image i2 = ii2.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		labelpassword = new JLabel("Senha",new ImageIcon(i2), JLabel.RIGHT);
			
//		JButton bt = new JButton("Clique na casa", new ImageIcon(i));
//		bt.setPreferredSize(new Dimension(300, 50));
//		JFlow.add(bt);
	}
	
	public void buttonExit(){
		
		ActionListener btExit = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controlExit();
			}
		};
		buttonExit.addActionListener(btExit);
	}
	
	public void buttonCadastro(){
		
		ActionListener btcadastro = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlJoin();
			}
		};
		buttonCadastro.addActionListener(btcadastro);
	}

	public void controlJoin(){
		if(textLogin.getText().isEmpty() || textPassword.getPassword().length == 0){
			labelaviso.setText("Preencha os campos!");
		}else{
			labelaviso.setText("");
			control.login(textLogin.getText(), new String(textPassword.getPassword()));
		}
	}

	public void showMessageLabel(String msg) {
		labelaviso.setText(msg);				
	}
	public void loginClearField(){
		textLogin.setText("");
		textPassword.setText("");
	}
	
	public void controlExit(){
		control.exit();
	}
	
}
