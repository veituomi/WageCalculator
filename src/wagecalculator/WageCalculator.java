package wagecalculator;

import java.util.Scanner;

public class WageCalculator {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Read file: ");
        Scanner scanner = new Scanner(System.in);
        Wages wages = new Wages(scanner.nextLine());
        wages.print(System.out);
    }
    
}
