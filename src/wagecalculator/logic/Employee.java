package wagecalculator.logic;

/**
 * Holds information about the employee and wage
 */
public class Employee {
    private final String name;
    private double wage;
    
    /**
     * @param employeeName Name of the employee
     */
    public Employee(String employeeName) {
        name = employeeName;
    }
    
    /**
     * @param shift Adds cash from the given shift to the wage 
     */
    public void addShift(Shift shift) {
        wage += shift.getCash();
    }
    
    @Override
    public String toString() {
        return name + ", $" + String.format("%.2f", wage);
    }
}
