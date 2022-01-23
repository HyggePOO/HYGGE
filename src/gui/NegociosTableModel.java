package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import data.NegocioBusqueda;



@SuppressWarnings("serial")
public class NegociosTableModel extends AbstractTableModel {
	protected ArrayList<NegocioBusqueda> negocios1;
	
	protected String [] nomColumna = new String []{
			"Destino","Categoria","Ubicacion"
	};
	
	@SuppressWarnings("rawtypes")
	protected Class[] classColumna = new Class[] {
		String.class,String.class,String.class
	};
	
	public NegociosTableModel(ArrayList<NegocioBusqueda>negocios) {
		this.negocios1=negocios;
	}
	
	@Override
	public int getRowCount() {
		return this.negocios1.size();
	}

	@Override
	public int getColumnCount() {
		return this.nomColumna.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		NegocioBusqueda n=(NegocioBusqueda) this.negocios1.get(rowIndex);
		switch(columnIndex) {
		case 0:return n.getNombre();
		case 1:return n.getCategoriaFuncion();
		case 2:return n.getCiudad();
		default:return null;
		}
		
	}
	
	public String getColumnName(int col) {
		return nomColumna[col];
	}
	
}