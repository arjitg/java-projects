//Name: Arjit Gupta
//Date: 30th March 2023
//Assignment: PA03

package PA03;

// import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.lang.Math;

public class TicketTest {

	/*Array of Audience object*/
	static Audience[] audienceList;
	static int indexTracker = 0;

	public static void main(String[] args) {

		/*Input variable declaration and initialization*/
		String name = "";
		int noOfAdvancedays = 0;
		int numberOfAudience = 0;
		int status = 0;
		String studentID="";
		String ticketNumber = "";

		/*Get number of audience and create the Audience array*/
		numberOfAudience = DataEntries.intInput("Enter the number of audience");
		audienceList = new Audience[numberOfAudience];

		/*Loop over no of audience to create appropriate ticket objects*/
		for (int i = 0; i < numberOfAudience; i++) {
			ticketNumber = String.valueOf((int)(Math.random()*1000));
			name = DataEntries.strInput("Enter Audience name");
			noOfAdvancedays = DataEntries.intInput("Enter Number of Days before the event");
			if(noOfAdvancedays == 0){
				addWalkupTicket(name, ticketNumber);
			}
			else{
				int isStudent = DataEntries.intInputRange(0, 1, "Are you a student? 1:Yes 0:No");
				if(isStudent == 1){
					studentID = DataEntries.strInput("Enter student ID");
					status = DataEntries.intInputRange(0, 1, "Are you an oncampus student? 1:Yes 0:No");
					if(status == 1){
						addOncampusAdvanceTicket(name, ticketNumber, noOfAdvancedays, studentID);
					}
					else{
						addOffcampusAdvanceTicket(name, ticketNumber, noOfAdvancedays, studentID);
					}
				}
				else{
					addAdvancedTicket(name, ticketNumber, noOfAdvancedays);
				}
			}
		}

		display(); // display the unsorted list of audience details
		selectionSort(); // sort the list based on ticketPrice
		display(); //display the sorted list
		writeToFile(); //write the sorted list to output file
	}

	/*Method to create Advanced Ticket object and add to audience array*/
	private static void addAdvancedTicket(String name, String ticketNumber, int days) {
		Ticket advTicket = new AdvancedTicket(ticketNumber, days);
		Audience aud = new Audience(name, advTicket);
		audienceList[indexTracker] = aud;
		indexTracker++;
	}

	/*Method to create Off campus Advanced Ticket object and add to audience array*/
	private static void addOffcampusAdvanceTicket(String name, String ticketNumber, int days, String ID) {
		Ticket offCampusAdvTicket = new OffcampusStudentAdvanceTicket(ticketNumber, days, ID);
		Audience aud = new Audience(name, offCampusAdvTicket);
		audienceList[indexTracker] = aud;
		indexTracker++;
	}

	/*Method to create On campus Advanced Ticket object and add to audience array*/
	private static void addOncampusAdvanceTicket(String name, String ticketNumber, int days, String ID) {
		Ticket onCampusAdvTicket = new OncampusStudentAdvanceTicket(ticketNumber, days, ID);
		Audience aud = new Audience(name, onCampusAdvTicket);
		audienceList[indexTracker] = aud;
		indexTracker++;
	}

	/*Method to create Walkup Ticket object and add to audience array*/
	public static void addWalkupTicket(String name, String ticketNumber){
		Ticket walkUpTicket = new WalkupTicket(ticketNumber);
		Audience aud = new Audience(name, walkUpTicket);
		audienceList[indexTracker] = aud;
		indexTracker++;
	}

	/*Method to display audience object details*/
	public static void display(){
		  
		String out = "Name\t" + "Ticket Number\t" + "Ticket Price\t" + "Date\t" +
		"Days Advance\t" + "Student ID\t" + "Is on-campus";

		for (int i=0; i<audienceList.length; i++){
			out += "\n" + audienceList[i].toString();
		}

		// display the result 
		JOptionPane.showMessageDialog(null, new JTextArea(out));
	}

	/*Method to sort audience object based on ticketCost using compareTo() method*/
	public static void selectionSort() {
		Sort.selectionSortAudience(audienceList);
		JOptionPane.showMessageDialog(null, "Audience sorted by ticket prices");
	}

	/*Method to write audience object details into an output file*/
	public static void writeToFile() {
		try {
			WriteData.writeToFile(audienceList, "Audience.txt");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed writing data due to error: "+e.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Completed writing data to file");
	}
}
