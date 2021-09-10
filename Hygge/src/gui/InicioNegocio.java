package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import businessLogic.AdmUsuario;
import businessLogic.ManagerDeNegocio;

import data.ListaNegocios;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

/**
 * @author Mateo Ortiz & Andres Moreno
 * 
 */
@SuppressWarnings("serial")
public class InicioNegocio extends JFrame {
	
	private JPanel contentPane;
	private JTextField username1;
	private JPasswordField contraseņa1;

	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int anchoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int altoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	/**
	 * Create the frame.
	 */
	public InicioNegocio(final ListaNegocios listaNegocio) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HYGGE - Inicio Sesion");
		setBounds(anchoScreen/16, altoScreen/16, 557, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 0, 383, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicio de sesion de Negocio");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel.setBounds(39, 20, 300, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Negocio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 120, 64, 20);
		contentPane.add(lblNewLabel_1);
		
		username1 = new JTextField();
		username1.setBounds(45, 145, 94, 20);
		contentPane.add(username1);
		username1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(45, 176, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		contraseņa1 = new JPasswordField();
		contraseņa1.setBounds(45, 201, 94, 20);
		contentPane.add(contraseņa1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char [] contraseņa = contraseņa1.getPassword();
				String contraseņaFinal = new String(contraseņa);
				
				if(ManagerDeNegocio.loginNegocio(username1.getText(),contraseņaFinal)==true) {
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido a HYGGE","Ingresaste",JOptionPane.INFORMATION_MESSAGE);
					AdmUsuario.setUsuarioLogeado(username1.getText(),"negocio");
					Principal p = new Principal(listaNegocio);
					p.setVisible(true);
				
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o Contraseņa incorrectos","No se puede ingresar",JOptionPane.ERROR_MESSAGE);
					username1.setText("");
					contraseņa1.setText("");
					username1.requestFocus();
				}
			}
		});
		btnEntrar.setBounds(299, 222, 94, 33);
		contentPane.add(btnEntrar);
		
		JButton btnRegistro = new JButton("Registre su negocio aqui");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroNegocio r = new RegistroNegocio(listaNegocio);
				r.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setForeground(new Color(0, 0, 255));
		btnRegistro.setBackground(new Color(240, 240, 240));
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBounds(45, 232, 210, 14);
		contentPane.add(btnRegistro);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal p = new Principal(listaNegocio);
				p.setVisible(true);
				dispose();
			}
		});
		botonVolver.setBounds(425, 25, 89, 23);
		contentPane.add(botonVolver);
	}
}
