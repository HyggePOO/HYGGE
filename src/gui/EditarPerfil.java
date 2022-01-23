package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import businessLogic.ManagerDeUsuario;
import businessLogic.Runner;
import data.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class EditarPerfil extends JFrame {

	private JPanel contentPane;
	private JPasswordField actualContraseña;
	private JPasswordField nuevaContraseña;
	final JLabel imagenPerfil = new JLabel("");
	String ruta = "";
	private JTextField nombre;
	
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int anchoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int altoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	/**
	 * Create the frame.
	 */
	public EditarPerfil(final Usuario usuario) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(anchoScreen/16,altoScreen/16, 649, 406);
		setTitle("HYGGE - Editor");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 520, 51);
		panel.setBackground(new Color(255, 99, 71));
		panel.setForeground(new Color(255, 99, 71));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editando Perfil");
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
				if(ManagerDeUsuario.cambioContraseña(usuario.getContraseña(),actualContraseña.getText()) == true) {
					if(ManagerDeUsuario.registroUsuarioContraseña(nuevaContraseña.getText())==true) {
						usuario.setContraseña(nuevaContraseña.getText());
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Cambiar Biografia");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(204, 73, 145, 23);
		contentPane.add(lblNewLabel_1_1);
		
		final JTextPane biografia = new JTextPane();
		biografia.setBounds(204, 104, 162, 142);
		contentPane.add(biografia);
		
		JButton botonBiografia = new JButton("Cambiar Biografia");
		botonBiografia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(biografia.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Escriba una biografia","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				} else {
					ManagerDeUsuario.guardarBiografia(usuario.getUsername(),biografia.getText());
					JOptionPane.showMessageDialog(null, "Biografia cambiado con éxito","HYGGE",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		botonBiografia.setBounds(202, 257, 147, 23);
		contentPane.add(botonBiografia);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cambiar Avatar");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(403, 73, 145, 23);
		contentPane.add(lblNewLabel_1_1_1);
		
		final JLabel imagenPerfil = new JLabel("");
		imagenPerfil.setBounds(403, 96, 150, 150);
		imagenPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		final ImageIcon icon= new ImageIcon(getClass().getResource(""));
		ImageIcon imag= new ImageIcon(icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		imagenPerfil.setIcon(imag);
		contentPane.add(imagenPerfil);
		
		JButton botonSubirArchivo = new JButton("Elegir nuevo avatar");
		botonSubirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jButtonActionPerformed(e);
				if (ruta.endsWith("jpg")||ruta.endsWith("png") ||ruta.endsWith("gif") ||ruta.endsWith("jpeg")) {
					Image imagen = new ImageIcon(ruta).getImage();
					ImageIcon icon = new ImageIcon(imagen.getScaledInstance(150,150,Image.SCALE_SMOOTH));
					imagenPerfil.setIcon(icon);
				}else {
					JOptionPane.showMessageDialog(null, "Escoja un archivo de imagen soportado","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
					ruta= "";
				}

			}
		});
		botonSubirArchivo.setBounds(391, 257, 150, 23);
		contentPane.add(botonSubirArchivo);
		
		JButton botonGuardarImg = new JButton("Guardar Imagen");
		botonGuardarImg.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonGuardarImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ruta == "") {
					JOptionPane.showMessageDialog(null, "Primero suba un archivo de imagen","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				}else {
					ManagerDeUsuario.guardarImagen(ruta,usuario.getUsername());
				}
				
			}
		});
		botonGuardarImg.setBounds(391, 289, 114, 23);
		contentPane.add(botonGuardarImg);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario vu = null;
				try {
					vu = new VentanaUsuario(usuario);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(534, 22, 89, 23);
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
				if (nombre.getText().length() > 0) {
					usuario.setNombre(nombre.getText());
					try {
						Runner.guardar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Nombre cambiado con éxito","HYGGE",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Introduzca por lo menos un dígito","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
					
				}

			}
		});
		botonNombre.setBounds(10, 321, 145, 23);
		contentPane.add(botonNombre);
	}
	
	private String jButtonActionPerformed(java.awt.event.ActionEvent avt) {

		JFileChooser jf = new JFileChooser();
		jf.setMultiSelectionEnabled(false);
		FileNameExtensionFilter filtrado = new FileNameExtensionFilter("jpg, png, gif", "jpg","png", "gif","jpeg");
		jf.setFileFilter(filtrado);
		
		int respuesta = jf.showOpenDialog(this);
		
		if(respuesta == JFileChooser.APPROVE_OPTION) {
			ruta = jf.getSelectedFile().getPath();
		}
		return ruta;
		}
}