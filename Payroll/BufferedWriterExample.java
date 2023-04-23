package PP03;

import java.io.*;

public class BufferedWriterExample {
    public static void main(String[] args) {
        try {
            String str = "SomeMoreTextIsHere";
            File newTextFile = new File("thetextfile.txt");

            FileWriter fw = new FileWriter(newTextFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.newLine();
            bw.write(str);
            bw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }
}