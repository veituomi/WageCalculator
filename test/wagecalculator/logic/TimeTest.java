package wagecalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeTest {
    @Test
    public void testParsingNormal() {
        Time t = new Time("12:34");
        assertEquals(t.getHours(), 12);
        assertEquals(t.getMinutes(), 34);
    }
    
    @Test
    public void testParsingZeroPadded() {
        Time t = new Time("12:04");
        assertEquals(t.getHours(), 12);
        assertEquals(t.getMinutes(), 4);
    }
    
}
