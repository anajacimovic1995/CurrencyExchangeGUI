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
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
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
			int povratnaVrednost = fc.showOpenDialog(main);
			
			if(povratnaVrednost == fc.APPROVE_OPTION){
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
		JOptionPane.showMessageDialog(main, "Name and surname: Ana Jacimovic\n ", "About", JOptionPane.NO_OPTION);
	}
	
}