package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import businessLogic.AdmUsuario;
import businessLogic.ManagerDeUsuario;
import data.Usuario;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Valentina Colmenares, Daniel Lozano, Mateo Ortiz, Kevin Rincón & Andres Moreno
 * 
 */
@SuppressWarnings("serial")
public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int anchoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int altoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public VentanaUsuario(final Usuario usuario) throws Exception {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("HYGGE - "+ usuario.getUsername());
		setBounds(anchoScreen/16, altoScreen/16, 616, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 99, 71));
		panel.setForeground(new Color(255, 99, 71));
		panel.setBounds(10, 11, 567, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel paginaUs = new JLabel("P\u00E1gina de Usuario: "+ usuario.getUsername());
		paginaUs.setFont(new Font("Tahoma", Font.PLAIN, 21));
		paginaUs.setBounds(10, 11, 381, 35);
		panel.add(paginaUs);
		
		JLabel imgUsuario = new JLabel("");
		imgUsuario.setBounds(20, 79, 200, 200);
		imgUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		imgUsuario.setIcon(new ImageIcon("sources/imgUsuarios/" + usuario.getUsername() +".jpg"));
		ImageIcon icon = new ImageIcon("sources/imgUsuarios/" + usuario.getUsername() +".jpg");
		ImageIcon imag = new ImageIcon(icon.getImage().getScaledInstance(imgUsuario.getWidth(), imgUsuario.getHeight(), Image.SCALE_SMOOTH));
		imgUsuario.setIcon(imag);	
		contentPane.add(imgUsuario);
		
		JLabel lblNewLabel = new JLabel(usuario.getNombre());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(230, 104, 247, 28);
		contentPane.add(lblNewLabel);
		
		JButton botonEdPerfil = new JButton("Editar Perfil");
		botonEdPerfil.setEnabled(false);
		if(AdmUsuario.isLogeado()== true && AdmUsuario.getUsuarioLogeado() == usuario) {
			botonEdPerfil.setEnabled(true);
		}
		botonEdPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarPerfil ep = new EditarPerfil(usuario);
				ep.setVisible(true);
				dispose();
			}
		});
		botonEdPerfil.setForeground(new Color(0, 0, 204));
		botonEdPerfil.setBounds(464, 97, 113, 23);
		contentPane.add(botonEdPerfil);
		
		JLabel edad = new JLabel("Edad: " + usuario.getEdad() + " años.");
		edad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		edad.setBounds(230, 143, 177, 28);
		contentPane.add(edad);
		
		JLabel lblNewLabel_2 = new JLabel("AutoBiograf\u00EDa");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(230, 170, 200, 28);
		contentPane.add(lblNewLabel_2);
		
		JTextArea biografia = new JTextArea();
		biografia.setBounds(230, 204, 247, 109);
		biografia.setEditable(false);
		biografia.setLineWrap(true);
		biografia.setWrapStyleWord(true);
		for(int i=0 ; i < ManagerDeUsuario.subirBiografia(usuario.getUsername()).size();i++) {
			biografia.append(ManagerDeUsuario.subirBiografia(usuario.getUsername()).get(i)+"\n");
			
		}
		contentPane.add(biografia);
		
	}
}
