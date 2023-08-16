package WaterBillWithGUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;



public class WaterBillGUI extends JFrame implements ActionListener{
	
	// Array of customers 
	private Customer[] customers;
	
	// file name
	private String fileName;
	
	  // declare all UI components below
	  // UI Labels
	  private JLabel lblName;
	  private JLabel lblNumber;
	  private JLabel lblGallons;
	  
	  // UI TextFields   
	  private JTextField txtName;
	  private JTextField txtNumber;
	  private JTextField txtGallons;
	  
	  // UI Buttons
	  private JButton btnAdd;
	  private JButton btnClose;
	  private JButton btnSave;
	  private JButton btnSort;
	  
	  //UI TextArea & ScrollPane
	  private JTextArea textArea;
	  private JScrollPane jp;
	  
	  // UI RadioButtons
	  JRadioButton singleFamilyRbt ;
      JRadioButton duplexRbt;
      ButtonGroup groupRbt;

		      	
	// class constructor
	WaterBillGUI(String fileName, int noOfCustomers) throws FileNotFoundException{
			
		    this.fileName = fileName;
		
		    // create an array of customers
			int fileSize = getFileLength(this.fileName);
			customers = new Customer[noOfCustomers+fileSize];
	       
	        // call methods to do the layout
			initComponent();
			doTheLayout();
			
			// add buttons to the action listeners
			// To Complete
			this.btnAdd.addActionListener(this);
			this.btnSave.addActionListener(this);
			this.btnSort.addActionListener(this);
			this.btnClose.addActionListener(this);
			
			// call read data from file
			readFromFile(this.fileName);
			
		}// end WaterBillGUI

		private void initComponent(){
			
		// Initialize the GUI components
		// labels 
		// To Complete
		this.lblName = new JLabel("Name");
		this.lblNumber = new JLabel("Number");
		this.lblGallons = new JLabel("Gallons");
		
		// text fields 
		// To Complete
		this.txtName = new JTextField(20);
		this.txtNumber = new JTextField(10);
		this.txtGallons = new JTextField(10);
		
		this.txtName.setToolTipText("You must provide the customer name?");
			
			
		// radio buttons
		// To Complete
		this.singleFamilyRbt = new JRadioButton("Single Family", true);
	    this.duplexRbt = new JRadioButton("Duplex");
	    
		// radio buttons to ButtonGroup
		// To Complete	     
	    this.groupRbt = new ButtonGroup();
	    this.groupRbt.add(this.singleFamilyRbt);
	    this.groupRbt.add(this.duplexRbt);
	    
	    
		// buttons
		// To Complete	
		this.btnAdd = new JButton("Add");
		this.btnSort = new JButton("Sort");
		this.btnSave = new JButton("Save");
		this.btnClose = new JButton("Close");
	    
	    
		// define text area and add it to scroll pane
		// To Complete
		this.textArea = new JTextArea("Program Display\n", 10,30);
		this.jp = new JScrollPane(textArea);
		this.textArea.setEditable(false);
	  
		} // end initComponent

	   private void doTheLayout(){
			// Organize the components into GUI window
		    // declare top, center, centerTop, centerBottom, and bottom panels
		    // To Complete
		    JPanel top = new JPanel();
		    JPanel center = new JPanel();
		    JPanel centerTop = new JPanel();
		    JPanel centerBottom = new JPanel();
		    JPanel bottom = new JPanel();
		    
		   		      
	        // add components to the top panel
		    // To Complete
		    top.add(lblName);
		    top.add(txtName);
		    top.add(singleFamilyRbt);
		    top.add(duplexRbt);
		     		      
		    // set the BorderLayout layout for the center panel
		    // To Complete
		    center.setLayout(new BorderLayout());
		      
		   // add components to the centerTop panel
		   // To Complete
		   centerTop.add(lblNumber);
		   centerTop.add(txtNumber);
		   centerTop.add(lblGallons);
		   centerTop.add(txtGallons);
		      		      
		    // add components to the centerBottom panel
		   // To Complete 
		   centerBottom.add(btnAdd);
		   centerBottom.add(btnSort);
		   centerBottom.add(btnSave);
		   centerBottom.add(btnClose);
		    
		   // add panels centerTop and centerBottom to the center panel
		   // use BorderLayout.CENTER and BorderLayout.SOUTH  
		   // To Complete
		   center.add(centerTop,BorderLayout.CENTER);
		   center.add(centerBottom,BorderLayout.SOUTH);
		   
		      
		    // add the JB scroll pane to the bottom panel
		    // To Complete
		    bottom.add(jp);

		    //add the top, center, and bottom panels to the JFrame GUI content pane
		    // To Complete
		    this.add(top,"North");
		    this.add(center,"Center");
		    this.add(bottom,"South");
		 
		}// end doTheLayout

	    // Provide the implementation to the actionPerformed method of the ActionListener interface
		@Override
		public void actionPerformed(ActionEvent e) {
		    // use if statement to call proper methods to process user events
			// To Complete
			if(e.getSource() == this.btnClose)
				this.btnCloseClicked();
			else if (e.getSource() == this.btnSave)
				try {
					this.btnSaveClicked();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			else if (e.getSource() == this.btnSort)
				this.btnSortClicked();
			else if (e.getSource() == this.btnAdd)
				this.btnAddClicked();
			
			
		} // end actionPerformed

		// Response when the Close button is clicked
		private void btnCloseClicked() {
			// exit program
			JOptionPane.showMessageDialog(null, "Program Exit!");
			System.exit(0);
		}//end btnCloseClicked

		
		// Response when the Save button is clicked
		private void btnSaveClicked() throws FileNotFoundException{
			// code to be executed once the save button is clicked
			selectionSort();
			writeToFile();
			display();
		}//end saveBnttonClicked
		
		
		// Response when the Sort button is clicked
		private void btnSortClicked(){
			// code to be executed once the close button is clicked
			selectionSort();
			display();
			
		}//end sortBnttonClicked
		
		// Response when the Add button is clicked
		private void btnAddClicked(){
			// code to be executed once the add button is clicked
			// validation .... 
			// declare local variables
			String name = "";
			int number = 0;
			int gallons = 0;
			
			// read and validate (Not Empty) input of txtname, use if-statement 
			// To Complete
			if(this.txtName.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this.txtName, "Invalid User Name");
				this.txtName.setText("");
				return;				
			} //end if
			name = this.txtName.getText().trim();
			
			// read and validate input txtnumber, use try catch for input validations
			// To Complete
			try {
				
				number = Integer.parseInt(this.txtNumber.getText().trim());
				if (this.txtNumber.getText().trim().length() != 6)
					throw new Exception();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this.txtNumber, "Invalid User Number");
				this.txtNumber.setText("");
				return;				
			}// end try-catch
						
			//read and validate input txtGallons, use try-catch
			// To Complete
               try {
				gallons = Integer.parseInt(this.txtGallons.getText().trim());
				if (gallons < 0)
					throw new Exception();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this.txtGallons, "Invalid Number Gallons");
				this.txtGallons.setText("");
				return;				
			}// end try-catch
			
			// based on selected radio button call method addCusomer(), with a specific bill type
			// To Complete
            if (this.singleFamilyRbt.isSelected())
            	this.addCustomer(name, BaseCharge.SINGLR_FAMILY, number, gallons);
            else if (this.duplexRbt.isSelected())
            	this.addCustomer(name, BaseCharge.DUPLEX, number, gallons);
			
			// clear text fields from data
			txtName.setText("");
			txtNumber.setText("");
			txtGallons.setText("");
			
			
		}// end btnAddClicked

	
		public void addCustomer(String name, int status, int number, int gallons){
			
			// add Customer object to the customers array
			// This method must check whether the array is full 
			// To Complete
			
			if (Customer.getNoOfCustomers() < customers.length) {
				if (status == BaseCharge.SINGLR_FAMILY)
				        customers[Customer.getNoOfCustomers()] =
						new Customer(name, number, new SingleFamily(gallons));
				else if (status == BaseCharge.DUPLEX)
					    customers[Customer.getNoOfCustomers()] =
					    new Customer(name, number, new Duplex(gallons));
				JOptionPane.showMessageDialog(null, "New Customer Data is Added!");
			} else 
				JOptionPane.showMessageDialog(this.btnAdd, "The Customers Array is Full!");
			    	
		}// end addCustomer

	private void display(){
		
		// prepare the output
		String message = "Water Bill: \n" + "Name\t" + "Number\t" + "Gallons\t" + "Bill\t" + "Type\t"+ "Bill Date";
		for (int i = 0; i < Customer.getNoOfCustomers(); i++)
		   message+="\n" + customers[i].toString();
		
		// call methods for calculating average, max, and min
		message+= "\nAverage Bill Values: " + String.format("%.2f", avg());
		message+= "\n The Min Water Bill Customer: " + customers[minIndex()].toString();
		message+= "\n The Max Water Bill Customer: " + customers[maxIndex()].toString();
		
		// display message to the text area, use setText() method
		// To Complete
		this.textArea.setText(message);
	}// end display
	
	private void selectionSort() {
		
		 for (int i = 0; i < Customer.getNoOfCustomers() -1; i++) {
		      // Find the minimum in the customers[i..customers.length-1]
		      Customer currentMin = customers[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < Customer.getNoOfCustomers(); j++) {
		        if (currentMin.compareTo(customers[j]) > 0) {
		          currentMin = customers[j];
		          currentMinIndex = j;
		        }
		      }

		      // Swap customers[i] with customers[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		        customers[currentMinIndex] = customers[i];
		        customers[i] = currentMin;
		      }
		    }
		 
		 JOptionPane.showMessageDialog(null, "Done Sorting Customers Array!");
	}// end selectionSort
	
	private void writeToFile() throws FileNotFoundException {
		File file = new File("outputWaterBill.txt");

	    // Create a file
	    PrintWriter output = new PrintWriter(file);
		

		for (int i =0; i < Customer.getNoOfCustomers(); i++)
			output.println(customers[i].toString());

	    // Close the file
	    output.close();
	    
	    JOptionPane.showMessageDialog(null, "Done Writing Array to file outputWarterBill.txt");
	}// end writeToFile
	
	
	// To read the file size, number of customers
	public int getFileLength(String fileName) throws FileNotFoundException {
		
	    //To Complete in class
	    // read data from inputWaterBill, (see week 03 - Text I/O files)
		// Create a File instance
	    File file = new File(fileName);
	
	    // Create a Scanner for the file
	    Scanner sc = new Scanner(file);

	    // Read data from a file, the data fields are separated by ',' 
	    // Change the Scanner default delimiter to ','
	   
	    
	   // Start reading data from file using while loop
	 
	    int i = 0;
	    while (sc.hasNext()) {
		  sc.nextLine();
		  i++;
	   }// end while
		
		
		// Close the file
	    sc.close();
	    
	    
	    
	     // display message the program done reading data
	     JOptionPane.showMessageDialog(null, "Completed Reading Data to File \"inputWaterBill.txt\"");
	     
	     return i;
	  }// end read methods
	  
	private void readFromFile(String filename) throws FileNotFoundException {
		
		// Create a File instance
	    java.io.File file = new java.io.File(fileName);

	    // Create a Scanner for the file
	    Scanner input = new Scanner(file);

	    // Read data from a file
	    while (input.hasNext()) {
	      String line = input.nextLine();
	      String[] customer = line.split(",");
	      addCustomer(customer[0].trim(), Integer.parseInt(customer[1].trim()), Integer.parseInt(customer[2].trim()),Integer.parseInt(customer[3].trim()));	  
	      
	    }

	    // Close the file
	    input.close();
	    JOptionPane.showMessageDialog(null, "Done Reading Customers data from file "
	    		+  fileName );
	    this.display();
	    
	  }// end readFromFile

	private int minIndex() {
		double min = customers[0].getBill().getValue();
		int index = 0;
		
		for (int i = 1; i< Customer.getNoOfCustomers(); i++)
			if (min > customers[i].getBill().getValue()) {
				min = customers[i].getBill().getValue();
				index = i;
			}// end for
		
		return index;
	}
	
	private int maxIndex() {
		double max = customers[0].getBill().getValue();
		int index = 0;
		
		for (int i = 1; i< Customer.getNoOfCustomers(); i++)
			if (max < customers[i].getBill().getValue()) {
				max = customers[i].getBill().getValue();
				index = i;
			}// end for
				
		return index;
	}
	
	private double avg(){
		double sum =0;
		for (int i = 0; i < Customer.getNoOfCustomers(); i++)
			sum+=customers[i].getBill().getValue();
		
		return sum/Customer.getNoOfCustomers() ;
	}//end avg
	
	
	
	
	
	// main method
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		        //declare variables
				int numberOfcustomers = 0;
				
				// inputs the number of users
				boolean stop = false;
				   //declare array variables
		        while (!stop) 
				try {
				numberOfcustomers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of Customers:"));
				stop = true;
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Program Exit!");
				
				}
				
				
				WaterBillGUI frame = new WaterBillGUI("inputWaterBill.txt", numberOfcustomers);
				frame.setTitle("User Water Bill Company");
			    frame.pack();
			    frame.setLocationRelativeTo(null); // Center the frame
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame.setVisible(true);

	
	}// end main
	

} // end class
