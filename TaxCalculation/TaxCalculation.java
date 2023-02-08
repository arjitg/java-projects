import javax.swing.JOptionPane;

public class TaxCalculation  {

	public static void main(String[] args) {
		// I'm gonna edit something in this file so that I can pull these changes and test the flow. Thnx
		// You have to get two input values for a person, which are income, and status.
		
		// First, let us show the example of how to get the input value of the income of the person using JOptionPane
		String incomeInputVaue =JOptionPane.showInputDialog("Enter income of one person. Enter value as a whole number, without any decimal, e.g., 15125");  
		//for the sake of simplicity, enter the income as a whole number (not a decimal number) in the input
		// There is no need to enter a comma in the income, but enter the income as 15125, or 67897 etc.
		// The code above gets the income value of the person income in the variable income.
		// However, this data type is String. In other words, even if the value of the data is indeed of type integer, the data type is String.
		// You can to convert the String data type to into double type.
		// use the parseDouble to convert String data type to double.
		// the data type is kept as double, because to calculate the tax, you have to multiply with values as 0.1 etc.
		double icomeInDouble=Double.parseDouble(incomeInputVaue);  
		// Now you have the income value in the variable icomeInDouble.
		// You will use the icomeInDouble for the tax calculation for the person. 
		
		// Next, let us show the example of how to get the status of the person.
		// The status of the person can be either Single, or Married.
		// Showing below how to get the input value of the status of the person using JOptionPane
		String statusInString =JOptionPane.showInputDialog("Enter status of person, Enter either the value of Single, or Married.");  
		// Next, you will use switch statement to convert the status to a value of either 0, or 1.
		// If the value entered in the input above input is Single, then assign a value of 0.
		// If the value entered in the input above Married, then assign a value of 1.
		// Create a new variable statusInInt to hold the status, and the data type of this new variable is int.
		int statusInInt = 0; // declare a variable for that, and initialize to a value
		// The value entered has to exactly match as Single (or Married) because the switch statement below looks for those values
		 switch(statusInString){	   
	            case "Single":
	            	statusInInt = 0;
	                break;
	            case "Married":
	            	statusInInt = 1;
	                break;
	            default:
	            	// Default section of the code is executed if the value entered does not match the above values
	                System.out.println("no match");
	        }
	
	// At this point, you have two variable, which are icomeInDouble and statusInInt for the person.
	// You will use these two variable for the tax calculation of the person.
	
	// Use if statement for calculating the tax.
	// Use the tax table to determine the tax of the person
	// You will write code using the if statement to decide the tax.
	double tax = 0; // initializing variable tax to a value
	if(statusInInt==0){
		// Write code to calculate the tax, based on the income, if status is Single
		if(icomeInDouble <8350 ){
			tax = icomeInDouble * 0.1 ;
		}else if(
				(icomeInDouble >=8351 && icomeInDouble<= 33950) ){
			// You will write code to calculate tax
		}
		// You will write code to calculate tax based on the otehr income slabs
		
	}else if(statusInInt==1){
		// Write code to calculate the tax, based on the income slab, if status is Married		
	}
	
	// Use JOptionPane to display the income, status, and the computed tax.
	// using the variable statusInString for the display purpose, instead of showing 0, or 1
	// The use of \n makes it to display each value in a new line
	JOptionPane.showMessageDialog(null, "Income = "+ icomeInDouble + "\n"+
									" Status = "+ statusInString  + "\n"+ 
									"Tax= " + tax);	
	}
}

