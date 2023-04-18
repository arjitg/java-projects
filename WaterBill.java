package ICH;

import javax.swing.*;

public class WaterBill {
	
	public static void main(String[] args) {
		
		// declare variables and constants
		final double BASE_CHARGE_SINGLE_FAMILY = 13.21;
		final double BASE_CHARGE_DUPLEX = 15.51;
			
		String custName = "";
		int custNumber = 0, gallons = 0, custType = 0;
		double billValue = 0;
		int noOfCustomers = 0;
		String output = "Water Bill:";
		output += "\n" + "Customer Type\tCustomer Number\tCustomer Name\tGallons\tBill Value\t";
		
		
		// declaring arrays
		String[] custInfoArr;
		double[] billArr;
		
		//obtain number of customers
		int option = JOptionPane.YES_OPTION; // = 0
		while(true) {
		   try {
			
			   noOfCustomers = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Customers")); 
			    // Input validation
				if (noOfCustomers <= 0) 
					throw new Exception();
								
				break;
												
			  } catch(Exception ex) {
					option = JOptionPane.showConfirmDialog(null, "Invalid Number of Customers Input \n Would You Like To Try Again?");
					if (option != JOptionPane.YES_OPTION)
					      System.exit(0);
			 }// end try-catch
				
			}// end while
				
		// create the arrays with the size of the number of customers
		custInfoArr = new String[noOfCustomers];
		billArr = new double[noOfCustomers];
		
		// To Complete
		// read customers data and fill the arrays with that data
		// Start for-loop
		
		//Obtain user input - customer type
		//int option = JOptionPane.YES_OPTION; // = 0
		while(true) {
			   try {
					custType = Integer.parseInt(JOptionPane.showInputDialog("Enter Customer Type: "
							+ "\n0 - Single Family"
							+ "\n1 - Duplex")); 
						// Input validation
					
						
						if ((custType != 0) && (custType !=1)) 
							throw new Exception();
						
						break;
										
				} catch(Exception ex) {
					option = JOptionPane.showConfirmDialog(null, "Invalid Customer Type Input \n Would You Like To Try Again?");
					if (option != JOptionPane.YES_OPTION)
						System.exit(0);
				}// end try-catch
		
		}// end while
		
		
		// add customer type to the custTypeArr array at index i
		//To Complete
				
		//Obtain user input - customer number
		// option = JOptionPane.YES_OPTION; // = 0
		while(true) {
			try {
				
				custNumber = Integer.parseInt( JOptionPane.showInputDialog("Enter Customer Number: ") ) ;
				// check if the customer number is 6 digits
				if (String.valueOf(custNumber).trim().length()!=6)
					throw new NumberFormatException(); 

				break;
							
			} catch(Exception ex) {
				option = JOptionPane.showConfirmDialog(null, "Invalid Customer Number Input \n Would You Like To Try Again?");
				if (option != JOptionPane.YES_OPTION)
					System.exit(0);
		        }// end try-catch
         }// end while	
		
		//Obtain user input - customer name
		// option = JOptionPane.YES_OPTION; // = 0
		while(true) {
		      custName = JOptionPane.showInputDialog("Enter Customer Name:");
		      if(!custName.matches("[a-zA-Z]+")) {
		    	  option = JOptionPane.showConfirmDialog(null, "Invalid Customer Name Input \n Would You Like To Try Again?");
				  if (option != JOptionPane.YES_OPTION)
						System.exit(0);
		      } else
		    	  break;
	 	}// end while
		
		
		//Obtain user input - number of gallons used
		// option = JOptionPane.YES_OPTION; // = 0
		while(true) {
			try {
				gallons = Integer.parseInt( JOptionPane.showInputDialog("Enter Number of Gallons Used:") ) ;
				
				if (gallons < 0) 
					throw new Exception();
				break;
			
			
			} catch(Exception ex) {
				option = JOptionPane.showConfirmDialog(null, "Invalid Number Og Gallons Input \n Would You Like To Try Again?");
				if (option != JOptionPane.YES_OPTION)
					System.exit(0);
		        }// end try-catch
       }// end while	
		
		//Calculate the water bill amount
		//billValue = BASE_CHARGE + (gallons * 0.00253);
		switch(custType) {
		case 0: // Compute Water Bill For Single Family
			    if (gallons <= 7000)
			    	billValue = BASE_CHARGE_SINGLE_FAMILY + gallons * (2.04 / 1000);
			    else if (gallons <= 13000)
			    	billValue = BASE_CHARGE_SINGLE_FAMILY + 7000 * (2.04 / 1000) + 
			    	 (gallons - 7000) * (2.35 / 1000);
			    else
			    	 billValue = BASE_CHARGE_SINGLE_FAMILY + 7000 * (2.04 / 1000) + 
			    	 (13000 - 7000) * (2.35 / 1000) + (gallons - 13000) * (2.70 / 1000);
			
			   output+= "\nSingle Family \n-------------------------";
			   break;
			
		case 1: // Compute Water Bill For Duplex 
			
			if (gallons <= 9000)
		    	billValue = BASE_CHARGE_SINGLE_FAMILY + gallons * (1.97 / 1000);
		    else if (gallons <= 13000)
		    	billValue = BASE_CHARGE_SINGLE_FAMILY + 9000 * (1.97 / 1000) + 
		    	 (gallons - 9000) * (2.26 / 1000);
		    else
		    	 billValue = BASE_CHARGE_SINGLE_FAMILY + 9000 * (1.97 / 1000) + 
		    	 (13000 - 9000) * (2.26 / 1000) + (gallons - 13000) * (2.60 / 1000);
			output+= "\nDuplex \n-------------------------";
		
		}// end switch statement 
		
		//To Complete
		   // add value to the billArr array and custInfoArr at index i
		
		
	    // end of for-loop	
		
		
		//To Complete
		//	display the program output using the array data
		// Use for loop to read data from the arrays and add them to variable output format
		
		
		//To Complete
		// find the maximum bill value
		
		
		
		//To Complete
		// Add the maximum bill value info to the output, using the index value
		
		
		
		//To Complete
    	// find the minimum bill value
		
		
		// Add the minimum bill value info to the output, using the index value
		
		
		
		// Display the program output with statistics 
		JOptionPane.showMessageDialog(null, new JTextArea(output),"WATER BILL CALCULATOR",JOptionPane.INFORMATION_MESSAGE); 
		

	}// end main

}// end class
