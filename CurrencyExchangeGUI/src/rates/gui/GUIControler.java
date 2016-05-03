package rates.gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import rates.classes.Lists;
import rates.classes.Rate;

public class GUIControler {
	
	private static ExchangeOfficeGUI main;
	private static Lists list;
	
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					list = new Lists();
					main = new ExchangeOfficeGUI();
					main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static LinkedList<Rate> returnList(){
		return Lists.getRates();
	}
		
	public static String open(){
		try {
			JFileChooser fc = new JFileChooser();
			int value = fc.showOpenDialog(main);
			
			if(value == fc.APPROVE_OPTION){
				return "Upload file: " + fc.getSelectedFile().getAbsolutePath()+ " \n";
			}
				return "";
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(main, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			return "";
		}
	}
	
	public static String save(){
		try {
			JFileChooser fc = new JFileChooser();
			int value = fc.showSaveDialog(main);
			
			if(value == fc.APPROVE_OPTION){
				return "Saved file: " + fc.getSelectedFile().getAbsolutePath() + " \n";
			}
			return "";
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(main, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			return "";
		}
	}

	public static void exit(){
		int value = JOptionPane.showConfirmDialog(main, "Do you want to exit the program?","Exit",JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(value == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	public static void about(){
		JOptionPane.showMessageDialog(main, "Name and surname: Ana Jacimovic\n ", "About author", JOptionPane.NO_OPTION);
	}
	
	public static void addToList(Rate r){
		Lists.addRate(r);	
	}
	public static void newRateGUI(){
		AddRateGUI addRate = new AddRateGUI();
		addRate.setVisible(true);
		addRate.setLocationRelativeTo(null);
	}

	public static void add(String sifra, String naziv, String prodajni, String kupovni, String srednji, String skraceniNaziv){
		main.write("New rate : " + sifra + " " + naziv + " " + prodajni + " " + srednji + " " + kupovni + " " + skraceniNaziv); 
		Rate r = new Rate(sifra, skraceniNaziv, Double.parseDouble(prodajni.trim()), Double.parseDouble(srednji.trim()), Double.parseDouble(kupovni.trim()), naziv);
		addToList(r);
		main.refreshTable(returnList());
	}
	
	public static void removeFromList(int index){
		Lists.removeRate(index);
	}
	
	public static void delete(){
		try {
			int value = main.returnRow();
			
			if(value == -1){
				JOptionPane.showMessageDialog(main, "Choose row which you want to delete.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int value1 = JOptionPane.showConfirmDialog(main, "Are you sure that you want to delete this row?", "Attention",JOptionPane.YES_NO_OPTION);
			
			if(value1 == JOptionPane.YES_OPTION){
				removeFromList(value);
				main.refreshTable(returnList());
				main.write(value + ". row is deleted!");
			}
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(main, "Error!" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void exchangeGUI(){
		ExchangeGUI exchangeGUI = new ExchangeGUI();
		exchangeGUI.setVisible(true);
		exchangeGUI.setLocationRelativeTo(null);
	}

	public static void change(String s) {
		if(!s.isEmpty())
			main.write("Made replacement: " + s);	
	}
}