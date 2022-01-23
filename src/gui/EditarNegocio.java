package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import businessLogic.ManagerDeNegocio;
import businessLogic.Runner;
import data.Negocio;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class EditarNegocio extends JFrame {

	private JPanel contentPane;
	private JPasswordField actualContraseña;
	private JPasswordField nuevaContraseña;
	final JLabel imagenPerfil = new JLabel("");
	String ruta1 = "";
	String ruta2 = "";
	String ruta3 = "";
	String ruta4 = "";
	String ruta5 = "";
	private JTextField nombre;
	private JTextField ciudad;
	
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int anchoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int altoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private JTextField direccion;


	/**
	 * Create the frame.
	 */
	public EditarNegocio(final Negocio negocio) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("HYGGE - Editor");
		setBounds(anchoScreen/16, altoScreen/16, 872, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 666, 51);
		panel.setBackground(new Color(255, 99, 71));
		panel.setForeground(new Color(255, 99, 71));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editando Negocio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 263, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cambiar contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 73, 145, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ingrese actual contrase\u00F1a");
		lblNewLabel_2.setBounds(10, 104, 162, 28);
		contentPane.add(lblNewLabel_2);
		
		actualContraseña = new JPasswordField();
		actualContraseña.setBounds(10, 129, 145, 20);
		contentPane.add(actualContraseña);
		
		JLabel lblNewLabel_3 = new JLabel("Ingrese nueva contrase\u00F1a");
		lblNewLabel_3.setBounds(10, 160, 162, 14);
		contentPane.add(lblNewLabel_3);
		
		nuevaContraseña = new JPasswordField();
		nuevaContraseña.setBounds(10, 179, 145, 20);
		contentPane.add(nuevaContraseña);
		
		JButton botonContraseña = new JButton("Cambiar contrase\u00F1a");
		botonContraseña.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonContraseña.setBounds(10, 210, 145, 23);
		botonContraseña.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(ManagerDeNegocio.cambioContraseña(negocio.getContraseña(),actualContraseña.getText()) == true) {
					if(ManagerDeNegocio.registroNegocioContraseña(nuevaContraseña.getText())==true) {
						negocio.setContraseña(nuevaContraseña.getText());
						try {
							Runner.guardar();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito","HYGGE",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña demasiado débil","Intente con una más segura",JOptionPane.ERROR_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "La contraseña ingresada no es la actual","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(botonContraseña);
		
		JLabel lblNewLabel_4 = new JLabel("Cambiar Ciudad");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 355, 122, 28);
		contentPane.add(lblNewLabel_4);
		
		ciudad = new JTextField();
		ciudad.setBounds(10, 386, 145, 20);
		contentPane.add(ciudad);
		ciudad.setColumns(10);
		
		JButton botonCiudad = new JButton("Cambiar Ciudad");
		botonCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ciudad.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Escriba una ciudad","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				} else {
					negocio.setCiudad(ciudad.getText());
					try {
						Runner.guardar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Runner.cargar();
					JOptionPane.showMessageDialog(null, "Ciudad cambiada con éxito","HYGGE",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		botonCiudad.setBounds(10, 417, 145, 23);
		contentPane.add(botonCiudad);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Cambiar Descripci\u00F3n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(220, 73, 162, 23);
		contentPane.add(lblNewLabel_1_1);
		
		final JTextPane descripcion = new JTextPane();
		JScrollPane descripcionScroll = new JScrollPane(descripcion);
        descripcionScroll = new JScrollPane(descripcion);
        descripcionScroll.setBounds(220, 104, 224, 173);
		contentPane.add(descripcionScroll);
		
		JButton botonDescripcion = new JButton("Cambiar Descripci\u00F3n");
		botonDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 9));
		botonDescripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(descripcion.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Escriba una descripcion","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				} else {
					ManagerDeNegocio.guardarDescripcion(negocio.getbName(),descripcion.getText());
					//negocio.setDescripcion(descripcion.getText());
					//Runner.guardar();
					JOptionPane.showMessageDialog(null, "Descripción cambiado con éxito","HYGGE",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		botonDescripcion.setBounds(297, 301, 147, 23);
		contentPane.add(botonDescripcion);
		
		JLabel lblNewLabel_5 = new JLabel("Cambiar Direccion");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(178, 355, 122, 28);
		contentPane.add(lblNewLabel_5);
		
		direccion = new JTextField();
		direccion.setBounds(178, 386, 177, 20);
		contentPane.add(direccion);
		direccion.setColumns(10);
		
		JButton botonDireccion = new JButton("Cambiar Direccion");
		botonDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(direccion.getText().isBlank()) {
					
				} else {
					negocio.setDireccion(direccion.getText());
					try {
						Runner.guardar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Direccion cambiada con éxito","HYGGE",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		botonDireccion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonDireccion.setBounds(178, 417, 145, 23);
		contentPane.add(botonDireccion);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cambiar Im\u00E1genes");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(471, 73, 162, 23);
		contentPane.add(lblNewLabel_1_1_1);
		
		final JLabel imagenPerfil = new JLabel("");
		imagenPerfil.setBounds(471, 96, 150, 150);
		imagenPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		final ImageIcon icon= new ImageIcon(getClass().getResource(""));
		ImageIcon imag= new ImageIcon(icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		imagenPerfil.setIcon(imag);
		contentPane.add(imagenPerfil);
		
		JButton botonSubirArchivo = new JButton("Elegir nueva imágen");
		botonSubirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				subirImg1(e);
				if (ruta1.endsWith("jpg")||ruta1.endsWith("png") ||ruta1.endsWith("gif")||ruta1.endsWith("jpeg")) {
					Image imagen = new ImageIcon(ruta1).getImage();
					ImageIcon icon = new ImageIcon(imagen.getScaledInstance(150,150,Image.SCALE_SMOOTH));
					imagenPerfil.setIcon(icon);
				}else {
					JOptionPane.showMessageDialog(null, "Escoja un archivo de imagen soportado","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
					ruta1= "";
				}

			}
		});
		botonSubirArchivo.setBounds(471, 267, 150, 23);
		contentPane.add(botonSubirArchivo);
		
		
		final JLabel imagen2 = new JLabel("");
		imagen2.setBounds(631, 96, 75, 75);
		imagen2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		final ImageIcon icon2= new ImageIcon(getClass().getResource(""));
		ImageIcon imag2= new ImageIcon(icon2.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		imagen2.setIcon(imag2);
		contentPane.add(imagen2);
		
		JButton botonSubirArchivo2 = new JButton("Subir archivo 2");
		botonSubirArchivo2.setFont(new Font("Tahoma", Font.PLAIN, 8));
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
		botonSubirArchivo2.setBounds(631, 257, 89, 23);
		contentPane.add(botonSubirArchivo2);
		
		
		final JLabel imagen3 = new JLabel("");
		imagen3.setBounds(631, 171, 75, 75);
		imagen3.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		final ImageIcon icon3= new ImageIcon(getClass().getResource(""));
		ImageIcon imag3= new ImageIcon(icon3.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		imagen3.setIcon(imag3);
		contentPane.add(imagen3);
		
		JButton botonSubirArchivo3 = new JButton("Subir archivo 3");
		botonSubirArchivo3.setFont(new Font("Tahoma", Font.PLAIN, 8));
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
		botonSubirArchivo3.setBounds(631, 277, 89, 23);
		contentPane.add(botonSubirArchivo3);
		
		
		final JLabel imagen4 = new JLabel("");
		imagen4.setBounds(716, 96, 75, 75);
		imagen4.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		final ImageIcon icon4= new ImageIcon(getClass().getResource(""));
		ImageIcon imag4= new ImageIcon(icon4.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		imagen4.setIcon(imag4);
		contentPane.add(imagen4);
		
		JButton botonSubirArchivo4 = new JButton("Subir archivo 4");
		botonSubirArchivo4.setFont(new Font("Tahoma", Font.PLAIN, 8));
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
		botonSubirArchivo4.setBounds(726, 257, 89, 23);
		contentPane.add(botonSubirArchivo4);
		
		
		final JLabel imagen5 = new JLabel("");
		imagen5.setBounds(716, 171, 75, 75);
		imagen5.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		final ImageIcon icon5= new ImageIcon(getClass().getResource(""));
		ImageIcon imag5= new ImageIcon(icon5.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		imagen5.setIcon(imag5);
		contentPane.add(imagen5);
		
		JButton botonSubirArchivo5 = new JButton("Subir archivo 5");
		botonSubirArchivo5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		botonSubirArchivo5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				subirImg5(e);
				if (ruta5.endsWith("jpg")||ruta5.endsWith("png") ||ruta5.endsWith("gif")||ruta5.endsWith("jpeg")) {
					Image imagen = new ImageIcon(ruta5).getImage();
					ImageIcon icon = new ImageIcon(imagen.getScaledInstance(75,75,Image.SCALE_SMOOTH));
					imagen5.setIcon(icon);
				}else {
					JOptionPane.showMessageDialog(null, "Escoja un archivo de imagen soportado","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
					ruta5= "sources/desconocido.jpg";
				}

			}
		});
		botonSubirArchivo5.setBounds(726, 277, 89, 23);
		contentPane.add(botonSubirArchivo5);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaNegocio vn = new VentanaNegocio(negocio);
				vn.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(726, 21, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cambiar Nombre");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(10, 261, 145, 23);
		contentPane.add(lblNewLabel_1_2);
		
		nombre = new JTextField();
		nombre.setBounds(10, 290, 145, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JButton botonNombre = new JButton("Cambiar Nombre");
		botonNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nombre.getText().length() > 0 && ManagerDeNegocio.nombreDuplicado(nombre.getText())== false) {
					negocio.setNombre(nombre.getText());
					try {
						Runner.guardar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Runner.cargar();
					JOptionPane.showMessageDialog(null, "Nombre cambiado con éxito","HYGGE",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Nombre de negocio ya en uso","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
					
				}

			}
		});
		botonNombre.setBounds(10, 321, 145, 23);
		contentPane.add(botonNombre);
		
		JButton botonGuardarImg = new JButton("Guardar Im\u00E1gen");
		botonGuardarImg.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonGuardarImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ruta1 == "") {
					JOptionPane.showMessageDialog(null, "Primero suba un archivo de imagen","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				}else {
					ManagerDeNegocio.guardarImagen(ruta1,negocio.getbName() + "1");
				}
				
			}
		});
		botonGuardarImg.setBounds(471, 301, 124, 23);
		contentPane.add(botonGuardarImg);
		
		JButton botonGuardarImg2 = new JButton("Guardar Im\u00E1gen");
		botonGuardarImg2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		botonGuardarImg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ruta2 == "") {
					JOptionPane.showMessageDialog(null, "Primero suba un archivo de imagen","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				}else {
					ManagerDeNegocio.guardarImagen(ruta2,negocio.getbName() + "2");
				}
				
			}
		});
		botonGuardarImg2.setBounds(631, 311, 89, 23);
		contentPane.add(botonGuardarImg2);
		
		JButton botonGuardarImg3 = new JButton("Guardar Im\u00E1gen");
		botonGuardarImg3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		botonGuardarImg3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ruta3 == "") {
					JOptionPane.showMessageDialog(null, "Primero suba un archivo de imagen","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				}else {
					ManagerDeNegocio.guardarImagen(ruta3,negocio.getbName() + "3");
				}
				
			}
		});
		botonGuardarImg3.setBounds(631, 335, 89, 23);
		contentPane.add(botonGuardarImg3);
		
		JButton botonGuardarImg4 = new JButton("Guardar Im\u00E1gen");
		botonGuardarImg4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		botonGuardarImg4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ruta4 == "") {
					JOptionPane.showMessageDialog(null, "Primero suba un archivo de imagen","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				}else {
					ManagerDeNegocio.guardarImagen(ruta4,negocio.getbName() + "4");
				}
				
			}
		});
		botonGuardarImg4.setBounds(726, 311, 89, 23);
		contentPane.add(botonGuardarImg4);
		
		JButton botonGuardarImg5 = new JButton("Guardar Im\u00E1gen");
		botonGuardarImg5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		botonGuardarImg5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ruta5 == "") {
					JOptionPane.showMessageDialog(null, "Primero suba un archivo de imagen","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				}else {
					ManagerDeNegocio.guardarImagen(ruta5,negocio.getbName() + "5");
				}
				
			}
		});
		botonGuardarImg5.setBounds(726, 335, 89, 23);
		contentPane.add(botonGuardarImg5);
		
		
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
