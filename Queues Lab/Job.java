/**
 * Job Class
 *
 * @author Justin Ferrell
 */
class Job {
    //names should be pretty self-explanatory
    private int arrivalTime, pID, cpuTimeRequired, cpuTimeRemaining, currentQueue, systemTime;

    /**
     * Constructor
     *
     * @param arrivalTime     time the job will arrive into the system
     * @param pID             the ID number of the job
     * @param cpuTimeRequired the CPU time the job requires
     */
    Job(int arrivalTime, int pID, int cpuTimeRequired) {
        this.arrivalTime = arrivalTime;
        this.pID = pID;
        this.cpuTimeRequired = cpuTimeRequired;

        cpuTimeRemaining = cpuTimeRequired;
        currentQueue = 1;
        systemTime = 0;
    }

    /**
     * Gets the arrival time of the current job Object
     *
     * @return the int arrival time of the Job
     */
    int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Gets the ID number of the current job Object
     *
     * @return the ID of the current Job
     */
    int getPID() {
        return pID;
    }

    /**
     * Gets the required CPU time of the current job Object
     *
     * @return the CPU time the Job needs
     */
    int getCpuTimeRequired() {
        return cpuTimeRequired;
    }

    /**
     * Gets the remaining CPU time of the current job Object
     *
     * @return the remaining CPU time
     */
    int getCpuTimeRemaining() {
        return cpuTimeRemaining;
    }

    /**
     * Sets the remaining CPU time the current object gets
     *
     * @param cpuTimeRemaining the CPU time to be set
     */
    void setCpuTimeRemaining(int cpuTimeRemaining) {
        this.cpuTimeRemaining = cpuTimeRemaining;
    }

    /**
     * Gets the current Queue the current job Object is in
     *
     * @return the current queue
     */
    int getCurrentQueue() {
        return currentQueue;
    }

    /**
     * Sets a new current queue for the job Object
     *
     * @param currentQueue the queue to be set
     */
    void setCurrentQueue(int currentQueue) {
        this.currentQueue = currentQueue;
    }

    /**
     * Gets the system time of the current job Object
     *
     * @return the System Time
     */
    int getSystemTime() {
        return systemTime;
    }

    /**
     * Sets the system time for the current job Object
     *
     * @param systemTime usually an increment by 1 from the previous system time
     */
    void setSystemTime(int systemTime) {
        this.systemTime = systemTime;
    }

}