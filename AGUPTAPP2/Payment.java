package PP2;

import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.io.FileNotFoundException;

public class Payment {

	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;

	// this will check whether a card is valid
	public static Boolean isValidCard(String number){
		return validating.aValidNumber(number);
	}

	// creates a hash code for the credit card number to be stored in file
    public static String createHashCode(String number){
		return hashing.getHashCode(number);
	}


     // it adds a new customer to the array of customers once the payment was successful
 	public static void addCustomer(Customer customer){
		customers[Customer.getNoOfCustObjects()-1] = customer;
 	}


	// it displays the payments AVG, MAX payment, and MIN payment,
	// only for accepted payments with valid cards
	public static void displayStat(){
		double avgAmount = 0, maxPayment = Double.MIN_VALUE, minPayment = Double.MAX_VALUE, custAmount;
		
		for (int i=0; i<Customer.getNoOfCustObjects(); i++){
			custAmount = customers[i].getAmount();
			maxPayment = Math.max(maxPayment, custAmount);
			minPayment = Math.min(minPayment, custAmount);
			avgAmount = avgAmount + custAmount;
		}

		avgAmount = avgAmount/Customer.getNoOfCustObjects();

		String stats = "Statistics\n";
		stats += "Average Payment Amount: $"+avgAmount+"\n";
		stats += "Maximum Payment Amount: $"+maxPayment+"\n";
		stats += "Minimum Payment Amount: $"+minPayment+"\n";

		JOptionPane.showMessageDialog(null, new JTextArea(stats));

	}


	// write data to file, the credit card number should be encrypted
	// using one-way hash method in the Hashing class
    public static void writeToFile() throws FileNotFoundException{

		File file = new File("Customer.txt");
	    PrintWriter write = new PrintWriter(file);
		
		String out = "";
		for (int i=0; i<Customer.getNoOfCustObjects(); i++){
			out += customers[i].toString();
			out += "\n";
		}
		
	    // Write formatted output to the file and close it
	    write.print(out);
	    write.close();
	    
	    JOptionPane.showMessageDialog(null, "Done Storing Customer Data into a File");

    } // end of the writeToFile method


	// the main entry method of the program that will get data from user and
	// perform the business logic
	public static void main(String[] args) {

		int id;
		String fName, lName, cardNumber, cardExpiry;
		double amount;
		Customer cust;
		hashing = new HashCode();
		validating = new Validation();

		// testing code
		// while(true){
		// 	cardNumber = DataEntries.strInput("Please enter card number");
		// 	if(!isValidCard(cardNumber)){
		// 		System.exit(0);
		// 	}
		// 	else{
		// 		JOptionPane.showMessageDialog(null, new JTextArea("Valid"));
		// 	}
		// }

		int n = DataEntries.intInput("Please enter the number of customers"); // must hold the number of customers based on the user input
		customers = new Customer[n];

		for(int i=0; i<n; i++){
			id = DataEntries.intInput("Please enter an ID");
			if(id == 0){
				//exit out of loop
				break;
			}

			fName = DataEntries.strInput("Please enter first name");
			lName = DataEntries.strInput("Please enter last name");
			cardNumber = DataEntries.strInput("Please enter card number");

			if(isValidCard(cardNumber)){
				cardExpiry = DataEntries.strInput("Please enter expiry date for the card");
				CreditCard card = new CreditCard(Long.parseLong(cardNumber), cardExpiry);

				amount = DataEntries.doubleInput("Please enter amount for payment");

				cust = new Customer(fName, lName, id, amount, card);
				addCustomer(cust);
			}
			else{
				//do you want to continue
				int choice = JOptionPane.showConfirmDialog(null,"Card " + cardNumber + " is invalid. Would You Like to Continue!");
				
				if (choice !=0){
					System.exit(0);
				} else {
					continue;
				}
			}
		}

		displayStat();
		try {
			writeToFile();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, new JTextArea("An error occured while writing to file."));
		}
	}
}
