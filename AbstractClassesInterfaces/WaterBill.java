package AbstractClassesInterfaces;

import java.util.Date;

public class WaterBill {

	// data fields
	private int gallons;
	protected double value;
	private Date createdDate;

	// Class variables and constants
	// defined in interface BaseCharge



	// constructors
	WaterBill(){
		this.createdDate = null;
		this.gallons = 0;
		this.value = 0;
	}

	WaterBill(int gallons) {
		this.gallons = gallons;
		this.createdDate = new Date();
	}

	public int getGallons() {
		return gallons;
	}

	public void setGallons(int gallons) {
		this.gallons = gallons;
	}

	public double getValue() {
		return value;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void computeBill() {
		// the code of this method is implemented in the sub-classes
	}

}// end
