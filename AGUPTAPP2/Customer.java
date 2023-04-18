package PP2;


public class Customer {
	
	private int id;
	private String fName, lName;
	private double amount;
	private CreditCard card;
	private static int noOfCustObjects = 0;
	
	public Customer(String fName, String lName, int id, double amount, CreditCard card) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.amount = amount;
		this.card = card;
		noOfCustObjects++;
		
	}

	public String getName() {
		return this.fName + " " + this.lName;
	}

	public void setName(String fname, String lname) {
		this.fName = fname;
		this.lName = lname;
	}

	public double getAmount(){
		return this.amount;
	}

	public static int getNoOfCustObjects() {
		return noOfCustObjects;
	}

	@Override
	public String toString() {
		return id + ", " + fName + " " + lName + ", " + ", " + amount + ", " + card.toString();
	}

}
