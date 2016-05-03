package rates.gui;

import java.awt.EventQueue;
import java.util.LinkedList;

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
	
}