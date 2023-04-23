package PP03;
// package TechStore;
import java.io.BufferedReader;
import java.io.FileReader;
 
public class BufferedReaderExample {
	public static void main(String fileName) {
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(fileName)); 
			while ((line = br.readLine()) != null) {
				String[] stringArr = line.split(",");
				for (String s: stringArr)
				   System.out.print(s + ";" + "");			
				System.out.println();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (br != null){
					br.close();
				}
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}
		} 
	}
}
