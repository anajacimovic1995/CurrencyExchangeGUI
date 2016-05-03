package rates.classes;

import java.util.LinkedList;


public class Lists {
	
	private static LinkedList<Rate> rates;
	
	public Lists() {
		this.rates = new LinkedList<Rate>();
		
	}

	public static LinkedList<Rate> getRates() {
		return rates;
	}

	public static void setRates(LinkedList<Rate> rates) {
		Lists.rates = rates;
	}
	
	public static void addRate(Rate r){
		if(r == null)
			return;
		
		rates.add(r);
	}
	
	public static void removeRate(int index){
		if(index < 0)
			return;
		
		rates.remove(index);
	}
}
