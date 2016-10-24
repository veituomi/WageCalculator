package wagecalculator;

import wagecalculator.logic.Shift;
import wagecalculator.logic.Employee;
import java.util.TreeMap;
import java.io.PrintStream;

/**
 * Contains all employees, reads and prints their wages
 */
public class Wages {
    private final TreeMap<Integer, Employee> employees;
    private final DataReader reader;
    
    /**
     * Initializes TreeMap and DataReader and reads
     * @param filename Name of the file that should be read
     */
    public Wages(String filename) {
        employees = new TreeMap();
        reader = new DataReader(filename);
        read();
    }
    
    private void read() {
        String line;
        while ((line = reader.nextLine()) != null) {
            String[] csvData = line.split(",");
            if (csvData.length < 5) break;
            int id = Integer.parseInt(csvData[1]);
            addShift(id, csvData[0], new Shift(csvData[3], csvData[4]));
        }
    }
    
    private void addShift(int id, String name, Shift shift) {
        if (!employees.containsKey(id)) {
            employees.put(id, new Employee(name));
        }
        employees.get(id).addShift(shift);
    }
    
    /**
     * Prints the total wages for employees into the given PrintStream
     * @param stream Stream to be printed to
     */
    public void print(PrintStream stream) {
        for (Integer id : employees.keySet()) {
            Employee e = employees.get(id);
            stream.println(id + ", " + e);
        }
    }
}
