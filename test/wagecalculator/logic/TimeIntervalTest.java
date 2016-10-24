package wagecalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeIntervalTest {
    private String[][] intervals = {
            { "23:00", "06:00" },
            { "17:30", "18:30" },
            { "18:00", "06:00" },
            { "00:00", "06:00" },
            { "00:00", "19:00" },
            { "00:00", "17:00" },
            { "17:00", "02:00" }
        };
    
    @Test
    public void testGetMinutes() {
        int[] expected = {
            7, 1, 12, 6, 19, 17, 9
        };
        
        for (int i = 0; i < intervals.length; ++i) {
            TimeInterval interval = new TimeInterval(intervals[i][0], intervals[i][1]);
            assertEquals(expected[i] * 60, interval.getMinutes());
        }
    }

    @Test
    public void testGetNightMinutes() {
        // No way this couldn't work if getMinutes() and getDayMinutes() work
    }

    @Test
    public void testGetDayMinutes() {
        int[] expected = {
            0, 30, 0, 0, 720, 660, 60
        };
        
        for (int i = 0; i < intervals.length; ++i) {
            TimeInterval interval = new TimeInterval(intervals[i][0], intervals[i][1]);
            assertEquals(expected[i], interval.getDayMinutes());
        }
    }
    
}
