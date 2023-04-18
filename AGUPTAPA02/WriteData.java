//Name: Arjit Gupta
//Date: 3rd March 2023
//Assignment: PA02

package helperMethods;
import javax.swing.JOptionPane;

public class WriteData {
	public static void main(String[] args) throws Exception {

		String fileName = "scores" + System.currentTimeMillis() + ".txt";
		java.io.File file = new java.io.File(fileName);
		if (file.exists()) {
			JOptionPane.showMessageDialog(null,"File already exists");
			System.exit(0);
		}

		// Create a file
		java.io.PrintWriter output = new java.io.PrintWriter(file);

		// Write formatted output to the file
		output.print("John T Smith ");
		output.println(90);
		output.print("Eric K Jones ");
		output.println(85);

		// Close the file
		output.close();
	}
}
