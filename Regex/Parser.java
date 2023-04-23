// Name: Arjit Gupta
package PA4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {	
	// class variables 
	private Pattern itemPattern;
	private ArrayList<Product>  products;
	
	// define the class constructor 
	public Parser(String itemRegex) {
		// create the Pattern object from itemRegex
		this.itemPattern = Pattern.compile(itemRegex, 0);
		this.products = new ArrayList<>();		
	}// end of the constructor
	
	// reads a text file whose name is given as a parameter and returns the file contents in a string format
	private String getFileContents(String fileName) throws FileNotFoundException {
		String data = "";
		File file = new java.io.File(fileName);
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
	    	data += input.nextLine() + "\n";
	    }
	    
		input.close();
	    return data;
		
	}// end of getFileContent method
	
	// parses a text file whose name is given as a parameter 
	// and returns the parsed products as Product objects stored in an array list
	public ArrayList<Product> parse(String fileName) throws FileNotFoundException {
		String fileData = getFileContents(fileName);
		Matcher m = this.itemPattern.matcher(fileData);

		while (m.find()){
			String myString = fileData.substring(m.start(), m.end());
			String s1 = myString.replace("<h2 data-attribute=\"", "");
			String s2 = s1.replaceAll("\" class=\"a-size-base.*Suggested Retail Price: .", "!");
			String s3 = s2.replaceAll("\" class=\"a-size-small", "");
  
			String[] sArray = s3.split("!");
			String itemName = sArray[0];
			String itemPrice = sArray[1];
			this.products.add(new Product(itemName, itemPrice));
		}
		return this.products;
	}// end of parse method
}

