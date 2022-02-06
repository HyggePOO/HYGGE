package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import businessLogic.AdmUsuario;
import businessLogic.ManagerDeNegocio;
import businessLogic.Runner;
import data.Negocio;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class VentanaNegocio extends JFrame {

	private JPanel contentPane;
	
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int anchoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int altoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public VentanaNegocio(final Negocio negocio) throws Exception {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("HYGGE - "+ negocio.getNombre());
		setBounds(anchoScreen/16, altoScreen/16, 662, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JScrollPane contentScroll = new JScrollPane(contentPane);
		contentScroll = new JScrollPane(contentPane);
		contentScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentScroll.setBounds(40, 40, 662, 601);
		setContentPane(contentScroll);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(255, 99, 71));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(10, 11, 567, 57);
		contentPane.add(panel);
		
		JLabel paginaUs = new JLabel(negocio.getNombre());
		paginaUs.setFont(new Font("Tahoma", Font.PLAIN, 21));
		paginaUs.setBounds(10, 11, 381, 35);
		panel.add(paginaUs);
		
		JPanel panelImagen = new JPanel();
		panelImagen.setBounds(20, 79, 409, 247);
		panelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		contentPane.add(panelImagen);
		
		JLabel imgPrincipal = new JLabel("");
		imgPrincipal.setBounds(10, 11, 270, 225);
		imgPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		imgPrincipal.setIcon(new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"1.jpg"));
		ImageIcon icon = new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"1.jpg");
		ImageIcon imag = new ImageIcon(icon.getImage().getScaledInstance(imgPrincipal.getWidth(), imgPrincipal.getHeight(), Image.SCALE_SMOOTH));
		panelImagen.setLayout(null);
		imgPrincipal.setIcon(imag);	
		panelImagen.add(imgPrincipal);
		
		JLabel imgSecundaria = new JLabel("");
		imgSecundaria.setBounds(290, 11, 109, 95);
		imgSecundaria.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		imgSecundaria.setIcon(new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"2.jpg"));
		ImageIcon icon2 = new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"2.jpg");
		ImageIcon imag2 = new ImageIcon(icon2.getImage().getScaledInstance(imgSecundaria.getWidth(), imgSecundaria.getHeight(), Image.SCALE_SMOOTH));
		panelImagen.setLayout(null);
		imgSecundaria.setIcon(imag2);	
		panelImagen.add(imgSecundaria);
		
		JLabel imgTerciaria = new JLabel("");
		imgTerciaria.setBounds(290, 110, 109, 95);
		imgTerciaria.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		imgTerciaria.setIcon(new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"3.jpg"));
		ImageIcon icon3 = new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"3.jpg");
		ImageIcon imag3 = new ImageIcon(icon3.getImage().getScaledInstance(imgTerciaria.getWidth(), imgTerciaria.getHeight(), Image.SCALE_SMOOTH));
		panelImagen.setLayout(null);
		imgTerciaria.setIcon(imag3);	
		panelImagen.add(imgTerciaria);
		
		JButton botonImagenes = new JButton("Ver Imagenes");
		botonImagenes.setFont(new Font("Tahoma", Font.PLAIN, 9));
		botonImagenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VNImagenes vni = new VNImagenes(negocio);
				vni.setVisible(true);
			}
		});
		
		JButton botonEdPerfil = new JButton("Editar Perfil");
		botonEdPerfil.setEnabled(false);
		if(AdmUsuario.isLogeado()== true && AdmUsuario.getNegocioLogeado() == negocio) {
			botonEdPerfil.setEnabled(true);
		}
		botonEdPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarNegocio en = new EditarNegocio(negocio);
				en.setVisible(true);
				dispose();
			}
		});
		botonEdPerfil.setForeground(new Color(0, 0, 204));
		botonEdPerfil.setBounds(316, 337, 113, 23);
		contentPane.add(botonEdPerfil);
		
		
		botonImagenes.setBounds(290, 213, 109, 23);
		panelImagen.add(botonImagenes);
		
		JLabel lblNewLabel = new JLabel("Valoraci\u00F3n");
		lblNewLabel.setBounds(462, 107, 137, 22);
		contentPane.add(lblNewLabel);
		
		JLabel valoracion = new JLabel(String.valueOf(negocio.getCalificacion()) + "  de " + negocio.getNumeroVotos() + " valoraciones.");
		valoracion.setBounds(472, 128, 127, 14);
		contentPane.add(valoracion);
		
		JPanel panelEstrellas = new JPanel();
		panelEstrellas.setBounds(462, 153, 125, 25);
		contentPane.add(panelEstrellas);
		panelEstrellas.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton estrella1 = new JButton("");
		estrella1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdmUsuario.isLogeado() == true && AdmUsuario.getUsuarioLogeadoTipo() == "usuario") {
					negocio.setCalificacion(1);
					negocio.addVotaciones();
					try {
						Runner.guardar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Para votar tiene que iniciar sesión como usuario","HYGGE",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		estrella1.setIcon(new ImageIcon("sources/iconos/estrella.png"));
		ImageIcon icon1 = new ImageIcon("sources/iconos/estrella.png");
		ImageIcon imag1 = new ImageIcon(icon1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		estrella1.setIcon(imag1);
		panelEstrellas.add(estrella1);
		
		JButton estrella2 = new JButton("");
		estrella2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdmUsuario.isLogeado() == true && AdmUsuario.getUsuarioLogeadoTipo() == "usuario") {
					negocio.setCalificacion(2);
					negocio.addVotaciones();
					try {
						Runner.guardar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Para votar tiene que iniciar sesión como usuario","HYGGE",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		estrella2.setIcon(imag1);
		panelEstrellas.add(estrella2);
		
		JButton estrella3 = new JButton("");
		estrella3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdmUsuario.isLogeado() == true && AdmUsuario.getUsuarioLogeadoTipo() == "usuario") {
					negocio.setCalificacion(3);
					negocio.addVotaciones();
					try {
						Runner.guardar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Para votar tiene que iniciar sesión como usuario","HYGGE",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		estrella3.setIcon(imag1);
		panelEstrellas.add(estrella3);
		
		JButton estrella4 = new JButton("");
		estrella4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdmUsuario.isLogeado() == true && AdmUsuario.getUsuarioLogeadoTipo() == "usuario") {
					negocio.setCalificacion(4);
					negocio.addVotaciones();
					try {
						Runner.guardar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Para votar tiene que iniciar sesión como usuario","HYGGE",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		estrella4.setIcon(imag1);
		panelEstrellas.add(estrella4);
		
		JButton estrella5 = new JButton("");
		estrella5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdmUsuario.isLogeado() == true && AdmUsuario.getUsuarioLogeadoTipo() == "usuario") {
					negocio.setCalificacion(5);
					negocio.addVotaciones();
					try {
						Runner.guardar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Para votar tiene que iniciar sesión como usuario","HYGGE",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		estrella5.setIcon(imag1);
		panelEstrellas.add(estrella5);
		
		JLabel lblNewLabel_1 = new JLabel("Categor\u00EDas:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(462, 203, 115, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCategorias = new JLabel(negocio.getCategoriaFuncion());
		lblCategorias.setVerticalAlignment(SwingConstants.TOP);
		lblCategorias.setBounds(472, 228, 127, 30);
		contentPane.add(lblCategorias);
		
		JLabel lblCategorias_1 = new JLabel(negocio.getCategoriaUbicacion());
		lblCategorias_1.setVerticalAlignment(SwingConstants.TOP);
		lblCategorias_1.setBounds(472, 253, 127, 30);
		contentPane.add(lblCategorias_1);
		
		JLabel lblUbicacion = new JLabel("Ubicacion:");
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUbicacion.setBounds(462, 283, 115, 20);
		contentPane.add(lblUbicacion);
		
		JLabel ubicacion = new JLabel(negocio.getCiudad() + " - " + negocio.getDepartamento());
		ubicacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ubicacion.setBounds(472, 300, 174, 30);
		contentPane.add(ubicacion);
		
		JLabel lblNewLabel_2 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_2.setBounds(41, 350, 148, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion.setEditable(false);
		descripcion.setLineWrap(true);
		descripcion.setWrapStyleWord(true);
		for(int i=0 ; i < ManagerDeNegocio.subirDescripcion(negocio.getbName()).size();i++) {
			descripcion.append(ManagerDeNegocio.subirDescripcion(negocio.getbName()).get(i)+"\n");
			
		}
		JScrollPane descripcionScroll = new JScrollPane(descripcion);
        descripcionScroll = new JScrollPane(descripcion);
        descripcionScroll.setBounds(20, 375, 409, 155);
		contentPane.add(descripcionScroll);
		
		JTextPane direccion = new JTextPane();
		direccion.setText(negocio.getDireccion());
		direccion.setBackground(new Color(240,240,240));
		direccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		direccion.setBounds(472, 325, 137, 87);
		contentPane.add(direccion);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(472, 505, 105, 25);
		contentPane.add(btnNewButton);
	}
}