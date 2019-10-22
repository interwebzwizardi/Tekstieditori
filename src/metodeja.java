import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;

public class metodeja {

	// METODEJA OHJELMAN ERI OSIA VARTEN

	// Ohjelman sulkeminen
	public static void lopeta() {
		System.exit(0);
	}

	// Tiedoston lataaminen ohjelman näkymään
	public static void lataaTiedosto() {

		JFileChooser valintaikkuna = new JFileChooser();
		valintaikkuna.showOpenDialog(null);
		String rivi = "";
		String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();

		try {

			Scanner lukija = null;
			File tiedosto = new File(uusiTiedosto);

			lukija = new Scanner(tiedosto);

			while (lukija.hasNextLine()) {
				rivi += lukija.nextLine() + "\n";
				System.out.println(rivi);
			}

		} catch (FileNotFoundException p) {
			System.out.println("Tiedostoa ei löydy.");
		}
		tekstieditoriGUI.editorPane.setText(rivi);
	}
	
	//Tiedoston tallentaminen
	public static void tallennaTiedosto() {
		
		JFileChooser valintaikkuna = new JFileChooser();
		valintaikkuna.showSaveDialog(null);
		
		String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
		
		try {
			
		PrintWriter writer = new PrintWriter(uusiTiedosto);
		String sisältö = tekstieditoriGUI.editorPane.getText();
		
		writer.println(sisältö);
		
		writer.flush();
		writer.close();
		
		
		}catch (Exception e) {
			System.out.println("Tiedoston tallentaminen epäonnistui.");
		}
	}
	
	//Sanojen etsiminen tiedostosta ja niiden korostaminen
	
	public static void etsiSana() {

		try {
			String hakusana = JOptionPane.showInputDialog("Aseta haettava sana:");
			
			//Muutetaan sisältö pieneksi jotta löydetään kaikki hakusanaa vastaavat tulokset tiedostosta
			String sisältöNormaalina = tekstieditoriGUI.editorPane.getText();
			String sisältöPieneksi = sisältöNormaalina.toLowerCase();
			tekstieditoriGUI.editorPane.setText(sisältöPieneksi);
			
			Document sisältö = tekstieditoriGUI.editorPane.getDocument();
			
			for (int index = 0; index + hakusana.length() < sisältö.getLength(); index++) {
				String osuma = sisältö.getText(index, hakusana.length());
				if (hakusana.equals(osuma)) {
					DefaultHighlighter.DefaultHighlightPainter highlightOn = new DefaultHighlighter.DefaultHighlightPainter(
							Color.YELLOW);
					tekstieditoriGUI.editorPane.getHighlighter().addHighlight(index, index + hakusana.length(),
							highlightOn);
				
				}
			}

		} catch (Exception e) {
			System.out.println("Toimintoa ei pystytty suorittamaan:");
			e.printStackTrace();
		}
	}
	
	//Sanojen etsiminen ja korvaaminen
	
	public static void korvaaSana() {
		
		//luodaan paneeli useampaa dialog box inputtia varten ja sen sisältämät elementit
		JPanel inputKentät = new JPanel();
		JTextField hakusanaField = new JTextField(20);
		JTextField korvaavaField = new JTextField(20);
		
		inputKentät.add(new JLabel("Hakusana:"));
		inputKentät.add(hakusanaField);
		inputKentät.add(new JLabel("Korvaava sana:"));
		inputKentät.add(korvaavaField);
		
		
		int input = JOptionPane.showConfirmDialog(null,inputKentät, "Anna hakusana ja sen korvaava sana:", JOptionPane.OK_CANCEL_OPTION);
		
		try {
			String hakusana = hakusanaField.getText();
			String korvaava = korvaavaField.getText();
			String sisältö = tekstieditoriGUI.editorPane.getText();
			sisältö = sisältö.toLowerCase();
			
			for (int index = 0; index + hakusana.length() < sisältö.length(); index++) {
				String osuma = tekstieditoriGUI.editorPane.getText(index, hakusana.length());
				if (hakusana.equals(osuma)) {
					
					String korvaaSanat = sisältö.replaceAll(hakusana, korvaava);
					tekstieditoriGUI.editorPane.setText(korvaaSanat);
				
				}
			}

		} catch (Exception e) {
			System.out.println("Toimintoa ei pystytty suorittamaan:");
			e.printStackTrace();
		}
		
	}
		
}