// Name: Arjit Gupta
package PA4;

public class Product {
	//instance variables
	private String title;
	private String retailPrice;
	
	// declare the class constructor
	public Product(String title, String retailPrice){
		this.title = title;
		this.retailPrice = retailPrice;
	}
	
	// define the toString() method to return the Product object data as shown in the PA04 document
	public String toString(){
		return "Title: "+this.title+"; Suggested Retail Price: $"+this.retailPrice+"\n";
	}
	
}// end of class Product
