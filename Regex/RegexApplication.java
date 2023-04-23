// Name: Arjit Gupta
package PA4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class RegexApplication {
	
	// declare the class variables
	private static final String inputFileName 		= "RetailStore.txt";
	private static final String outputFileName 		= "matcherout.txt";
	
	private static String itemRegex = null;
	private static Parser parser = null; 

	// This method receives a text string and stores it in an output file
	private static void writeToFile(String productsString) throws FileNotFoundException {
		File file = new java.io.File(outputFileName);
		// Define a PrintWriter object to store the program output
		PrintWriter output = new java.io.PrintWriter(file);
	
		// write data to file
		output.print(productsString);
	
		// Close the file
		output.close();
	
	}// end of writeToFile method

	
	//This method receives a collection of product objects stored in an array list as a parameter
	// and it returns the concatenate the products� information (title and retailPrice) into a single string
	private static String getProductsAsString(ArrayList<Product> products) {
		String outputString = "";
		for(int i=0; i<products.size(); i++){
			outputString += products.get(i).toString();
		}

		return outputString;
	}// end of getProductsAsString method
	
	
	// This the the entry method that uses the created classes and methods to run the program 
	public static void main(String[] args) throws FileNotFoundException {
		// Define the 'itemRegex' regex for the Product Title and Suggested Retail Price
		itemRegex = "<h2 data-attribute=\".*\" class=\"a-size-base.*Suggested Retail Price: .*\" class=\"a-size-small";
		// Create a Parser object
		parser = new Parser(itemRegex);
		
		// use the Parser object to call method parse() to parse the content of the retail store file and returns the ArrayList of the Product objects
		ArrayList<Product> products = parser.parse(inputFileName);
		
		// call method getProductsAsString() to return the string of the ArrayList
		String finalOutput = getProductsAsString(products);
		finalOutput += "\nNumber of items: "+products.size();
		
		// call writeToFile() to store the program output to a file
		writeToFile(finalOutput);
		
		// display the output using JOptionPane.showMessageDialog
		JOptionPane.showMessageDialog(null, new JTextArea(finalOutput));
		
	}// end of main method
}
