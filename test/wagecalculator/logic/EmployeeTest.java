package wagecalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testAddShift() {
        Employee employee = new Employee("Name");
        employee.addShift(new Shift("18:15", "20:00"));
        assertEquals(employee.toString(), "Name, $6,56");
    }
    
}
