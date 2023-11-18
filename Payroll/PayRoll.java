package PP03;

// import java.io.FileNotFoundException;
// import java.text.DateFormat;

import io.github.pixee.security.BoundedLineReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.io.*;

public class PayRoll {
	private String fileName;
	private PayRecord[] payRecords;
	public HashMap<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
	// private HashMap<Employee, Address> employeeAddressMap = new HashMap<Employee, Address>();
	private int recordCount;
	public SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	
	private double totalNetPay = 0;
	private double avgNetPay = 0;
	
	public PayRoll(String fileName, int n){
		this.fileName = fileName;
		this.payRecords = new PayRecord[n+6];
		recordCount = 0;
		this.readFromFile();
		// this.writeToFile();
		// this.employees = new Employee[n];
	}

	public void readFromFile(){
		// read the initial data from PayRoll file to create the full 
		// pay records with gross pay, taxes, and net pay, and then store it in PayRecord.txt file
		java.io.File file = new java.io.File(this.fileName);

		String fName;
		String lName;
		Address address;

		String street;
		int houseNumber;
		String city;
		String state;
		int zipCode;

		int eID;
		Status empStatus;

		int rID;
		Employee employee;
		int payPeriodID;
		PayPeriod payPeriod;
		String fString;
		String sString;
		// TaxIncome payTax;
		double payHours=0;
		double payRate=0;
		double montlyIncome=0;
		int numMonths=0;

		String sDate, eDate;

		Date pStartDate, pEndDate;

		// Create a Scanner for the file
		// Scanner input;
		try {
			String line;
			String initValue="";
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(fileName));
			while ((line = BoundedLineReader.readLine(br, 5_000_000)) != null) {
				String[] stringArr = line.split(",");
				JOptionPane.showMessageDialog(null, line);
				stringArr[0] = initValue;

				if(initValue.contains("employee")){
					eID = Integer.parseInt(stringArr[1]);
					fName = stringArr[2].trim();
					lName = stringArr[3].trim();
					String empStatusVal = stringArr[4].trim();
					if(empStatusVal.contains("FULLTIME")){
						empStatus = Status.FullTime;
					}
					else{
						empStatus = Status.Hourly;
					}
					street = stringArr[5].trim();
					houseNumber = Integer.parseInt(stringArr[6]);
					city = stringArr[7];
					state = stringArr[8];
					zipCode = Integer.parseInt(stringArr[9]);

					employee = createEmployee(eID, empStatus);
					employee.fName = fName;
					employee.lName = lName;

					address = new Address(street, houseNumber, city, state, zipCode);
					employee.address = address;
					// employeeAddressMap.put(employee, address);
					employeeMap.put(eID, employee);
					JOptionPane.showMessageDialog(null, "Employeemap size: "+employeeMap.size());
					continue;
				}
				

				if(initValue == "payRecord"){
					rID = Integer.parseInt(stringArr[1]);
					eID = Integer.parseInt(stringArr[2]);
					fString = stringArr[3].trim();
					sString = stringArr[4].trim();
					
					if(fString.contains("<m>")){
						montlyIncome = Double.parseDouble(fString.replace("<m>", ""));
					}
					if(sString.contains("<n>")){
						numMonths = Integer.parseInt(sString.replace("<n>", ""));
					}
					
					if(fString.contains("<h>")){
						payHours = Double.parseDouble(fString.replace("<h>", ""));
					}
					if(sString.contains("<r>")){
						payRate = Double.parseDouble(sString.replace("<r>", ""));
					}

					payPeriodID = Integer.parseInt(stringArr[5]);
					
					sDate = stringArr[6].trim();
					pStartDate = format.parse(sDate);

					eDate = stringArr[7].trim();
					pEndDate = format.parse(eDate);

					payPeriod = new PayPeriod(payPeriodID, pStartDate, pEndDate);
					
					createPayRecord(rID, employeeMap.get(eID), payPeriod, montlyIncome, numMonths, payHours, payRate);
					continue;
				}

				
			}
			// input = new Scanner(file);
			// input.useDelimiter(",|\r\n");

			// while (input.hasNext()) {
			// 	String initValue = input.next();
				// if(initValue == "employee"){
				// 	eID = input.nextInt();
				// 	fName = input.next().trim();
				// 	lName = input.next().trim();
				// 	String empStatusVal = input.next();
				// 	if(empStatusVal == "FULLTIME"){
				// 		empStatus = Status.FullTime;
				// 	}
				// 	else{
				// 		empStatus = Status.Hourly;
				// 	}
				// 	street = input.next().trim();
				// 	houseNumber = input.nextInt();
				// 	city = input.next().trim();
				// 	state = input.next().trim();
				// 	zipCode = input.nextInt();

				// 	employee = createEmployee(eID, empStatus);
				// 	employee.fName = fName;
				// 	employee.lName = lName;

				// 	address = new Address(street, houseNumber, city, state, zipCode);
				// 	employee.address = address;
				// 	// employeeAddressMap.put(employee, address);
				// 	employeeMap.put(eID, employee);
				// 	continue;
				// }
				// if(initValue == "payRecord"){
				// 	rID = input.nextInt();
				// 	eID = input.nextInt();
				// 	fString = input.next().trim();
				// 	sString = input.next().trim();
					
				// 	if(fString.contains("<m>")){
				// 		montlyIncome = Double.parseDouble(fString.replace("<m>", ""));
				// 	}
				// 	if(sString.contains("<n>")){
				// 		numMonths = Integer.parseInt(sString.replace("<n>", ""));
				// 	}
					
				// 	if(fString.contains("<h>")){
				// 		payHours = Double.parseDouble(fString.replace("<h>", ""));
				// 	}
				// 	if(sString.contains("<r>")){
				// 		payRate = Double.parseDouble(sString.replace("<r>", ""));
				// 	}

				// 	payPeriodID = input.nextInt();
					
				// 	sDate = input.next().trim();
				// 	pStartDate = format.parse(sDate);

				// 	eDate = input.next().trim();
				// 	pEndDate = format.parse(eDate);

				// 	payPeriod = new PayPeriod(payPeriodID, pStartDate, pEndDate);
					
				// 	createPayRecord(rID, employeeMap.get(eID), payPeriod, montlyIncome, numMonths, payHours, payRate);
				// 	continue;
				// }
			// }
			// input.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0; i<recordCount; i++){
			System.out.println("WRITINGGGGGGGG");
			System.out.println(payRecords[i].toString());
		}
		// System.out.println(this.avgNetPay());

		JOptionPane.showMessageDialog(null, "Completed reading filedata");
	}
	
	public void writeToFile(){
		try {
			File newTextFile = new File("PayRecord.txt");
			FileWriter fw = new FileWriter(newTextFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0; i<payRecords.length; i++){
				bw.newLine();
				bw.write(payRecords[i].toString());
			}
			bw.close();
			JOptionPane.showMessageDialog(null, "Completed writing to file");
		} catch (Exception e) {
			System.out.println("\n\n\n\nException in writeToFile....\n\n\n\n");
			e.printStackTrace();
		}
		// write employees' pay records to the PayRecord.txt file, it should add employee pay record to the current file data	
	} 
   
	public Employee createEmployee(int eID, Status empStatus){
		return new Employee(eID, empStatus);
		// creates a new Employee object and add it to the employees array, you need to pass parameters to this method		
	}
	 
	public void createPayRecord(int eID, Employee emp, PayPeriod payPeriod, double montlyIncome, int numMonths, double payHours, double payRate){
		PayRecord pRecord;

		if(montlyIncome>0 && numMonths>0){
			pRecord = new PayRecord(eID, emp, payPeriod, montlyIncome, numMonths);
		}
		else{
			pRecord = new PayRecord(eID, emp, payPeriod, payHours, payRate);
		}
		JOptionPane.showMessageDialog(null, pRecord.toString());

		this.payRecords[recordCount] = pRecord;
		recordCount++;
		// creates a new PayRecord for an Employee object and add it to  the payRecords array, you need to pass parameters to this method		
	}
	
    public String displayPayRecord(){
		return this.toString();
		// it shows all payroll records for all currently added employee and the total net pay and average net pay in the GUI text area
    	// at should append data to text area, it must not overwrite data in the GUI text area
		
	}

	public double avgNetPay(){
		if(payRecords.length>0){
			System.out.println(payRecords.length);
			for(int i=0; i<payRecords.length; i++){
				totalNetPay += payRecords[i].netPay();
			}
			avgNetPay = totalNetPay/payRecords.length;
		}
		return avgNetPay;
		// returns the average of the total net pay of all added employees		
	}

	@Override
	public String toString(){
		String builtString = "";
		for(int i=0; i<recordCount; i++){
			System.out.println("i is "+i);
			builtString += this.payRecords[i].toString();
		}
		builtString += "\nAverage Net Pay: "+this.avgNetPay()+"\nTotal Net Pay: "+this.totalNetPay;
		return builtString;
	}
}
