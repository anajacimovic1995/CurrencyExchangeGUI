package rates.gui;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import rates.classes.Rate;

public class RateTableModel extends AbstractTableModel{
	
	private String[] columns = new String[]{"Code", "Abbreviated", "Sales", "Medium", "Purchasable", "Name"};
	
	private LinkedList<Rate> rates;
	
	public RateTableModel(LinkedList<Rate> rates) {
		if(rates==null){
			this.rates = new LinkedList<Rate>();
			return;
		}
		this.rates = rates;
	}
	@Override
	
	public String getColumnName(int column) {
		return columns[column];
	}
	
	@Override
	public int getColumnCount() {
		
		return columns.length;
	}

	@Override
	public int getRowCount() {
		
		return rates.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		Rate r = rates.get(row);
		
		switch(column){
		case 0:
			return r.getCode();
		case 1:
			return r.getAbbreviatedName();
		case 2:
			return r.getSales();
		case 3:
			return r.getMedium();
		case 4:
			return r.getPurchasable();
		case 5:
			return r.getAbbreviatedName();
		}
		return null;
	}
	
	public void refreshTable(LinkedList<Rate> rates){
		if(rates == null)
			return;
		this.rates = rates;
		fireTableDataChanged();
	}

}

