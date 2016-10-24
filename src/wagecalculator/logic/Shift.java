package wagecalculator.logic;

/**
 * Holds information related to shift timing but also calculates wages
 */
public class Shift {
    private final TimeInterval interval;
    
    private final double wage;
    private final double nightWage;
    
    /**
     * @param start Starting time of the shift
     * @param end Ending time of the shift
     */
    public Shift(String start, String end) {
        interval = new TimeInterval(start, end);
        wage = 3.75 / 60;
        nightWage = 1.15 / 60;
    }
    
    /**
     * @return Returns basic wage without compensations in dollars
     */
    public double getCash() {
        return (double)interval.getMinutes() * wage;
    }
    
    /**
     * @return Return overtime compensation in dollars
     */
    public double getOvertimeCompensation() {
        double minutes = interval.getMinutes();
        return wage * (
                0.25 * Math.max(0, minutes - 480) + // After 8 hours +25%
                0.25 * Math.max(0, minutes - 600) + // After 10 hours +25%
                0.5 * Math.max(0, minutes - 720)); // After 12 hours +50%
    }
    
    /**
     * @return Returns night compensation in dollars
     */
    public double getNightCompensation() {
        return (double)interval.getNightMinutes() * nightWage;
    }
    
    /**
     * @return Return all parts of wage combined in dollars
     */
    public double getTotalCash() {
        return this.getCash() + this.getNightCompensation() +
                this.getOvertimeCompensation();
    }
}
