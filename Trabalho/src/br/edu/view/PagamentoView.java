package br.edu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import br.edu.controller.Controller;
import br.edu.model.GBC;

public class PagamentoView extends JFrame {

	private JPanel pnBorder = new JPanel();
	private JPanel pnGridBag = new JPanel();
	private JPanel pnFlow = new JPanel();
	
	private JLabel lbUsuario = new JLabel("Informe o usuário:");
	private JLabel lbDias = new JLabel("Informe dias de atraso:");
	private JLabel lbPagamento = new JLabel("Valor em R$:");
	
	private JTextField txUsuario = new JTextField(8);
	private JTextField txDias = new JTextField(8);
	private JTextField txPagamento = new JTextField(8);
	
	private JButton btPagamento = new JButton("Confirmar pagamento");
	private JButton btVerifica = new JButton("Calculo dos dias");
	private JButton btVoltar = new JButton("Voltar");

	
	private Controller control;
	
	public PagamentoView(Controller control) {
		this.control = control;
	}
	
	public void init(){
		tela();
		addgbc();
		eventButtonVoltar();
		eventButtonPagamento();
		eventButtonVerifica();
	}
	
	public void tela(){
		pnBorder.setLayout(new BorderLayout());
		pnGridBag.setLayout(new GridBagLayout());
		pnFlow.setLayout(new FlowLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnGridBag,BorderLayout.CENTER);
		pnBorder.add(pnFlow, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(400,250));
		setTitle("Acesso - Pagamento");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
	}
	
	public void addgbc() {
		GBC gbc1 = new GBC(1,1);
		GBC gbc2 = new GBC(1,2);
		GBC gbc3 = new GBC(1,3);
		
		GBC gbc4 = new GBC(2,1);
		GBC gbc5 = new GBC(2,2);
		GBC gbc6 = new GBC(2,3);
		
		pnGridBag.add(lbUsuario,gbc1);
		pnGridBag.add(lbDias,gbc2);
		pnGridBag.add(lbPagamento,gbc3);
		
		
		pnGridBag.add(txUsuario,gbc4);
		pnGridBag.add(txDias,gbc5);
		pnGridBag.add(txPagamento,gbc6);
		
		
		pnFlow.add(btPagamento);
		pnFlow.add(btVerifica);
		pnFlow.add(btVoltar);
	}
	
	public void eventButtonVoltar() {
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		};
		btVoltar.addActionListener(voltar);
	}
	
	public void voltar(){
		control.PagamentoToFunc();
	}
		
	public void eventButtonPagamento() {
		ActionListener pagamento = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pagamento();
			}
		};
		btPagamento.addActionListener(pagamento);
	}
	
	public void pagamento(){
		if(txUsuario.getText().isEmpty() || txDias.getText().isEmpty() || txPagamento.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos acima");
		}else{
			String user = txUsuario.getText();
			control.pagamento(user);
		}
	}
	
	public void eventButtonVerifica() {
		ActionListener verifica = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				verifica();
			}
		};
		btVerifica.addActionListener(verifica);
	}
	
	public void verifica(){
		if(txDias.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Informe os dias");
		}else{
			int valor = 3;
			int x = Integer.parseInt(txDias.getText()); 
			txPagamento.setText(""+x*valor+",00");
		}
	}
	
}
