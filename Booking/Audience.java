//Name: Arjit Gupta
//Date: 30th March 2023
//Assignment: PA03

package PA03;

/*Audience class to perform manipulations on Ticket class objects*/
public class Audience implements Comparable<Audience> {

	/* Instance variable declaration*/
	private String name;
	private Ticket ticket;
	private static int noOfAudience;

	/*default constructor*/
	public Audience() {
		//Fill in
		System.out.println("Created a audience instance");
	}

	/*parameterized constructor*/
	public Audience(String name, Ticket ticket) {
		this.name = name;
		this.ticket = ticket;
		noOfAudience++;
	}

	/*Getter and setter methods*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ticket getticket() {
		return this.ticket;
	}

	public void setticket(Ticket ticket) {
		this.ticket = ticket;
	}

	public static int getNoOfAudience() {
		return noOfAudience;
	}

	@Override //method to name and ticket object details
	public String toString() {
		return name + "\t" + this.ticket.toString();
	}

	@Override //method to compare the ticket cost of 2 objects
	public int compareTo(Audience Audience) {
		int result = 0;
		if(this.ticket.ticketCost > Audience.ticket.ticketCost){
			result = 1;
		}
		if(this.ticket.ticketCost < Audience.ticket.ticketCost){
			result = -1;
		}
		return result;
	}
}
