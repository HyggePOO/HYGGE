package gui;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import businessLogic.AdmUsuario;
import data.ListaNegocios;

import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * @author Mateo Ortiz & Andres Moreno
 * 
 */

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int anchoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int altoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	/**
	 * Create the frame.
	 */
	public Principal(final ListaNegocios listaNegocio) {
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(anchoScreen/16, altoScreen/16, 1227, 654);
		setTitle("HYGGE - Inicio");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Calendar c1 = Calendar.getInstance();
		final int mes = c1.get(Calendar.MONTH)+1;
		JButton btndestacado = new JButton("");
		btndestacado.setBounds(874, 276, 293, 262);
		btndestacado.setIcon(new ImageIcon("sources/iconos/destacado.jpeg"));
		ImageIcon icdestacado = new ImageIcon("sources/iconos/destacado.jpeg");
		ImageIcon imgndestacado= new ImageIcon(icdestacado.getImage().getScaledInstance(btndestacado.getWidth(), btndestacado.getHeight(), Image.SCALE_SMOOTH));
		btndestacado.setIcon(imgndestacado);
		btndestacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mes==6 || mes==7) {
					Buscador B = new Buscador(listaNegocio,"Hotelero");
					B.setVisible(true);
				}if(mes==1 || mes==2) {
					Buscador B = new Buscador(listaNegocio,"Actividades");
					B.setVisible(true);
				}if(mes==5 || mes==10) {
					Buscador B = new Buscador(listaNegocio,"Gastronomico");
					B.setVisible(true);
				}if(mes==3 || mes==12) {
					Buscador B = new Buscador(listaNegocio,"Cultural");
					B.setVisible(true);
				}if(mes==4 || mes==11) {
					Buscador B = new Buscador(listaNegocio,"Deportes Extremos");
					B.setVisible(true);
				}if(mes==8 || mes==9){
					Buscador B = new Buscador(listaNegocio,"Ecoturismo");
					B.setVisible(true);
				}
				
			}
		});
		contentPane.add(btndestacado);
		
		JLabel lblNewLabel_2 = new JLabel("Destinos desctacados");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_2.setBounds(874, 240, 251, 40);
		contentPane.add(lblNewLabel_2);
		
		final JPanel panelSesion = new JPanel();
		panelSesion.setBorder(new EmptyBorder(2, 2, 2, 2));
		panelSesion.setBackground(Color.LIGHT_GRAY);
		panelSesion.setBounds(924, 90, 243, 137);
		contentPane.add(panelSesion);
		panelSesion.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de Sesi\u00F3n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 119, 14);
		panelSesion.add(lblNewLabel_1);
		
		JButton botonUsuario = new JButton("Usuario");
		botonUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio sesion1 =new Inicio(listaNegocio);
				sesion1.setVisible(true);
				dispose();
			}
		});	
		botonUsuario.setBounds(20, 36, 98, 90);
		panelSesion.add(botonUsuario);
		
		JButton botonNegocio = new JButton("Negocio");
		botonNegocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioNegocio sesion2 = new InicioNegocio(listaNegocio);
				sesion2.setVisible(true);
				dispose();
			}
		});
		botonNegocio.setBounds(128, 36, 98, 90);
		panelSesion.add(botonNegocio);
		
		JButton botonSesionCerrar = new JButton("");
		botonSesionCerrar.setIcon(new ImageIcon("sources/iconos/cerrar.jpg"));
		ImageIcon iconS = new ImageIcon("sources/iconos/cerrar.jpg");
		ImageIcon imagS = new ImageIcon(iconS.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		botonSesionCerrar.setIcon(imagS);
		botonSesionCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSesion.setVisible(false);
			}
		});
		botonSesionCerrar.setBounds(201, 7, 25, 25);
		panelSesion.add(botonSesionCerrar);
		panelSesion.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 1227, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("BUSCAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscador B=new Buscador(listaNegocio,null);
				B.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(647, 0, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("PERFIL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdmUsuario.isLogeado()== true && AdmUsuario.getUsuarioLogeadoTipo()=="usuario") {
					VentanaUsuario vu = new VentanaUsuario(AdmUsuario.getUsuarioLogeado());
					vu.setVisible(true);
				}else if(AdmUsuario.isLogeado() == true && AdmUsuario.getUsuarioLogeadoTipo()=="negocio"){
					VentanaNegocio vn = new VentanaNegocio(AdmUsuario.getNegocioLogeado());
					vn.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Primero debe iniciar sesi�n","Intente nuevamente",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(735, 0, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton botonCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		if(AdmUsuario.isLogeado() == true){
			botonCerrarSesion.setVisible(true);
		}else {
			botonCerrarSesion.setVisible(false);
		}
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					AdmUsuario.cerrarSesion();
					dispose();
					Principal p = new Principal(listaNegocio);
					p.setVisible(true);
			}
		});
		botonCerrarSesion.setBounds(1015, 61, 151, 23);
		panel.add(botonCerrarSesion);
		
		JButton botonInicioSesion = new JButton("Iniciar Sesi\u00F3n");
		if (AdmUsuario.isLogeado()== false) {
			botonInicioSesion.setVisible(true);
		}else {
			botonInicioSesion.setVisible(false);
		}
		botonInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panelSesion.setVisible(true);
			}
		});
		botonInicioSesion.setBounds(1015, 61, 151, 23);
		panel.add(botonInicioSesion);
		
		final JLabel usuarioLogeado = new JLabel("");
		usuarioLogeado.setFont(new Font("Tahoma", Font.PLAIN, 15));

		usuarioLogeado.setBounds(895, 6, 288, 36);
		if (AdmUsuario.isLogeado() == true && AdmUsuario.getUsuarioLogeadoTipo()=="usuario") {
			usuarioLogeado.setText(AdmUsuario.getUsuarioLogeado().getUsername());
		}else if(AdmUsuario.isLogeado() == true && AdmUsuario.getUsuarioLogeadoTipo()=="negocio"){
			usuarioLogeado.setText(AdmUsuario.getNegocioLogeado().getNombre());
			
		}
		panel.add(usuarioLogeado);
		
		JLabel imgUsuario = new JLabel("");
		imgUsuario.setBounds(855, 6, 30, 30);
		if (AdmUsuario.isLogeado()== true && AdmUsuario.getUsuarioLogeadoTipo()=="usuario") {
				imgUsuario.setIcon(new ImageIcon("sources/imgUsuarios/" + AdmUsuario.getUsuarioLogeado().getUsername() +".jpg"));
				ImageIcon icon = new ImageIcon("sources/imgUsuarios/" + AdmUsuario.getUsuarioLogeado().getUsername() +".jpg");
				ImageIcon imag = new ImageIcon(icon.getImage().getScaledInstance(imgUsuario.getWidth(), imgUsuario.getHeight(), Image.SCALE_SMOOTH));
				imgUsuario.setIcon(imag);				

		}
		panel.add(imgUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(36, -20, 150, 130);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBounds(0, 0, 151, 129);
		lblNewLabel.setIcon(new ImageIcon("sources/HYGGE.png"));
		ImageIcon icon= new ImageIcon("sources/HYGGE.png");
		ImageIcon imag= new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imag);
		panel_1.add(lblNewLabel);
		
		JLabel cate = new JLabel("Categorias");
		cate.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 27));
		cate.setBounds(36, 167, 166, 40);
		contentPane.add(cate);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(36, 211, 243, 147);
		btnNewButton_3.setIcon(new ImageIcon("sources/iconos/hotel.jpg"));
		ImageIcon ichoteleria = new ImageIcon("sources/iconos/hotel.jpg");
		ImageIcon imghoteleria= new ImageIcon(ichoteleria.getImage().getScaledInstance(btnNewButton_3.getWidth(), btnNewButton_3.getHeight(), Image.SCALE_SMOOTH));
		btnNewButton_3.setIcon(imghoteleria);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscador B=new Buscador(listaNegocio,"Hotelero");
				B.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(312, 211, 243, 147);
		btnNewButton_4.setIcon(new ImageIcon("sources/iconos/deportes.jpg"));
		ImageIcon icdeportes = new ImageIcon("sources/iconos/deportes.jpg");
		ImageIcon imgdeportes= new ImageIcon(icdeportes.getImage().getScaledInstance(btnNewButton_4.getWidth(), btnNewButton_4.getHeight(), Image.SCALE_SMOOTH));
		btnNewButton_4.setIcon(imgdeportes);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscador B=new Buscador(listaNegocio,"Actividades");
				B.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBounds(36, 391, 243, 147);
		btnNewButton_5.setIcon(new ImageIcon("sources/iconos/gastronomia.jpg"));
		ImageIcon icgastronomia = new ImageIcon("sources/iconos/gastronomia.jpg");
		ImageIcon imggastronomia= new ImageIcon(icgastronomia.getImage().getScaledInstance(btnNewButton_5.getWidth(), btnNewButton_5.getHeight(), Image.SCALE_SMOOTH));
		btnNewButton_5.setIcon(imggastronomia);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscador B = new Buscador(listaNegocio,"Gastronomico");
				B.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBounds(312, 391, 243, 147);
		btnNewButton_6.setIcon(new ImageIcon("sources/iconos/cultura.jpg"));
		ImageIcon iccultura = new ImageIcon("sources/iconos/cultura.jpg");
		ImageIcon imgcultura= new ImageIcon(iccultura.getImage().getScaledInstance(btnNewButton_6.getWidth(), btnNewButton_6.getHeight(), Image.SCALE_SMOOTH));
		btnNewButton_6.setIcon(imgcultura);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscador B = new Buscador(listaNegocio,"Cultural");
				B.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setBounds(588, 211, 243, 147);
		btnNewButton_7.setIcon(new ImageIcon("sources/iconos/extremo.jpg"));
		ImageIcon icextremo = new ImageIcon("sources/iconos/extremo.jpg");
		ImageIcon imgextremo= new ImageIcon(icextremo.getImage().getScaledInstance(btnNewButton_7.getWidth(), btnNewButton_7.getHeight(), Image.SCALE_SMOOTH));
		btnNewButton_7.setIcon(imgextremo);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscador B = new Buscador(listaNegocio,"Deportes Extremos");
				B.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setBounds(588, 391, 243, 147);
		btnNewButton_8.setIcon(new ImageIcon("sources/iconos/naturaleza.jpg"));
		ImageIcon icnaturaleza = new ImageIcon("sources/iconos/naturaleza.jpg");
		ImageIcon imgnaturaleza= new ImageIcon(icnaturaleza.getImage().getScaledInstance(btnNewButton_8.getWidth(), btnNewButton_8.getHeight(), Image.SCALE_SMOOTH));
		btnNewButton_8.setIcon(imgnaturaleza);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscador B = new Buscador(listaNegocio,"Ecoturismo");
				B.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_8);

		
	}
}
