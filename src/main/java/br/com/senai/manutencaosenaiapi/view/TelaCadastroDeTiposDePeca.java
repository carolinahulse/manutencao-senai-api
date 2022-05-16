package br.com.senai.manutencaosenaiapi.view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;
import br.com.senai.manutencaosenaiapi.service.TipoDePecaService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroDeTiposDePeca extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtId;
	private JTextField edtDescricao;
	
	@Autowired
	TipoDePecaService service;

	/**
	 * Create the frame.
	 */
	public TelaCadastroDeTiposDePeca() {
		setTitle("Cadastro de Tipos de Peça");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblId = new JLabel("ID");
		
		edtId = new JTextField();
		edtId.setEnabled(false);
		edtId.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição");
		
		edtDescricao = new JTextField();
		edtDescricao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(edtId.getText() != null && edtId.getText().length() > 0) {
						TipoDePeca tipoDePecaSalva = new TipoDePeca();
						tipoDePecaSalva.setDescricao(edtDescricao.getText());
						tipoDePecaSalva.setId(Integer.parseInt(edtId.getText()));
						service.alterar(tipoDePecaSalva);
						JOptionPane.showMessageDialog(contentPane, "Tipo de peça alterada com sucesso!");
					}
					else {
						TipoDePeca novoTipoDePeca = new TipoDePeca();
						novoTipoDePeca.setDescricao(edtDescricao.getText());
						TipoDePeca tipoDePecaSalva = service.inserir(novoTipoDePeca);
						edtId.setText(tipoDePecaSalva.getId().toString());
						JOptionPane.showMessageDialog(contentPane, "Tipo de peça inserida com sucesso!");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblId)
						.addComponent(edtId, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDescricao)
							.addContainerGap(283, Short.MAX_VALUE))
						.addComponent(edtDescricao, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSalvar))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(lblDescricao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(edtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(edtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addComponent(btnSalvar))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
