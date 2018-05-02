/**
 * CPU Class
 *
 * @author Justin Ferrell
 */
class CPU {
    private Job job;
    private int cpuQuantumClock;
    private boolean busyFlag;

    /**
     * Constructor
     */
    CPU() {
        job = null;
    }

    /**
     * Returns the current job on the CPU
     *
     * @return Job object
     */
    Job getJob() {
        return job;
    }

    /**
     * Assigns or sets a job to the CPU
     *
     * @param job the Job that we want to assign to the CPU
     * @return void
     */
    void setJob(Job job) {
        this.job = job;
    }

    /**
     * Determines the Quantum Time of a given job
     *
     * @return the int quantum time
     */
    int currentQuantumTime() {
        switch (job.getCurrentQueue()) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            default:
                return 2;
        }
    }

    /**
     * Determines whether or not a job is on the CPU or not
     *
     * @return true if CPU is busy, false if CPU is not busy
     */
    boolean isBusyFlag() {
        return job != null;
    }


}