//Name: Arjit Gupta
//Date: 3rd March 2023
//Assignment: PA02

package helperMethods;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Product {

	static String output = "";
	public static void main(String[] args) {
		String[] pName = new String[50];
		Double[] pPrice = new Double[50];
		String fileName = DataEntries.strInput("Please enter filename");

		readFromFile(fileName, pName, pPrice);
		sortArrays(pName, pPrice);
		JOptionPane.showMessageDialog(null, new JTextArea(output));
		writeToFile("sortedProducts.txt");
	}

	public static void readFromFile(String fileName, String[] pName, Double[] pPrice){
		File file = new File(fileName);

		try {
			Scanner sc = new Scanner(file);
			sc.useDelimiter(",|\r\n");

			int i=0;
			while (sc.hasNext()) {
				pName[i] = sc.next().trim();
				pPrice[i] = Double.parseDouble(sc.next().trim());
				i++;
			}
			sc.close();

			// display message the program done reading data
			String dataString = "";
			for(int c=0; c<50; c++) {
				dataString = dataString + pName[c] + ", " + pPrice[c] + "\n";
			}
			JOptionPane.showMessageDialog(null, dataString);
			JOptionPane.showMessageDialog(null, "Completed Reading Data from File "+fileName);

		} catch (Exception e) {
			int choice = JOptionPane.showConfirmDialog(null, "File not found. Do you want to continue?");
			if (choice!=0)
				System.exit(0);
		}
	}

	public static void sortArrays(String[] pName, Double[] pPrice) {
		Sort.selectionSort(pPrice, pName);
		for(int i=0;i<pPrice.length;i++) {
			output += pName[i] + "\t$" + String.format("%.2f", pPrice[i]) + "\n";
		}
	}

	// writes the program output to file
	public static void writeToFile(String fileName) {

		File file = new File(fileName);

		// write data to file
		try {
			PrintWriter of = new PrintWriter(file);
			of.print(output);
			of.close();

			JOptionPane.showMessageDialog(null, "Completed Writing Data to File "+fileName);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

}
