package gui;
import gui.Principal;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.ManagerDeUsuario;
import businessLogic.Runner;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
/**
 * @author Mateo Ortiz & Andres Moreno
 * 
 */
public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField username1;
	private JPasswordField contraseña1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicio de sesion");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(195, 32, 138, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 73, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		username1 = new JTextField();
		username1.setBounds(45, 108, 94, 20);
		contentPane.add(username1);
		username1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(45, 139, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		contraseña1 = new JPasswordField();
		contraseña1.setBounds(45, 164, 94, 20);
		contentPane.add(contraseña1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char [] contraseña = contraseña1.getPassword();
				String contraseñaFinal = new String(contraseña);
				
				if(ManagerDeUsuario.loginUsuario(username1.getText(),contraseñaFinal)==true) {
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido a HYGGE","Ingresaste",JOptionPane.INFORMATION_MESSAGE);
					Principal p = new Principal();
					p.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos","No se puede ingresar",JOptionPane.ERROR_MESSAGE);
					username1.setText("");
					contraseña1.setText("");
					username1.requestFocus();
				}
			}
		});
		btnEntrar.setBounds(220, 256, 94, 33);
		contentPane.add(btnEntrar);
		
		JButton btnRegistro = new JButton("Registrese aqui");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro l = new Registro();
				l.setVisible(true);
			}
		});
		btnRegistro.setForeground(new Color(0, 0, 255));
		btnRegistro.setBackground(new Color(240, 240, 240));
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBounds(45, 208, 114, 14);
		contentPane.add(btnRegistro);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(524, 0, 17, 345);
		contentPane.add(scrollBar);
	}
}
