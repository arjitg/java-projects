package PP2;

public class CreditCard {
	
	private long number;
	private String expDate;
	
	public CreditCard(long number, String expDate){
		this.number = number;
		this.expDate = expDate;
	}

	// add public setter/getter methods, and also the toString method
	
	public long getNumber() {
		return this.number;
	}

	public String getExpdate() {
		return this.expDate;
	}

	@Override
	public String toString() {
		return Payment.createHashCode(Long.toString(number)) + ", " + expDate;
	}
	
}
