package wagecalculator.logic;

/**
 * Used to handle timestamps and related calculations
 */
public class Time {
    private final int hours;
    private final int minutes;
    
    /**
     * @param clock Time in hh:mm format
     */
    public Time(String clock) {
        String[] values = clock.split(":");
        hours = Integer.parseInt(values[0]);
        minutes = Integer.parseInt(values[1]);
    }
    
    /**
     * @param other Another time to be compared with this
     * @return Returns true if this time is before other
     */
    public boolean isBefore(Time other) {
        return this.getTotalMinutes() - other.getTotalMinutes() < 0;
    }
    
    public int getHours() {
        return hours;
    }
    
    public int getMinutes() {
        return minutes;
    }
    
    /**
     * @return Returns total minutes from the beginning of the day
     */
    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }
}
