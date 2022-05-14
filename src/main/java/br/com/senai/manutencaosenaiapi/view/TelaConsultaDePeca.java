package br.com.senai.manutencaosenaiapi.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import br.com.senai.manutencaosenaiapi.view.table.PecaTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

@Component
public class TelaConsultaDePeca extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtFiltro;
	private JTable table;
	
	@Autowired
	private PecaService service;
	
	@Autowired
	private TelaCadastroDePeca telaDeCadastro;

	/**
	 * Create the frame.
	 */
	public TelaConsultaDePeca() {
		setTitle("Tela de Consulta de Peça");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFiltro = new JLabel("Filtro");
		
		edtFiltro = new JTextField();
		edtFiltro.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Peca> pecas = service.listarPor(edtFiltro.getText());
				PecaTableModel model = new PecaTableModel(pecas);
				table.setModel(model);
				TableColumnModel cm = table.getColumnModel();
				cm.getColumn(0).setPreferredWidth(50);
				cm.getColumn(1).setPreferredWidth(500);
				cm.getColumn(2).setPreferredWidth(50);
				table.updateUI();
			}
		});
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaDeCadastro.setVisible(true);
				setVisible(false);
			}
		});
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es para a linha selecionada", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFiltro)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(edtFiltro, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdicionar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblFiltro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPesquisar)
						.addComponent(edtFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdicionar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
				PecaTableModel model = (PecaTableModel)table.getModel();
				Peca pecaSelecionada = model.getPor(linhaSelecionada);
				telaDeCadastro.colocarEmEdicao(pecaSelecionada);
				telaDeCadastro.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
				PecaTableModel model = (PecaTableModel)table.getModel();
				Peca pecaSalva = model.getPor(linhaSelecionada);
				service.removerPor(pecaSalva.getId());
				model.removerPor(linhaSelecionada);
				table.updateUI();
				JOptionPane.showMessageDialog(contentPane, "Peça removida com sucesso!");
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(btnEditar)
					.addGap(18)
					.addComponent(btnExcluir)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnExcluir))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
