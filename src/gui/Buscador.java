package gui;

import businessLogic.AdmUsuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import data.ListaNegocios;
import data.Negocio;
import data.NegocioBusqueda;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


@SuppressWarnings("serial")
public class Buscador extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	
	@SuppressWarnings("unused")
	private JTable table;
	
	@SuppressWarnings("unused")
	private ListaNegocios negocios;
	
	@SuppressWarnings("rawtypes")
	private TableRowSorter trs;
	
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int anchoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int altoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Buscador(final ListaNegocios listaNegocio,final String categoria) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("HYGGE - Buscador");
		setBounds(anchoScreen/16, altoScreen/16, 555, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(255, 99, 71)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 99, 71));
		panel.setForeground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 539, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUSCAR DESTINO:");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setBounds(33, 30, 173, 20);
		panel.add(lblNewLabel);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 86, 519, 324);
		ArrayList<NegocioBusqueda>negocios1 = listaNegocio.getBuscadorBuss();
		
		NegociosTableModel modelo = new NegociosTableModel(negocios1);
		final JTable table = new JTable(modelo);

		JScrollPane sp =new JScrollPane(table);
		sp.setBounds(0, 0, panel_1.getWidth(),panel_1.getHeight());
		panel_1.add(sp);
		panel_1.setVisible(true);
		panel_1.setLayout(null);
		contentPane.add(panel_1);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botonVolver.setBounds(417, 421, 89, 23);
		contentPane.add(botonVolver);
		
		txtBuscar = new JTextField();
		trs = new TableRowSorter(modelo);
		if (categoria == null) {
			txtBuscar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar.getText(), 0,1,2));
				}
			});
		}else{		
			trs.setRowFilter(RowFilter.regexFilter(categoria, 1));
			txtBuscar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					LinkedList<RowFilter<? super String, ? super String>> lista = new LinkedList<RowFilter<? super String, ? super String>>();
					lista.add(RowFilter.regexFilter(categoria, 1));
					lista.add(RowFilter.regexFilter("(?i)"+txtBuscar.getText(), 0,2));
					trs.setRowFilter(RowFilter.andFilter(lista));
					
				}
			});
		}
		table.setRowSorter(trs);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		TableColumn column = null;
		for (int i = 0; i < 2; i++) {
		    column = table.getColumnModel().getColumn(i);
		    if (i == 3) {
		    	column.setPreferredWidth(25);
		    } else if(i == 0) {
		        column.setPreferredWidth(200);
		    }
		txtBuscar.setBounds(166, 25, 266, 28);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JButton botonIr = new JButton("Ir a Destino seleccionado");
		botonIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.isColumnSelected(0) ==  false) {
					JOptionPane.showMessageDialog(null, "Seleccione un destino","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				}else {
					String nombre = (String) table.getValueAt(table.getSelectedRow(), 0);
					Negocio pagina = AdmUsuario.getNegocio(nombre);
					VentanaNegocio vn = new VentanaNegocio(pagina);
					vn.setVisible(true);
				}
			}
		});
		botonIr.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonIr.setBounds(253, 421, 156, 23);
		contentPane.add(botonIr);
		
		 
		}
	}	
}