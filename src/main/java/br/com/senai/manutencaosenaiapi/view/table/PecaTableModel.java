package br.com.senai.manutencaosenaiapi.view.table;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.senai.manutencaosenaiapi.entity.Peca;

public class PecaTableModel extends AbstractTableModel {

	private final int QTD_COLUNAS = 3;
	private List<Peca> pecas;
	
	public PecaTableModel(List<Peca> pecas) {
		this.pecas = pecas;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return pecas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return QTD_COLUNAS;
	}
	
	@Override
	public String getColumnName(int column) {
		if(column == 0) {
			return "ID";
		}
		else if(column == 1) {
			return "Descrição";
		}
		else if(column == 2){
			return "QTD";
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	
	public Peca getPor(int rowIndex) {
		return pecas.get(rowIndex);
	}
	
	public void removerPor(int rowIndex) {
		pecas.remove(rowIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(columnIndex == 0) {
			return pecas.get(rowIndex).getId();
		}
		else if(columnIndex == 1) {
			return pecas.get(rowIndex).getDescricao();
		}
		else if(columnIndex == 2) {
			return pecas.get(rowIndex).getQtdEmEstoque();
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	
}
