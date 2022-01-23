package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import data.Negocio;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class VNImagenes extends JFrame {

	private JPanel contentPane;
	
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int anchoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int altoScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	/**
	 * Create the frame.
	 */
	public VNImagenes(Negocio negocio) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("HYGGE");
		setBounds(anchoScreen/16, (altoScreen/16)+100, 715, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();		
		JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(10, 11, 689, 373);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.setPreferredSize(new Dimension(2325, 373));
		contentPane.add(scrollPane);
        
        JLabel imagen1 = new JLabel("");
        imagen1.setBounds(10, 11, 450, 338);
        imagen1.setBorder(new EmptyBorder(5, 5, 5, 5));
        imagen1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
        imagen1.setIcon(new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"1.jpg"));
		ImageIcon icon = new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"1.jpg");
		ImageIcon imag = new ImageIcon(icon.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_SMOOTH));
		panel.setLayout(null);
		imagen1.setIcon(imag);	
        panel.add(imagen1);
        
        JLabel imagen2 = new JLabel("");
        imagen2.setBounds(470, 11, 450, 338);
        imagen2.setBorder(new EmptyBorder(5, 5, 5, 5));
        imagen2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
        imagen2.setIcon(new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"2.jpg"));
		ImageIcon icon2 = new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"2.jpg");
		ImageIcon imag2 = new ImageIcon(icon2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_SMOOTH));
		imagen2.setIcon(imag2);	
        panel.add(imagen2);
        
        JLabel imagen3 = new JLabel("");
        imagen3.setBounds(930, 11, 450, 338);
        imagen3.setBorder(new EmptyBorder(5, 5, 5, 5));
        imagen3.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
        imagen3.setIcon(new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"3.jpg"));
		ImageIcon icon3 = new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"3.jpg");
		ImageIcon imag3 = new ImageIcon(icon3.getImage().getScaledInstance(imagen3.getWidth(), imagen3.getHeight(), Image.SCALE_SMOOTH));
		imagen3.setIcon(imag3);	
        panel.add(imagen3);
        
        JLabel imagen4 = new JLabel("");
        imagen4.setBounds(1390, 11, 450, 338);
        imagen4.setBorder(new EmptyBorder(5, 5, 5, 5));
        imagen4.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
        imagen4.setIcon(new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"4.jpg"));
		ImageIcon icon4 = new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"4.jpg");
		ImageIcon imag4 = new ImageIcon(icon4.getImage().getScaledInstance(imagen4.getWidth(), imagen4.getHeight(), Image.SCALE_SMOOTH));
		imagen4.setIcon(imag4);	
        panel.add(imagen4);
        
        JLabel imagen5 = new JLabel("");
        imagen5.setBounds(1850, 11, 450, 338);
        imagen5.setBorder(new EmptyBorder(5, 5, 5, 5));
        imagen5.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
        imagen5.setIcon(new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"5.jpg"));
		ImageIcon icon5 = new ImageIcon("sources/imgNegocios/" + negocio.getbName() +"5.jpg");
		ImageIcon imag5 = new ImageIcon(icon5.getImage().getScaledInstance(imagen5.getWidth(), imagen5.getHeight(), Image.SCALE_SMOOTH));
		imagen5.setIcon(imag5);	
        panel.add(imagen5);

		
	}
}