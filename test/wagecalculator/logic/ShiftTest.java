package wagecalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShiftTest {
    private final String[][] intervals = {
            { "23:00", "06:00" },
            { "17:30", "18:30" },
            { "18:00", "06:00" },
            { "00:00", "06:00" },
            { "00:00", "19:00" },
            { "00:00", "17:00" },
            { "17:00", "02:00" }
        };
    
    @Test
    public void testGetCash() {
        double[] expected = {
            26.25, 3.75, 45, 22.5, 71.25, 63.75, 33.75
        };
        
        for (int i = 0; i < intervals.length; ++i) {
            Shift shift = new Shift(intervals[i][0], intervals[i][1]);
            assertEquals(expected[i], shift.getCash(), 0.001);
        }
    }

    @Test
    public void testGetOvertimeCompensation() {
        double[] expected = {
            0, 0, 5.625, 0, 31.875, 24.375, 0.9375
        };
        
        for (int i = 0; i < intervals.length; ++i) {
            Shift shift = new Shift(intervals[i][0], intervals[i][1]);
            assertEquals(expected[i], shift.getOvertimeCompensation(), 0.001);
        }
    }
    
    @Test
    public void testGetNightCompensation() {
        double[] expected = {
            7, 0.5, 12, 6, 7, 6, 8
        };
        
        for (int i = 0; i < intervals.length; ++i) {
            Shift shift = new Shift(intervals[i][0], intervals[i][1]);
            assertEquals(expected[i] * 1.15, shift.getNightCompensation(), 0.001);
        }
    }

    @Test
    public void testGetTotalCash() {
        fail("The test case is a prototype.");
    }
    
}
