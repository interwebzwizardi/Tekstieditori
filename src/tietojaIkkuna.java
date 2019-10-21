import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Panel;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.SwingConstants;

public class tietojaIkkuna extends JFrame {

	private JPanel contentPane;
	private JLabel lblTekstiEditoriV;
	private JLabel lblVilleJaatinen;
	private JPanel panel;
	private JLabel lblNewLabel;
	
	
	public tietojaIkkuna() {
		setTitle("Tietoja sovelluksesta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTekstiEditoriV = new JLabel("Teksti Editori v1.0");
		lblTekstiEditoriV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTekstiEditoriV.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTekstiEditoriV.setBounds(10, 11, 414, 53);
		contentPane.add(lblTekstiEditoriV);
		
		lblVilleJaatinen = new JLabel("Ville Jaatinen \u00A9");
		lblVilleJaatinen.setHorizontalAlignment(SwingConstants.CENTER);
		lblVilleJaatinen.setBounds(10, 52, 414, 14);
		contentPane.add(lblVilleJaatinen);
		
		panel = new JPanel();
		panel.setBounds(145, 75, 160, 160);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("kuvaLabel");
		lblNewLabel.setBounds(0, 0, 160, 160);
		Image kuva = new ImageIcon(this.getClass().getResource("/osrs_GNOMED.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(kuva));
		panel.add(lblNewLabel);
	}
}
