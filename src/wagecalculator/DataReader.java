package wagecalculator;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Reads data from file and returns the data line by line
 */
public class DataReader {
    private BufferedReader reader;
    
    /**
     * @param file File to be read from
     */
    public DataReader(String file) {
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
        } catch (Exception e) {
            System.out.println("Couldn't find the file...");
        }
    }
    
    /**
     * @return Returns the next line or null if end was reached
     */
    public String nextLine() {
        try {
            String line;
            if ((line = reader.readLine()) != null) {
                return line;
            }
        } catch(Exception e) {
            System.out.println("Reading next line failed...");
        }
        return null;
    }
}
