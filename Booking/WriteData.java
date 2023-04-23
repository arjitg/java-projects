package PA03;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteData {
	// public static void main(String[] args) throws Exception {

	// 	String fileName = "scores" + System.currentTimeMillis() + ".txt";
	// 	java.io.File file = new java.io.File(fileName);
	// 	if (file.exists()) {
	// 		JOptionPane.showMessageDialog(null,"File already exists");
	// 		System.exit(0);
	// 	}

	// 	// Create a file
	// 	java.io.PrintWriter output = new java.io.PrintWriter(file);

	// 	// Write formatted output to the file
	// 	output.print("John T Smith ");
	// 	output.println(90);
	// 	output.print("Eric K Jones ");
	// 	output.println(85);

	// 	// Close the file
	// 	output.close();
	// }
	// write data to file
	static void writeToFile(Audience[] objectList, String fileName) throws FileNotFoundException {
		
		File file = new File(fileName);
        PrintWriter write = new PrintWriter(file);
		
        String out = "";
		for (int i =0; i < objectList.length; i++ ){
			out += "\n" + objectList[i].toString();
		}

	    write.print(out);
	    write.close();
	}// end writeToFile
}
