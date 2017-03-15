package br.edu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.edu.controller.Controller;
import br.edu.model.Usuario;


public class CadastroUsuarioView extends JFrame {

	private Controller control;
	private GridBagConstraints lbUserCon = new GridBagConstraints();
	private GridBagConstraints lbPassCon = new GridBagConstraints();
	private GridBagConstraints txUserCon = new GridBagConstraints();
	private GridBagConstraints txPassCon = new GridBagConstraints();
	private int tipo;
	
	private JRadioButton funcionario , usuario;
	
	private ButtonGroup buttonGroup;
			
	private JList<Usuario> listStudent = new JList<Usuario>();
	
	private JPanel pnGridBag = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnFlow = new JPanel();
	private JPanel pnList = new JPanel();
	
	private JLabel lbUser = new JLabel("Usuário:");
	private JLabel lbPass = new JLabel("Senha:");
	
	private JTextField txUser = new JTextField(10);
	private JPasswordField txPass =  new JPasswordField(10);
	
	private JButton btJoin = new JButton("Cadastrar");
	private JButton btVoltar = new JButton("Voltar");
	private JButton btExit = new JButton("Sair");
	
	public CadastroUsuarioView(Controller control){
		this.control = control;
	}
	
	public void init(){
		tela();
		button();
		gbc();
		addGbc();
		eventButton();
	}

	public void myRadioBox(){
		
		//Criando os JCheckBox
		usuario = new JRadioButton("Usuário",false);
		funcionario = new JRadioButton("Funcionário",true);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(usuario);
		buttonGroup.add(funcionario);
		
		usuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				tipo = 1;
			}
		});
		
		//Adicionando os JCheckBox no Layout
		pnFlow.add(funcionario);
		pnFlow.add(usuario);
		
		RadioButtonHandler handler = new RadioButtonHandler();
		usuario.addItemListener(handler);
		funcionario.addItemListener(handler);
	}
	
	public void tela() {
		pnGridBag.setLayout(new GridBagLayout());
		pnBorder.setLayout(new BorderLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnGridBag,BorderLayout.NORTH);
		pnBorder.add(pnList,BorderLayout.SOUTH);
		pnBorder.add(pnFlow, FlowLayout.CENTER);
		setPreferredSize(new Dimension(400,200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setTitle("Cadastro de Clientes");
		setResizable(false);
		myRadioBox();
	}

	public class RadioButtonHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent event) {
			if(usuario.isSelected()){
				tipo = 1;
			}else{	
				 tipo = 2;
			}	
		}
	}
		
	public void mostra() {
		setVisible(true);
	}
	
	public void gbc(){
		lbUserCon.gridx = 0;
		lbUserCon.gridy = 0;
		lbUserCon.insets = new Insets(5,5,5,5);
		
		lbPassCon.gridx = 0;
		lbPassCon.gridy = 1;
		lbPassCon.insets = new Insets(5,5,5,5);
				
		txUserCon.gridx = 1;
		txUserCon.gridy = 0;
		
		txPassCon.gridx = 1;
		txPassCon.gridy = 1;		
	}
	
	public void addGbc(){
		pnGridBag.add(lbUser,lbUserCon);
		pnGridBag.add(txUser, txUserCon);
		
		pnGridBag.add(lbPass, lbPassCon);
		pnGridBag.add(txPass, txPassCon);
	}
	
	public void button(){
		pnList.add(btJoin);
		pnList.add(btVoltar);
		pnList.add(btExit);
	}
		
	public void eventButton(){
		buttonExit();
		buttonJoin();
		buttonVoltar();
	}

	private void buttonVoltar() {
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					voltar();
			}
		};
		btVoltar.addActionListener(voltar);
	}

	private void buttonJoin() {
		ActionListener join = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					join();
			}
		};
		btJoin.addActionListener(join);
	}

	private void buttonExit() {
		ActionListener exit = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					exit();
			}
		};
		btExit.addActionListener(exit);
	}
		
	public void exit(){
		control.exit();
	}
	
	public void join(){
		if(txPass.getPassword().length==0 || txUser.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Preencha os campos acima!");
			return;
		}else{
			int x,y;
			x = txUser.getText().length();
			y = txPass.getText().length();
			if(x <= 7 || y <= 7){
				JOptionPane.showMessageDialog(null,"Caracteres de 1 a 7");
				return;
			}else{
				String password = txPass.getText();
				String name = txUser.getText();
				
				Usuario usuario = new Usuario(name,password,tipo);
				control.join(usuario,name);
			}
		}	
	}
		
	public void clearFields(){
		this.txUser.setText("");
		this.txPass.setText("");
	}
	
	public void voltar(){
		control.CadastroToAdm();
	}
	
}
