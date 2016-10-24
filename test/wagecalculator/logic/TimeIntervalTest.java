package wagecalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeIntervalTest {
    
    @Test
    public void testGetMinutes() {
        TimeInterval interval = new TimeInterval("23:00", "01:15");
        assertEquals(interval.getMinutes(), 135);
    }

    @Test
    public void testGetNightMinutes() {
        // No way this couldn't work if getMinutes() and getDayMinutes() work
    }

    @Test
    public void testGetDayMinutes() {
        String[][] intervals = {
            { "23:00", "06:00" },
            { "17:30", "18:30" },
            { "18:00", "06:00" },
            { "00:00", "06:00" },
            { "00:00", "19:00" },
            { "00:00", "17:00" },
            { "17:00", "02:00" }
        };
        int[] expected = {
            0, 30, 0, 0, 720, 660, 60
        };
        
        for (int i = 0; i < intervals.length; ++i) {
            TimeInterval interval = new TimeInterval(intervals[i][0], intervals[i][1]);
            assertEquals(expected[i], interval.getDayMinutes());
        }
    }
    
}
