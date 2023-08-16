package InheritancePolymorphism;

import java.util.Date;

public class WaterBill {
	
	// Data fields
	private int gallons;
	protected double value;
	private Date createdDate;
	
	// Class variables and constants
	static final double BASE_CHARGE_SINGLE_FAMILY = 13.21;
	static final double BASE_CHARGE_DUPLEX = 15.51;
	
	// Constructors
	WaterBill(){
		this.gallons = 0;
		this.value = 0;
		this.createdDate = null;
		
	}

	public WaterBill(int gallons) {
		this.gallons = gallons;
		this.createdDate = new Date();
		this.computeBill();
	}

	public int getGallons() {
		return gallons;
	}

	public void setGallons(int gallons) {
		if (gallons > 0) {
		   this.gallons = gallons;
		  
		}
	}

	
	public double getValue() {
		return value;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	 void computeBill() {
		// this method is overridden in the subclasses
	}

	@Override
	public String toString() {
		/*
		 * if (custType == 1) return gallons + "\t" + String.format("%.2f", value) +
		 * "\t" + "SingleFamily" + "\t" + createdDate.toString(); else return gallons +
		 * "\t" + String.format("%.2f", value) + "\t" + "Duplex" + "\t" + createdDate;
		 */
		
		return "\n Water Bill Values";
	}
		

}// end class
