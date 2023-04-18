//Name: Arjit Gupta
//Date: 30th March 2023
//Assignment: PA03

package PA03;

import java.util.Date;

public abstract class Ticket implements BaseTicket{

	/* Instance variable declaration*/
	protected String ticketNumber;
	protected double ticketCost;
	protected Date purchaseDate;

	/* Default constructor*/
	Ticket()
	{
		/*Fill in to instantiate only the purchase date variable
			Note that this is the only class that has date variable and
			date package*/
		purchaseDate = new Date();
	}

	/*getter methods*/
	public String getTicketNumer()
	{
		return this.ticketNumber;
	}

	public Date getPurchaseDate()
	{
		return this.purchaseDate;
	}

	@Override //method to print ticket number and ticket cost
	public String toString()
	{
		return this.ticketNumber + "\t$" + this.ticketCost;
	}
}
