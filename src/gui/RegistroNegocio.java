package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import businessLogic.ManagerDeNegocio;
import businessLogic.Runner;
import data.ListaNegocios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz, Kevin Rincón & Andres Moreno
 * 
 */
@SuppressWarnings("serial")
public class RegistroNegocio extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextPane descripcion;
	private JTextField ciudad;
	public String categoriaUbicacion;
	public String categoriaFuncion;
	private JPasswordField contraseña;
	private JTextField nombreInicio;
	final JLabel imagenPerfil = new JLabel("");
	String ruta1 = "sources/desconocido.jpg";
	String ruta2 = "sources/desconocido.jpg";
	String ruta3 = "sources/desconocido.jpg";
	String ruta4 = "sources/desconocido.jpg";
	String ruta5 = "sources/desconocido.jpg";
	private JTextField direccion;
	
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int anchoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int altoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	
	/**
	 * Create the frame.
	 */
	public RegistroNegocio(final ListaNegocios listaNegocio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(anchoScreen/16, altoScreen/16, 1001, 509);
		setTitle("HYGGE - Registro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre *");
		lblNewLabel_1.setBounds(27, 88, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		nombre = new JTextField();
		nombre.setBounds(27, 113, 131, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("Ciudad *");
		lblNewLabel_3.setBounds(27, 144, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		ciudad = new JTextField();
		ciudad.setToolTipText("");
		ciudad.setBounds(27, 169, 131, 20);
		contentPane.add(ciudad);
		ciudad.setColumns(10);

		
		
		JLabel lblNewLabel_4 = new JLabel("Categoria por Ubicación *");
		lblNewLabel_4.setBounds(216, 80, 150, 14);
		contentPane.add(lblNewLabel_4);
		
		final JRadioButton opEcologico = new JRadioButton("Zona Rural");
		opEcologico.setBounds(216, 101, 109, 23);
		contentPane.add(opEcologico);
		
		final JRadioButton opCiudad = new JRadioButton("Zona Urbana");
		opCiudad.setBounds(216, 129, 109, 23);
		contentPane.add(opCiudad);
		
		final JRadioButton opPlaya = new JRadioButton("Zona Costera");
		opPlaya.setBounds(216, 157, 109, 23);
		contentPane.add(opPlaya);
		
		ButtonGroup categoriasUbicacion = new ButtonGroup();
		categoriasUbicacion.add(opEcologico);
		categoriasUbicacion.add(opCiudad);
		categoriasUbicacion.add(opPlaya);
		 
			
		JLabel lblNewLabel_5 = new JLabel("Categoria por Funcion *");
		lblNewLabel_5.setBounds(389, 80, 150, 23);
		contentPane.add(lblNewLabel_5);
			
		final JRadioButton opHotel = new JRadioButton("Hoteleria");
		opHotel.setBounds(399, 103, 109, 23);
		contentPane.add(opHotel);
			
		final JRadioButton opCultura = new JRadioButton("Cultura");
		opCultura.setBounds(399, 126, 109, 23);
		contentPane.add(opCultura);
			
		final JRadioButton opGastronomia = new JRadioButton("Gastronomia");
		opGastronomia.setBounds(399, 149, 109, 23);
		contentPane.add(opGastronomia);
			
		final JRadioButton opAct = new JRadioButton("Actividades Deportivas");
		opAct.setBounds(399, 172, 167, 23);
		contentPane.add(opAct);
		
		final JRadioButton opExt = new JRadioButton("Deporte Extremo");
		opExt.setBounds(399, 195, 167, 23);
		contentPane.add(opExt);
		 
		final JRadioButton opEco = new JRadioButton("Ecoturismo");
		opEco.setBounds(399, 218, 167, 23);
		contentPane.add(opEco);
		
		ButtonGroup categoriasFuncion = new ButtonGroup();
		categoriasFuncion.add(opHotel);
		categoriasFuncion.add(opCultura);
		categoriasFuncion.add(opGastronomia);
		categoriasFuncion.add(opAct);
		categoriasFuncion.add(opExt);
		categoriasFuncion.add(opEco);
		 
		
		JLabel lblNewLabel_7 = new JLabel("Nombre de Inicio *");
		lblNewLabel_7.setBounds(52, 363, 167, 14);
		contentPane.add(lblNewLabel_7);
		
		nombreInicio = new JTextField();
		nombreInicio.setBounds(52, 387, 150, 20);
		contentPane.add(nombreInicio);
		nombreInicio.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Contrase\u00F1a *");
		lblNewLabel_6.setBounds(280, 362, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		contraseña = new JPasswordField();
		contraseña.setBounds(280, 387, 131, 20);
		contentPane.add(contraseña);
		
		JLabel lblNewLabel_9 = new JLabel("Direccion");
		lblNewLabel_9.setBounds(389, 248, 119, 14);
		contentPane.add(lblNewLabel_9);
		
		direccion = new JTextField();
		direccion.setBounds(389, 268, 150, 20);
		contentPane.add(direccion);
		direccion.setColumns(10);

		 JButton finalizar = new JButton("Terminar Registro");
			finalizar.addActionListener(new ActionListener() {

				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					 if(opEcologico.isSelected()){
						 categoriaUbicacion = "Rural";
					 }else if(opCiudad.isSelected()){
						 categoriaUbicacion = "Urbano";
					 }else if(opPlaya.isSelected()) {
						 categoriaUbicacion = "Costero";
					 }
					 System.out.println(nombre.getText()+ " " + categoriaUbicacion + " " + ciudad.getText());
					 
					 if(opHotel.isSelected()) {
						 categoriaFuncion ="Hotelero";
					 }else if(opCultura.isSelected()) {
						 categoriaFuncion = "Cultural";
					 }else if(opGastronomia.isSelected()) {
						 categoriaFuncion = "Gastronomico";
					 }else if(opAct.isSelected()) {
						 categoriaFuncion = "Actividades";
					 }else if(opExt.isSelected()) {
						 categoriaFuncion = "Deportes Extremos";
					 }else if(opEco.isSelected()) {
						 categoriaFuncion = "Ecoturismo";
					 }
					 
					try {
						if(ManagerDeNegocio.registro(nombreInicio.getText(),nombre.getText(),contraseña.getText(),categoriaUbicacion,categoriaFuncion,ciudad.getText())==true) {
							ManagerDeNegocio.registroNegocio(nombreInicio.getText(),nombre.getText(),contraseña.getText(),0,categoriaUbicacion,categoriaFuncion,ciudad.getText(),direccion.getText());
							ManagerDeNegocio.guardarDescripcion(nombreInicio.getText(),descripcion.getText());
							try {
								Runner.guardar();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ManagerDeNegocio.guardarImagen(ruta1,nombreInicio.getText() + "1");
							ManagerDeNegocio.guardarImagen(ruta2,nombreInicio.getText() + "2");
							ManagerDeNegocio.guardarImagen(ruta3,nombreInicio.getText() + "3");
							ManagerDeNegocio.guardarImagen(ruta4,nombreInicio.getText() + "4");
							ManagerDeNegocio.guardarImagen(ruta5,nombreInicio.getText() + "5");
							Runner.cargar();
							JOptionPane.showMessageDialog(null, "Negocio Registrado","HYGGE",JOptionPane.INFORMATION_MESSAGE);
							InicioNegocio in = new InicioNegocio(listaNegocio);
							in.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Error en el registro, nombre de negocio ya escogido, categoria inexistente o ciudad inexistente","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
							nombre.setText("");
							ciudad.setText("");
							nombreInicio.setText("");
							nombre.requestFocus();
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					RegistroNegocio l = new RegistroNegocio(listaNegocio);
					l.setVisible(true);
					l.dispose();
				}
			});
			finalizar.setBounds(442, 397, 177, 23);
			contentPane.add(finalizar);
			
			JButton botonVolver = new JButton("Volver");
			botonVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InicioNegocio i = new InicioNegocio(listaNegocio);
					i.setVisible(true);
					dispose();
				}
			});
			botonVolver.setBounds(852, 25, 89, 23);
			contentPane.add(botonVolver);
			
			JLabel lblNewLabel_5_1 = new JLabel("A\u00F1adir Im\u00E1genes");
			lblNewLabel_5_1.setBounds(589, 80, 150, 14);
			contentPane.add(lblNewLabel_5_1);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(new Color(255, 99, 71));
			panel.setForeground(new Color(255, 99, 71));
			panel.setBounds(27, 11, 786, 58);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Registro de Negocio");
			lblNewLabel.setBounds(23, 11, 196, 36);
			panel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			
			final JPanel ayuda = new JPanel();
			JLabel lblNewLabel_8 = new JLabel("AYUDA");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_8.setBounds(7, 11, 172, 31);
			ayuda.add(lblNewLabel_8);
			
			JTextPane txtpnNombre = new JTextPane();
			txtpnNombre.setText("- Nombre* : es el nombre del negocio que se mostrar\u00E1 en la p\u00E1gina. \n\n"
					+ "- Nombre de Inicio* : es el nombre con el que usted accederá a su perfil de negocio. (no se podrá cambiar después)");
			txtpnNombre.setBounds(10, 53, 218, 105);
			ayuda.add(txtpnNombre);
			
			JButton botonCerrarAyuda = new JButton("");
			botonCerrarAyuda.setIcon(new ImageIcon("sources/iconos/cerrar.jpg"));
			ImageIcon iconC = new ImageIcon("sources/iconos/cerrar.jpg");
			ImageIcon imagC = new ImageIcon(iconC.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			botonCerrarAyuda.setIcon(imagC);
			botonCerrarAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ayuda.setVisible(false);
				}
			});

			botonCerrarAyuda.setBounds(189, 17, 25, 25);
			ayuda.add(botonCerrarAyuda);
			ayuda.setVisible(false);
			

			JButton botonAyuda = new JButton("");
			botonAyuda.setIcon(new ImageIcon("sources/iconos/help.jpg"));
			ImageIcon iconA = new ImageIcon("sources/iconos/help.jpg");
			ImageIcon imagA = new ImageIcon(iconA.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			botonAyuda.setIcon(imagA);	
			botonAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ayuda.setVisible(true);
				}
			});
			botonAyuda.setBounds(10, 380, 25, 25);
			contentPane.add(botonAyuda);
			ayuda.setBorder(new LineBorder(new Color(0, 0, 0)));
			ayuda.setBackground(Color.LIGHT_GRAY);
			ayuda.setBounds(27, 200, 238, 169);
			contentPane.add(ayuda);
			ayuda.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Descripcion");
			lblNewLabel_2.setBounds(27, 200, 86, 14);
			contentPane.add(lblNewLabel_2);
			
			descripcion = new JTextPane();
	        JScrollPane descripcionScroll = new JScrollPane(descripcion);
	        descripcionScroll = new JScrollPane(descripcion);
	        descripcionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        descripcionScroll.setBounds(27, 225, 267, 127);
	        descripcionScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			descripcion.setBounds(27, 186, 267, 127);
			contentPane.add(descripcionScroll);
			descripcion.setPreferredSize(new Dimension(250, 127));
			
			
			
			final JLabel imagenPrincipal = new JLabel("");
			imagenPrincipal.setBounds(589, 103, 150, 150);
			imagenPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
			final ImageIcon icon= new ImageIcon(getClass().getResource(""));
			ImageIcon imag= new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
			imagenPrincipal.setIcon(imag);
			contentPane.add(imagenPrincipal);
			
			JButton botonSubirArchivo1 = new JButton("Subir archivo Principal");
			botonSubirArchivo1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					subirImg1(e);
					if (ruta1.endsWith("jpg")||ruta1.endsWith("png") ||ruta1.endsWith("gif")||ruta1.endsWith("jpeg")) {
						Image imagen = new ImageIcon(ruta1).getImage();
						ImageIcon icon = new ImageIcon(imagen.getScaledInstance(150,150,Image.SCALE_SMOOTH));
						imagenPrincipal.setIcon(icon);
					}else {
						JOptionPane.showMessageDialog(null, "Escoja un archivo de imagen soportado","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
						ruta1= "sources/desconocido.jpg";
					}

				}
			});
			botonSubirArchivo1.setBounds(589, 256, 150, 44);
			contentPane.add(botonSubirArchivo1);
			
			
			final JLabel imagen2 = new JLabel("");
			imagen2.setBounds(738, 103, 75, 75);
			imagen2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
			final ImageIcon icon2= new ImageIcon(getClass().getResource(""));
			ImageIcon imag2= new ImageIcon(icon2.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
			imagen2.setIcon(imag2);
			contentPane.add(imagen2);
			
			JButton botonSubirArchivo2 = new JButton("Subir archivo 2");
			botonSubirArchivo2.setFont(new Font("Tahoma", Font.PLAIN, 6));
			botonSubirArchivo2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					subirImg2(e);
					if (ruta2.endsWith("jpg")||ruta2.endsWith("png") ||ruta2.endsWith("gif")||ruta2.endsWith("jpeg")) {
						Image imagen = new ImageIcon(ruta2).getImage();
						ImageIcon icon = new ImageIcon(imagen.getScaledInstance(75,75,Image.SCALE_SMOOTH));
						imagen2.setIcon(icon);
					}else {
						JOptionPane.showMessageDialog(null, "Escoja un archivo de imagen soportado","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
						ruta2= "sources/desconocido.jpg";
					}

				}
			});
			botonSubirArchivo2.setBounds(738, 256, 75, 23);
			contentPane.add(botonSubirArchivo2);
			
			
			final JLabel imagen3 = new JLabel("");
			imagen3.setBounds(738, 178, 75, 75);
			imagen3.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
			final ImageIcon icon3= new ImageIcon(getClass().getResource(""));
			ImageIcon imag3= new ImageIcon(icon3.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
			imagen3.setIcon(imag3);
			contentPane.add(imagen3);
			
			JButton botonSubirArchivo3 = new JButton("Subir archivo 3");
			botonSubirArchivo3.setFont(new Font("Tahoma", Font.PLAIN, 6));
			botonSubirArchivo3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					subirImg3(e);
					if (ruta3.endsWith("jpg")||ruta3.endsWith("png") ||ruta3.endsWith("gif")||ruta3.endsWith("jpeg")) {
						Image imagen = new ImageIcon(ruta3).getImage();
						ImageIcon icon = new ImageIcon(imagen.getScaledInstance(75,75,Image.SCALE_SMOOTH));
						imagen3.setIcon(icon);
					}else {
						JOptionPane.showMessageDialog(null, "Escoja un archivo de imagen soportado","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
						ruta3= "sources/desconocido.jpg";
					}

				}
			});
			botonSubirArchivo3.setBounds(738, 277, 75, 23);
			contentPane.add(botonSubirArchivo3);
			
			
			final JLabel imagen4 = new JLabel("");
			imagen4.setBounds(813, 103, 75, 75);
			imagen4.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
			final ImageIcon icon4= new ImageIcon(getClass().getResource(""));
			ImageIcon imag4= new ImageIcon(icon4.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
			imagen4.setIcon(imag4);
			contentPane.add(imagen4);
			
			JButton botonSubirArchivo4 = new JButton("Subir archivo 3");
			botonSubirArchivo4.setFont(new Font("Tahoma", Font.PLAIN, 6));
			botonSubirArchivo4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					subirImg4(e);
					if (ruta4.endsWith("jpg")||ruta4.endsWith("png") ||ruta4.endsWith("gif")||ruta4.endsWith("jpeg")) {
						Image imagen = new ImageIcon(ruta4).getImage();
						ImageIcon icon = new ImageIcon(imagen.getScaledInstance(75,75,Image.SCALE_SMOOTH));
						imagen4.setIcon(icon);
					}else {
						JOptionPane.showMessageDialog(null, "Escoja un archivo de imagen soportado","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
						ruta4= "sources/desconocido.jpg";
					}

				}
			});
			botonSubirArchivo4.setBounds(813, 256, 75, 23);
			contentPane.add(botonSubirArchivo4);
			
			
			final JLabel imagen5 = new JLabel("");
			imagen5.setBounds(813, 178, 75, 75);
			imagen5.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
			final ImageIcon icon5= new ImageIcon(getClass().getResource(""));
			ImageIcon imag5= new ImageIcon(icon5.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
			imagen5.setIcon(imag5);
			contentPane.add(imagen5);
			
			JButton botonSubirArchivo5 = new JButton("Subir archivo 3");
			botonSubirArchivo5.setFont(new Font("Tahoma", Font.PLAIN, 6));
			botonSubirArchivo5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					subirImg5(e);
					if (ruta5.endsWith("jpg")||ruta5.endsWith("png") ||ruta5.endsWith("gif") ||ruta5.endsWith("jpeg")) {
						Image imagen = new ImageIcon(ruta5).getImage();
						ImageIcon icon = new ImageIcon(imagen.getScaledInstance(75,75,Image.SCALE_SMOOTH));
						imagen5.setIcon(icon);
					}else {
						JOptionPane.showMessageDialog(null, "Escoja un archivo de imagen soportado","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
						ruta5= "sources/desconocido.jpg";
					}

				}
			});
			botonSubirArchivo5.setBounds(813, 277, 75, 23);
			contentPane.add(botonSubirArchivo5);
			
	}
	
	private String subirImg1(java.awt.event.ActionEvent avt) {

		JFileChooser jf = new JFileChooser();
		jf.setMultiSelectionEnabled(false);
		FileNameExtensionFilter filtrado = new FileNameExtensionFilter("jpg, png, gif", "jpg","png", "gif","jpeg");
		jf.setFileFilter(filtrado);
		
		int respuesta = jf.showOpenDialog(this);
		
		if(respuesta == JFileChooser.APPROVE_OPTION) {
			ruta1 = jf.getSelectedFile().getPath();
		}
		return ruta1;
		}
	
	private String subirImg2(java.awt.event.ActionEvent avt) {

		JFileChooser jf = new JFileChooser();
		jf.setMultiSelectionEnabled(false);
		FileNameExtensionFilter filtrado = new FileNameExtensionFilter("jpg, png, gif", "jpg","png", "gif","jpeg");
		jf.setFileFilter(filtrado);
		
		int respuesta = jf.showOpenDialog(this);
		
		if(respuesta == JFileChooser.APPROVE_OPTION) {
			ruta2 = jf.getSelectedFile().getPath();
		}
		return ruta2;
		}
	
	private String subirImg3(java.awt.event.ActionEvent avt) {

		JFileChooser jf = new JFileChooser();
		jf.setMultiSelectionEnabled(false);
		FileNameExtensionFilter filtrado = new FileNameExtensionFilter("jpg, png, gif", "jpg","png", "gif","jpeg");
		jf.setFileFilter(filtrado);
		
		int respuesta = jf.showOpenDialog(this);
		
		if(respuesta == JFileChooser.APPROVE_OPTION) {
			ruta3 = jf.getSelectedFile().getPath();
		}
		return ruta3;
		}
	
	private String subirImg4(java.awt.event.ActionEvent avt) {

		JFileChooser jf = new JFileChooser();
		jf.setMultiSelectionEnabled(false);
		FileNameExtensionFilter filtrado = new FileNameExtensionFilter("jpg, png, gif", "jpg","png", "gif","jpeg");
		jf.setFileFilter(filtrado);
		
		int respuesta = jf.showOpenDialog(this);
		
		if(respuesta == JFileChooser.APPROVE_OPTION) {
			ruta4 = jf.getSelectedFile().getPath();
		}
		return ruta4;
		}
	
	private String subirImg5(java.awt.event.ActionEvent avt) {

		JFileChooser jf = new JFileChooser();
		jf.setMultiSelectionEnabled(false);
		FileNameExtensionFilter filtrado = new FileNameExtensionFilter("jpg, png, gif", "jpg","png", "gif","jpeg");
		jf.setFileFilter(filtrado);
		
		int respuesta = jf.showOpenDialog(this);
		
		if(respuesta == JFileChooser.APPROVE_OPTION) {
			ruta5 = jf.getSelectedFile().getPath();
		}
		return ruta5;
		}
}