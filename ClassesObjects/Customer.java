package ClassesObjects;

public class Customer {
	//data fields, attributes, properties
	private String name;
	private int number;
	private WaterBill bill;

	//class variables
	private static int noOfCustObjects;

	public Customer(String name, int number, WaterBill bill) {
		this.name = name;
		this.number = number;
		this.bill = bill;
		noOfCustObjects++;
	}

	Customer(){
		this("",0,null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public WaterBill getBill() {
		return bill;
	}

	public void setBill(WaterBill bill) {
		this.bill = bill;
	}

	public static int getNoOfCustObjects() {
		return noOfCustObjects;
	}

	@Override
	public String toString() {
		return name + "\t" + number + bill.toString();
	}








}
