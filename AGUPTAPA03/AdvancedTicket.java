//Name: Arjit Gupta
//Date: 30th March 2023
//Assignment: PA03

package PA03;

public class AdvancedTicket extends Ticket{

	/* Instance variable declaration*/
	protected int noOfDaysInAdvance;

	/* Default constructor*/
	AdvancedTicket()
	{
		/*Fill in to instantiate only the purchase date variable
			Note that this class does not have date variable nor
		date package*/
		//It will be auto instantiated from invoking super implicitly
	}

	/*parameterized constructor*/
	public AdvancedTicket(String number, int days)
	{
		/*Fill in to instantiate the 1. purchase date variable
		2. ticket number
		3. days
		4. ticketprice using ticket calculation */
		this.ticketNumber = number;
		this.noOfDaysInAdvance = days;
		calculateTicket();
	}

	/*getter method*/
	public int getNoOfDaysInAdvance()
	{
		return this.noOfDaysInAdvance;
	}

	/*ticket calculation*/
	public void calculateTicket()
	{
		//fill in to calculate ticket cost based on number of days
		this.ticketCost = noOfDaysInAdvance>10 ? 30 : 40;
	}

	@Override //overrided method to print the object details
	public String toString()
	{
		return this.ticketNumber + "\t$" + this.ticketCost + "\t" + this.purchaseDate.toString() + "\t" + this.noOfDaysInAdvance;
	}
}
