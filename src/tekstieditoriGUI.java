import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tekstieditoriGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnTiedosto;
	private JMenu mnMuokkaa;
	private JMenu mnTietoja;
	private JToolBar toolBar;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JMenuItem mntmAvaa;
	private JMenuItem mntmTallenna;
	private JMenuItem mntmLopeta;
	private JMenuItem mntmEtsi;
	private JMenuItem mntmKorvaa;
	public static JEditorPane editorPane;
	private JMenuItem mntmTietojaSovelluksesta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tekstieditoriGUI frame = new tekstieditoriGUI();
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
	public tekstieditoriGUI() {
		setTitle("Teksti Editori V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		mntmAvaa = new JMenuItem("Avaa");
		mntmAvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodeja.lataaTiedosto();
			}
		});
		mntmAvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmAvaa.setIcon(new ImageIcon(tekstieditoriGUI.class.getResource("/load_Icon.png")));
		mnTiedosto.add(mntmAvaa);
		
		mntmTallenna = new JMenuItem("Tallenna");
		mntmTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodeja.tallennaTiedosto();
			}
		});
		mntmTallenna.setIcon(new ImageIcon(tekstieditoriGUI.class.getResource("/save_Icon.png")));
		mntmTallenna.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmTallenna);
		
		mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodeja.lopeta();
			}
		});
		mnTiedosto.add(mntmLopeta);
		
		mnMuokkaa = new JMenu("Muokkaa");
		menuBar.add(mnMuokkaa);
		
		mntmEtsi = new JMenuItem("Etsi");
		mntmEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodeja.etsiSana();
			}
		});
		mnMuokkaa.add(mntmEtsi);
		
		mntmKorvaa = new JMenuItem("Korvaa");
		mntmKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				metodeja.korvaaSana();
			}
		});
		mntmKorvaa.setIcon(new ImageIcon(tekstieditoriGUI.class.getResource("/replace_Icon.png")));
		mnMuokkaa.add(mntmKorvaa);
		
		mnTietoja = new JMenu("Tietoja");
		menuBar.add(mnTietoja);
		
		mntmTietojaSovelluksesta = new JMenuItem("Tietoja sovelluksesta");
		mntmTietojaSovelluksesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tietojaIkkuna tietojaSovelluksesta = new tietojaIkkuna();
				tietojaSovelluksesta.setVisible(true);
			}
		});
		mnTietoja.add(mntmTietojaSovelluksesta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodeja.lataaTiedosto();
			}
		});
		btnNewButton.setIcon(new ImageIcon(tekstieditoriGUI.class.getResource("/load_Icon.png")));
		toolBar.add(btnNewButton);
		
		btnNewButton_1 = new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodeja.tallennaTiedosto();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(tekstieditoriGUI.class.getResource("/save_Icon.png")));
		toolBar.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton();
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				metodeja.korvaaSana();
			}
			});
		btnNewButton_2.setIcon(new ImageIcon(tekstieditoriGUI.class.getResource("/replace_Icon.png")));
		toolBar.add(btnNewButton_2);
		
		editorPane = new JEditorPane();
		contentPane.add(editorPane, BorderLayout.CENTER);
	}

}
