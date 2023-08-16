package ClassMethods;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class WaterBill {

	// class variables and constants - Accessed in all class methods
	static String output= "";
	final static double BASE_CHARGE_SINGLE_FAMILY = 13.21 ;
	final static double BASE_CHARGE_DUPLEX = 15.51;
	static Date billDate = null;

	// main method
	public static void main(String[] args) throws FileNotFoundException {

		// declare variables and constants
		double gallons = 0;
		String custName = null;
		int custNumber = 0;
		int custType=0;
		String customerTypeStr = null; //newly added
		int noOfCustomers=0;
		String input = null;
		boolean continueInput = true;

		// declaring arrays
		String[] custInfoArr;
		double[] billArr;


		// Enter number of customers - Use the Validation Methods in class DataEntries
		noOfCustomers = DataEntries.intInput("Input No of Customers");

		//initialize arrays with size
		// File has 6 customers data
		billArr=new double[noOfCustomers+6];
		custInfoArr=new String[noOfCustomers+6];

		// Update the output variable before sorting arrays
		billDate  = new Date();
		output+="Water Bill Date:  " + billDate;
		output+="\nNAME\tTYPE\tNUMBER\tGALLON\tBILL VALUE";
		output+="\nBefor Sorting Arrays:";


		// read from file, the method is incomplete
		readFromFile(billArr,custInfoArr, "inputWaterBill.txt");

		// loop receiving the customer data
		for(int i=6;i<billArr.length;i++) {


			//input customer rate - Use the Validation Methods in class DataEntries
			custType = DataEntries.intInputChoice(1, 2, "Input Customer Type:" +
					"\n1 - Single Family Bill" + "\n2 - Duplex Bill");

			// Change the entry code to String instead
			if(custType==1)
				customerTypeStr="Single";
			else
				customerTypeStr="Duplex";

			// Input Customer Number - Use the Validation Methods in class DataEntries
			custNumber = DataEntries.intInputSize(6, "Input Customer Number");

			// Enter customer name - Use the Validation Methods in class DataEntries
			custName = DataEntries.strInput("Input Customer Name");


			// Enter number of gallons - Use the Validation Methods in class DataEntries
			gallons = DataEntries.doubleInput("Input Number of Gallons");


			// compute customer bill
			switch (custType) {
			case 1:
				// fill the billArr with data
				billArr[i]=singleFamilyBill(gallons);
				break;
			case 2:
				// fill the billArr with data
				billArr[i]=duplexBill(gallons);
				break;
			}//end of switch

			// fill the custInfoArr with data
			custInfoArr[i]= custName+"\t"+customerTypeStr+"\t"+ custNumber+"\t"+ gallons;

			// Update the output variable
			output+="\n"+custInfoArr[i]+"\t$"+String.format("%.2f", billArr[i]);

			// loop again to read another customer data

		}//end of for loop - End reading Customers Data


		//Displays output before sorting-Call displayBill() method
		displayBill();

		// Finds the of the maximum bill value - Incomplete
		maxValue(billArr, custInfoArr);

		// Finds the of the minimum bill value - Incomplete
		minValue(billArr, custInfoArr);

		// finds the bill value average - Incomplete
		avgValue(billArr);

		//Display output before sorting-Call method displayBill()
		displayBill();

		//Sort custInfoArr array and bill array based on billValue-selection sort
		sortBill(billArr, custInfoArr);

		//Display output after sorting-Call displayBill() method
		displayBill();

		// Write data to output file - Incomplete
		writeToFile("WaterBillOutput.txt");

	}//end of main

	// computes the Single Family water bill
	public static double singleFamilyBill(double gallons) {

		double value;

		if (gallons <= 7000)
			value = BASE_CHARGE_SINGLE_FAMILY +
			gallons * 2.04 / 1000;
		else if (gallons <= 13000)
			value = BASE_CHARGE_SINGLE_FAMILY +
			7000 * 2.04 / 1000 + (gallons - 7000) * 2.35 / 1000;
		else
			value = BASE_CHARGE_SINGLE_FAMILY +
			7000 * 2.04 / 1000 + 6000 * 2.35 / 1000 +
			(gallons - 13000) * 2.70	 / 1000;

		return value;

	}// end singleFamilyBill()

	// computes the Duplex water bill
	public static double duplexBill(double gallons) {
		double value;
		if (gallons <= 9000)
			value = BASE_CHARGE_DUPLEX + gallons *
			1.97	 / 1000;
		else if (gallons <= 13000)
			value = BASE_CHARGE_DUPLEX + 9000 * 1.97 / 1000 +
			(gallons - 9000) * 2.26 / 1000;
		else
			value = BASE_CHARGE_DUPLEX + 9000 * 1.97 / 1000 +
			4000 * 2.26 / 1000 + (gallons - 13000) * 2.60
			/ 1000;
		return value;
	}

	// This is the sorting method of two arrays - billArr and custInfoArr
	public static void sortBill(double[] billArr, String[] custInfoArr) {

		int i,j;

		for (i = 0; i < billArr.length - 1; i++) {

			int currentMinIndex = i;
			double currentMin = billArr[i];
			String currentMinInfo=custInfoArr[i];


			for(j=i+1;j<billArr.length;j++) {
				if(billArr[j]<currentMin) {
					currentMin=billArr[j];
					currentMinInfo=custInfoArr[j];
					currentMinIndex=j;
				}//end if
			}//end inner for

			//swap billArr[i] and billArr[currentMinIndex] if necessary
			if(currentMinIndex!=j) {
				billArr[currentMinIndex]=billArr[i];
				billArr[i]=currentMin;

				custInfoArr[currentMinIndex]=custInfoArr[i];
				custInfoArr[i]=currentMinInfo;

			}
		}//end outer for

		JOptionPane.showMessageDialog(null, "Completed Sorting Arrays");

		//Update the output variable after Sorting
		output+="\nAfter Sorting Arrays:";
		for(i=0;i<billArr.length;i++)
			output+="\n"+custInfoArr[i]+"\t$"+String.format("%.2f", billArr[i]);
	}//end of method sortArray

	// Displays the program output - Displays the output variables
	public static void displayBill() {

		JOptionPane.showMessageDialog(null, new JTextArea(output));

	}// end of method displayBill

	// Complete this method to find the the maximum bill value, maxValue()
	public static void maxValue(double[] billArr, String[] custInfoArr) {

		double max = billArr[0];
		int index = 0;
		// complete the code to find index for the maximum bill value
		// Use code from
		for (int i =1; i < billArr.length; i++)
			if (max < billArr[i]) {
				max = billArr[i];
				index = i;
			}// end if


		// Add the maximum bill value info to the output, using the index
		output+= "\nMax Bill Value------------------------------------";
		output+="\n"+custInfoArr[index]+"\t$"+String.format("%.2f", billArr[index]);


		// complete - call displayBill() to display the output
		displayBill();

	}// end maxValue()


	// Complete this method to find the the minimum bill value, maxValue()
	public static void minValue(double[] billArr, String[] custInfoArr) {

		double min = billArr[0];
		int index = 0;
		// complete the code to find index for the minimum bill value
		// Use code from ICE2
		for (int i =1; i < billArr.length; i++)
			if (min > billArr[i]) {
				min = billArr[i];
				index = i;
			}// end if


		// Add the minimum bill value info to the output, using the index
		output+= "\nMin Bill Value------------------------------------";
		output+="\n"+custInfoArr[index]+"\t$"+String.format("%.2f", billArr[index]);

		// call displayBill() to display the output
		displayBill();

	}// end maxValue()


	// Complete this method to find bill value average, avgValue()
	public static void avgValue(double[] billArr) {

		double avg = 0, sum =0;
		// complete the code to find bill value average
		for(int i =0; i < billArr.length; i++)
			sum+=billArr[i];

		avg = sum / billArr.length;

		// Add the average of the bill values info to the output
		output+= "\nAverage Bill Value------------------------------------";
		output+="\nAverage Bill Value= " + String.format("%.2f",avg);


		// call displayBill() to display the output
		displayBill();

	}// end avgValue()


	// read from file and add data to arrays
	public static void readFromFile(double[] billArr, String[] custInfoArr, String fileName) throws FileNotFoundException {

		// read data from inputWaterBill, (week 03 files)
		// Create a File instance
		File fileInput = new File(fileName);

		// Create a Scanner for the file
		Scanner sc = new Scanner(fileInput);

		// Read data from a file, the data fields are separated by ','
		int i=0;
		while(sc.hasNext()) {
			// Complete code to read data from file, line by line
			String line = sc.nextLine();
			String[] cust = line.split(",");

			if (Integer.parseInt(cust[1].trim()) == 1) {

				custInfoArr[i] = cust[0].trim() + "\t" + "SingleFamily" +
						"\t" + cust[2].trim() + "\t" + cust[3].trim();
				billArr[i] = singleFamilyBill(Double.parseDouble(cust[3].trim()));

			} else if (Integer.parseInt(cust[1].trim()) == 2) {

				custInfoArr[i] = cust[0].trim() + "\t" + "Duplex" +
						"\t" + cust[2].trim() + "\t" + cust[3].trim();
				billArr[i] = duplexBill(Double.parseDouble(cust[3].trim()));
			}// end if

			// Update the output variable with the array data
			output+="\n"+custInfoArr[i]+"\t$"+String.format("%.2f", billArr[i]);

			// Increment i for the next line in the file
			i++;

		}// end while


		// Close the file
		sc.close();

		JOptionPane.showMessageDialog(null, "Completed Reading Data from File \"inputWaterBill.txt\"");

	}// end read methods


	// writes the program output to file
	public static void writeToFile(String fileName) throws FileNotFoundException {

		// write the program data into file (week 03 files)
		// Create a file
		File file = new File(fileName);

		// write data to file
		PrintWriter of = new PrintWriter(file);


		// write data into file
		of.print(output);

		// Close the file
		of.close();

		JOptionPane.showMessageDialog(null, "Completed Writing Data to File \"output.txt\"");

	}// end writeToFile


}//end of class
