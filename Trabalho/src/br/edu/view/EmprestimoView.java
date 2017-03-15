package br.edu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.controller.Controller;
import br.edu.model.GBC;

public class EmprestimoView extends JFrame {

	private Controller control;
	
	private JPanel pnBorder = new JPanel();
	private JPanel pnGridBag = new JPanel();
	private JPanel pnFlow = new JPanel();
	
	private JLabel lbInforma = new JLabel("Informe o c�digo livro:");
	private JLabel lbQuantidade = new JLabel("Quantidade de exemplares:");
	
	private JTextField txInforme = new JTextField(5);
	private JTextField txQuantidade = new JTextField(5);
	
	private JButton btInsere = new JButton("Emprestar");
	private JButton btVoltar = new JButton("Voltar");
	
	public EmprestimoView(Controller control) {
		this.control = control;
	}
	
	public void init(){
		tela();
		addgbc();
		eventButtonVoltar();
		eventButtonEmprestar();
	}
	
	public void tela(){
		pnBorder.setLayout(new BorderLayout());
		pnGridBag.setLayout(new GridBagLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnGridBag,BorderLayout.CENTER);
		pnBorder.add(pnFlow,BorderLayout.SOUTH);
		setPreferredSize(new Dimension(400,200));
		setTitle("Empr�stimo - Publica��es");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
	}
	
	public void addgbc(){
		GBC gbc1 = new GBC(1,1);
		GBC gbc2 = new GBC(1,2);
		
		GBC gbc3 = new GBC(2,1);
		GBC gbc4 = new GBC(2,2);
		
		pnGridBag.add(lbInforma,gbc1);
		pnGridBag.add(lbQuantidade,gbc2);
		pnGridBag.add(txInforme,gbc3);
		pnGridBag.add(txQuantidade,gbc4);
		
		pnFlow.add(btInsere);
		pnFlow.add(btVoltar);
		
	}
	
	public void eventButtonVoltar(){
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		};
		btVoltar.addActionListener(voltar);
	}
	
	public void voltar(){
		control.qtdToFunc();
	}
	
	public void eventButtonEmprestar(){
		ActionListener emprestar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				emprestar();
			}
		};
		btInsere.addActionListener(emprestar);
	}
	
	public void emprestar(){
		if(txInforme.getText().isEmpty() || txQuantidade.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos acima");
		}else{
			int cod = Integer.parseInt(txInforme.getText());
			int qtd = Integer.parseInt(txQuantidade.getText());
			control.emprestar(cod,qtd);
		}
	}
	
}
