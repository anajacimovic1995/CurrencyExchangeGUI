package rates.classes;

public class Rate {
	
	private String code;
	private String name;
	private String abbreviatedName;
	private double sales;
	private double medium;
	private double purchasable;
	
	public Rate(String code, String abbriviatedName, double sales, double medium, double purchasable, String name) {
		this.code = code;
		this.abbreviatedName = abbriviatedName;
		this.sales = sales;
		this.medium = medium;
		this.purchasable = purchasable;
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		if(code==null || code.isEmpty())
			throw new NullPointerException("String is invalide.");
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name==null || name.isEmpty())
			throw new NullPointerException("String is invalide.");
		this.name = name;
	}
	public String getAbbreviatedName() {
		return abbreviatedName;
	}
	public void setAbbreviatedName(String abbreviatedName) {
		if(abbreviatedName==null || abbreviatedName.isEmpty())
			throw new NullPointerException("String is invalide.");
		this.abbreviatedName = abbreviatedName;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		if(sales<=0)
			throw new IllegalArgumentException("Sales is 0 or negative number!");
		this.sales = sales;
	}
	public double getMedium() {
		return medium;
	}
	public void setMedium(double medium) {
		if(medium<=0)
			throw new IllegalArgumentException("Medium is 0 or negative number!");
		this.medium = medium;
	}
	public double getPurchasable() {
		return purchasable;
	}
	public void setPurchasable(double purchasable) {
		if(purchasable<=0)
			throw new IllegalArgumentException("Purchasable is 0 or negative number!");
		this.purchasable = purchasable;
	}
	
	
}
