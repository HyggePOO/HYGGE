package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import businessLogic.ManagerDeUsuario;
import businessLogic.Runner;
import data.ListaNegocios;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;

/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz, Kevin Rincón & Andres Moreno
 * 
 */
@SuppressWarnings("serial")
public class Registro extends JFrame{

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField contraseña;
	private JTextField nombre;
	final JLabel imagenPerfil = new JLabel("");
	String ruta = "sources/desconocido.jpg";
	private JTextField edad;
	
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int anchoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int altoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	/**
	 * Create the frame.
	 */
	public Registro(final ListaNegocios listaNegocio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("HYGGE - Registro");
		setBounds(anchoScreen/16, altoScreen/16, 656, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 99, 71));
		panel.setForeground(new Color(255, 99, 71));
		panel.setBounds(27, 11, 489, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("Registro de Usuario");
		lblNewLabel1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel1.setBounds(23, 11, 305, 36);
		panel.add(lblNewLabel1);
		lblNewLabel1.setFont(new Font("Calibri", Font.BOLD, 24));
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario*");
		lblNewLabel.setBounds(27, 88, 200, 14);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(27, 113, 131, 20);
		contentPane.add(username);		
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a *");
		lblNewLabel_2.setBounds(27, 144, 110, 14);
		contentPane.add(lblNewLabel_2);
		
		contraseña = new JPasswordField();
		contraseña.setBounds(27, 169, 125, 20);
		contentPane.add(contraseña);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre Real");
		lblNewLabel_3.setBounds(27, 200, 110, 14);
		contentPane.add(lblNewLabel_3);
		
		nombre = new JTextField();
		nombre.setBounds(27, 225, 125, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		final JLabel imagenPerfil = new JLabel("");
		imagenPerfil.setBounds(391, 113, 150, 150);
		imagenPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		final ImageIcon icon= new ImageIcon(getClass().getResource(""));
		ImageIcon imag= new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		imagenPerfil.setIcon(imag);
		contentPane.add(imagenPerfil);
		
		JButton botonSubirArchivo = new JButton("Subir archivo");
		botonSubirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jButtonActionPerformed(e);
				if (ruta.endsWith("jpg")||ruta.endsWith("png") ||ruta.endsWith("gif")|| ruta.endsWith("jpeg")) {
					Image imagen = new ImageIcon(ruta).getImage();
					ImageIcon icon = new ImageIcon(imagen.getScaledInstance(150,150,Image.SCALE_SMOOTH));
					imagenPerfil.setIcon(icon);
				}else {
					JOptionPane.showMessageDialog(null, "Escoja un archivo de imagen soportado","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
					ruta= "sources/desconocido.jpg";
				}

			}
		});
		botonSubirArchivo.setBounds(391, 274, 150, 23);
		contentPane.add(botonSubirArchivo);
		
		JLabel lblNewLabel_4 = new JLabel("Foto de perfil");
		lblNewLabel_4.setBounds(391, 88, 125, 14);
		contentPane.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel("Edad (a\u00F1os)");
		lblNewLabel_5.setBounds(186, 88, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		edad = new JTextField();
		edad.setBounds(186, 113, 107, 20);
		contentPane.add(edad);
		edad.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("AutoBiografia");
		lblNewLabel_6.setBounds(186, 144, 97, 14);
		contentPane.add(lblNewLabel_6);
		
		final JTextPane biografia = new JTextPane();
		biografia.setBounds(186, 169, 182, 144);
		contentPane.add(biografia);
		
		
		JButton botonCompletar = new JButton("Completar Registro");
		botonCompletar.setBounds(218, 324, 150, 23);
		botonCompletar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					if(ManagerDeUsuario.registroUsuarioUsername(username.getText())==true) {
						if(ManagerDeUsuario.registroUsuarioContraseña(contraseña.getText())==true) {
							ManagerDeUsuario.registroUsuario(username.getText(),contraseña.getText(),nombre.getText(),Integer.parseInt(edad.getText()));
							ManagerDeUsuario.guardarImagen(ruta,username.getText());
							ManagerDeUsuario.guardarBiografia(username.getText(), biografia.getText());
							Runner.guardar();
							JOptionPane.showMessageDialog(null, "Usuario Registrado","Ya puedes ingresar",JOptionPane.INFORMATION_MESSAGE);
							Runner.cargar();
							Inicio i = new Inicio(listaNegocio);
							i.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Contraseña demasiado débil, asegúrese que tenga más de 5 caracteres","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
							contraseña.setText("");
							username.requestFocus();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nombre de Usuario ya escogido o en blanco","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
						username.setText("");
						contraseña.setText("");
						username.requestFocus();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Registro l = new Registro(listaNegocio);
				l.setVisible(true);
				l.dispose();
			
			}
		});
		contentPane.add(botonCompletar);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio i = new Inicio(listaNegocio);
				i.setVisible(true);
				dispose();
			}
		});
		botonVolver.setBounds(541, 25, 89, 23);
		contentPane.add(botonVolver);

		
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
