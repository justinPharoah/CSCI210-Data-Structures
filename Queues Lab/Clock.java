/**
 * Clock Class
 *
 * @author Justin Ferrell
 */
class Clock {
    private int time;

    /**
     * Constructor
     */
    Clock() {
        time = 0;
    }

    /**
     * Gets the current time of the tick clock
     *
     * @return current time
     */
    int getTime() {
        return time;
    }

    /**
     * sets the tick clock
     */
    void setTime() {
        time += 1;
    }
}
