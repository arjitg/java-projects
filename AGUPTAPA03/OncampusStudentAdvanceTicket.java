//Name: Arjit Gupta
//Date: 30th March 2023
//Assignment: PA03

package PA03;

public class OncampusStudentAdvanceTicket extends AdvancedTicket {

	/* Instance variable declaration*/
	private String studentID;
	private boolean status;

	/*parameterized constructor*/
	public OncampusStudentAdvanceTicket(String number, int days, String ID)
	{
		/*Fill in to instantiate the 1. purchase date variable
		2. ticket number
		3. days
		4. student ID
		5. student status
		6. ticketprice using ticket calculation
		*/
		this.ticketNumber = number;
		this.noOfDaysInAdvance = days;
		this.studentID = ID;
		this.status = true;
		calculateTicket();
	}

	/*getter methods*/
	public String getStudentID()
	{
		return this.studentID;
	}

	public boolean getStatus()
	{
		return this.status;
	}

	/*ticket calculation*/
	public void calculateTicket()
	{
		/*fill in to calculate ticket cost based on number of days
		Make sure to include the base charges*/
		this.ticketCost = noOfDaysInAdvance>10 ? (15+onCampusBaseCharge):(20+onCampusBaseCharge);
	}

	@Override //overrided method to print the object details
	public String toString()
	{
		return this.ticketNumber + "\t$" + this.ticketCost + "\t" + this.purchaseDate.toString() + "\t" + + this.noOfDaysInAdvance + "\t" + this.studentID + "\t" + this.status;
	}
}
