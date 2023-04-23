//Name: Arjit Gupta
//Date: 30th March 2023
//Assignment: PP03

package PP03;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ReadData {
	static void readData(String fileName) throws Exception {
		// Create a File instance
		java.io.File file = new java.io.File(fileName);

		// Create a Scanner for the file
		Scanner input = new Scanner(file);

		// Read data from a file
		while (input.hasNext()) {
			String firstName = input.next();
			String mi = input.next();
			String lastName = input.next();
			int score = input.nextInt();
			JOptionPane.showMessageDialog(null,
					firstName + " " + mi + " " + lastName + " " + score);
		}

		// Close the file
		input.close();
	}

}
