package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.ManagerDeUsuario;
import businessLogic.Runner;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

/**
 * @author Mateo Ortiz & Andres Moreno
 * 
 */
public class Registro extends JFrame{

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField contraseña;
	private JTextField nombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Registro de Usuario");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario *");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		username = new JTextField();
		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.insets = new Insets(0, 0, 5, 5);
		gbc_username.fill = GridBagConstraints.HORIZONTAL;
		gbc_username.gridx = 1;
		gbc_username.gridy = 3;
		contentPane.add(username, gbc_username);
		username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a *");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		contraseña = new JPasswordField();
		GridBagConstraints gbc_contraseña = new GridBagConstraints();
		gbc_contraseña.insets = new Insets(0, 0, 5, 5);
		gbc_contraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_contraseña.gridx = 1;
		gbc_contraseña.gridy = 5;
		contentPane.add(contraseña, gbc_contraseña);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre Real");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		nombre = new JTextField();
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombre.gridx = 1;
		gbc_nombre.gridy = 7;
		contentPane.add(nombre, gbc_nombre);
		nombre.setColumns(10);
		
		JButton botonCompletar = new JButton("Completar Registro");
		botonCompletar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(ManagerDeUsuario.registroUsuarioUsername(username.getText())==true) {
					if(ManagerDeUsuario.registroUsuarioContraseña(contraseña.getText())==true) {
						ManagerDeUsuario.registroUsuario(username.getText(),contraseña.getText(),nombre.getText());
						Runner.guardar(true);
						JOptionPane.showMessageDialog(null, "Usuario Registrado","Ya puedes ingresar",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña demasiado débil","intente con una más larga",JOptionPane.ERROR_MESSAGE);
						contraseña.setText("");
						username.requestFocus();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Nombre de Usuario ya escogido o en blanco","intente con otro",JOptionPane.ERROR_MESSAGE);
					username.setText("");
					contraseña.setText("");
					username.requestFocus();
				}
				
				Registro l = new Registro();
				l.setVisible(true);
				l.dispose();
			}
		});
		GridBagConstraints gbc_botonCompletar = new GridBagConstraints();
		gbc_botonCompletar.insets = new Insets(0, 0, 0, 5);
		gbc_botonCompletar.gridx = 3;
		gbc_botonCompletar.gridy = 8;
		contentPane.add(botonCompletar, gbc_botonCompletar);
	}

}
