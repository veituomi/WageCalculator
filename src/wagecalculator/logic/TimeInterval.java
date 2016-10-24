package wagecalculator.logic;

/**
 * Used to do calculations related to interval between two specified times
 */
public class TimeInterval {
    private final Time from;
    private final Time to;
    
    /**
     * Interval can only be less than 24 hours in length
     * @param start Time where the interval starts
     * @param end Time where the interval ends
     */
    public TimeInterval(String start, String end) {
        from = new Time(start);
        to = new Time(end);
    }
    
    /**
     * @return Returns the total minutes in the interval
     */
    public int getMinutes() {
        int start = from.getTotalMinutes();
        int end = to.getTotalMinutes() + (to.isBefore(from) ? 24 * 60 : 0);
        return end - start;
    }
    
    /**
     * @return Returns minutes not between 06:00 and 18:00
     */
    public int getNightMinutes() {
        return this.getMinutes() - this.getDayMinutes();
    }
    
    /**
     * @return Return minutes between 06:00 and 18:00
     */
    public int getDayMinutes() {
        int dayMinutesStart = Math.max(6 * 60, from.getTotalMinutes());
        int dayMinutesEnd = Math.min(18 * 60, to.getTotalMinutes() +
                (to.isBefore(from) ? 24 * 60 : 0));
        return Math.max(0, dayMinutesEnd - dayMinutesStart);
    }
}
