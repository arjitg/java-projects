//Name: Arjit Gupta
//Date: 30 March 2023
//Assignment: PP03

package PP03;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteData {
	static void writeToFile(int[] objectList, String fileName) throws FileNotFoundException {
		
		File file = new File(fileName);
        PrintWriter write = new PrintWriter(file);
		
        String out = "";
		for (int i =0; i < objectList.length; i++ ){
			out += "\n" + objectList[i];
		}

	    write.print(out);
	    write.close();
	}// end writeToFile
}
