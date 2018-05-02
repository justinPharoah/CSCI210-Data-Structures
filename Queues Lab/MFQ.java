import java.io.*;
import java.util.*;

/**
 * MFQ Class
 *
 * @author Justin Ferrell
 */
class MFQ {
    private PrintWriter pw;
    private CPU cpu;
    private Clock clock;
    private Job job;
    private ObjectQueue jobQueue, queue1, queue2, queue3, queue4, finQueue;
    private int idleTime, totalTime, waitTime;

    private final int totalJobs = 16;

    /**
     * Constructor
     *
     * @param pw takes ina PrintWriter Object for output
     */
    MFQ(PrintWriter pw) {
        this.pw = pw;
        cpu = new CPU();
        clock = new Clock();

        jobQueue = new ObjectQueue();
        queue1 = new ObjectQueue();
        queue2 = new ObjectQueue();
        queue3 = new ObjectQueue();
        queue4 = new ObjectQueue();
        finQueue = new ObjectQueue();

        idleTime = 0;
        totalTime = 0;
        waitTime = 0;
    }

    /**
     * Reads in the jobs from given file and inserts them into the jobQueue
     *
     * @param fileName file that holds the jobs to be read in
     * @return void
     * @throws IOException to ensure file is read in without crashing
     */
    void getJobs(String fileName) throws IOException {
        Scanner fileScanner = new Scanner(new File(fileName));

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String delims = "[ ]++";
            String[] tokens = line.split(delims);

            int arrivalTime = Integer.parseInt(tokens[0]);
            int pID = Integer.parseInt(tokens[1]);
            int cpuTimeRequired = Integer.parseInt(tokens[2]);

            job = new Job(arrivalTime, pID, cpuTimeRequired);
            jobQueue.insert(job);
        }
    }

    /**
     * Prints out the header to indicate what column holds what information
     *
     * @return void
     */
    void outputHeader() {
        //each String should be 10 spaces apart
        System.out.printf("%s %20s %13s %25s %27s %28s",
                "Event", "System Time", "PID", "CPU Time Needed", "Total Time Needed", "Lowest Level Queue" + "\n");
        pw.printf("%s %20s %13s %25s %27s %28s",
                "Event", "System Time", "PID", "CPU Time Needed", "Total Time Needed", "Lowest Level Queue" + "\n");
    }

    /**
     * Runs the Multilevel Feedback Queue Simulation
     *
     * @return void
     */
    void runSimulation() {
        while (!jobQueue.isEmpty() || !queue1.isEmpty() || !queue2.isEmpty() || !queue3.isEmpty() || !queue4.isEmpty()) {
            if (!jobQueue.isEmpty()) { //unless job queue is empty
                if (((Job) jobQueue.query()).getArrivalTime() == clock.getTime()) { //check if it is a job's arrival time yet
                    queue1.insert(jobQueue.remove()); //Submits new job into queue 1
                    printArrival((Job) queue1.query()); //Outputs Message
                }
            }
            if (!cpu.isBusyFlag()) { //cpu is not busy with a job
                setCPUJobs();
            } else { //cpu is busy with a job
                cpu.getJob().setCpuTimeRemaining(cpu.getJob().getCpuTimeRemaining() - 1); //decrements job clock
                if (cpu.getJob().getCpuTimeRemaining() == 0) { //cpu time is 0 meaning job is finished
                    removeJobs(); //removes job from the system
                    //adds up total time so far in the simulation
                    totalTime += ((Job) finQueue.query()).getSystemTime();
                    setCPUJobs();
                } else if (((cpu.getJob().getCpuTimeRequired() - cpu.getJob().getCpuTimeRemaining()) == cpu.currentQuantumTime())) {
                    toLLQ(cpu.getJob());
                    setCPUJobs();
                }
            }
            clock.setTime(); //increments tick clock
        }
    }

    /**
     * Outputs the Statistics required for the lab
     *
     * @return void
     */
    void outputStats() {
        double avgTotalTime = totalTime / totalJobs;
        double avgWait = waitTime / totalJobs;
        double avgThroughPut = totalJobs / totalTime;

        System.out.println("\n");
        pw.println("\n");

        System.out.printf("%s %25s", "Total Number of Jobs", totalJobs + "\n");
        pw.printf("%s %25s", "Total Number of Jobs", totalJobs + "\n");

        System.out.printf("%s %s %s", "Total Time of All Jobs in System", totalTime, "\n");
        pw.printf("%s %s %s", "Total Time of All Jobs in System", totalTime, "\n");

        System.out.printf("%s %24s", "Average Response Time", 0.00 + "\n");
        pw.printf("%s %24s", "Average Response Time", 0.00 + "\n");

        System.out.printf("%s %.2f %s", "Average Turnaround Time for the Jobs", avgTotalTime, "\n");
        pw.printf("%s %.2f %s", "Average Turnaround Time for the Jobs", avgTotalTime, "\n");

        System.out.printf("%s %.2f %s", "Average Waiting Time", avgWait, "\n");
        pw.printf("%s %.2f %s", "Average Waiting Time", avgWait, "\n");

        System.out.printf("%s %.2f %s", "Average Throughput for System as a Whole", avgThroughPut, "\n");
        pw.printf("%s %.2f %s", "Average Throughput for System as a Whole", avgThroughPut, "\n");

        System.out.printf("%s %s %s", "Total CPU Idle Time", idleTime, "\n");
        pw.printf("%s %s %s", "Total CPU Idle Time", idleTime, "\n");
    }

    //private methods. I tried to modularize my code at Christopher's suggestion

    /**
     * Prints a message whenever there is an arrival into queue 1
     *
     * @param job Job object that entered the queue
     * @return void
     */
    private void printArrival(Job job) {
        System.out.printf("%s %18s %13s %25s %27s %28s",
                "Arrival", job.getArrivalTime(), job.getPID(), job.getCpuTimeRequired(), "-", "-" + "\n");
        pw.printf("%s %18s %13s %25s %27s %28s",
                "Arrival", job.getArrivalTime(), job.getPID(), job.getCpuTimeRequired(), "-", "-" + "\n");
    }

    /**
     * Moves a job from appropriate queue if CPU is not busy
     *
     * @return void
     */
    private void setCPUJobs() {
        //queue 1 has a job in it
        if (!queue1.isEmpty()) cpu.setJob((Job) queue1.query());
        //queue 1 is empty, queue 2 has a job in it
        else if (!queue2.isEmpty()) cpu.setJob((Job) queue2.query());
        //queue 2 is empty, queue 3 has a job in it
        else if (!queue3.isEmpty()) cpu.setJob((Job) queue3.query());
        //queue 3 is empty, queue 4 has a job in it
        else if (!queue4.isEmpty()) cpu.setJob((Job) queue4.query());
        else idleTime++; //increment the time that the CPU is not busy
    }

    /**
     * Moves a job onto a Lower Level Queue per preemption
     *
     * @param job Job object that is to be moved
     * @return void
     */
    private void toLLQ(Job job) {
        switch (cpu.getJob().getCurrentQueue()) { //gets current queue of job and puts it in next queue
            case 1:
                queue2.insert(queue1.remove()); //moves from queue 1 to LLQ
                job.setCurrentQueue(2);
                cpu.setJob(null);
                break;
            case 2:
                queue3.insert(queue2.remove()); //moves from queue 2 to LLQ
                job.setCurrentQueue(3);
                cpu.setJob(null);
                break;
            case 3:
                queue4.insert(queue3.remove()); //moves from queue 3 to LLQ
                job.setCurrentQueue(4);
                cpu.setJob(null);
                break;
            case 4:
                queue4.insert(queue4.remove()); //Round Robin for queue 4
                job.setCurrentQueue(4);
                cpu.setJob(null);
                break;
        }
    }

    /**
     * Removes a job from the simulation once it is done
     *
     * @return void
     */
    private void removeJobs() {
        switch (cpu.getJob().getCurrentQueue()) { //gets current queue of job that is finished and removes it
            case 1:
                cpu.getJob().setSystemTime((clock.getTime() - cpu.getJob().getArrivalTime()));
                printDeparture((Job) queue1.query()); //Outputs Message
                finQueue.insert(queue1.remove());
                cpu.setJob(null);
                break;
            case 2:
                cpu.getJob().setSystemTime((clock.getTime() - cpu.getJob().getArrivalTime()));
                printDeparture((Job) queue2.query()); //Outputs Message
                finQueue.insert(queue2.remove());
                cpu.setJob(null);
                break;
            case 3:
                cpu.getJob().setSystemTime((clock.getTime() - cpu.getJob().getArrivalTime()));
                printDeparture((Job) queue3.query()); //Outputs Message
                finQueue.insert(queue3.remove());
                cpu.setJob(null);
                break;
            case 4:
                cpu.getJob().setSystemTime((clock.getTime() - cpu.getJob().getArrivalTime()));
                printDeparture((Job) queue4.query()); //Outputs Message
                finQueue.insert(queue4.remove());
                cpu.setJob(null);
                break;
        }
    }

    /**
     * Prints a message when there is a departure from the system
     *
     * @param job job that is being removed from the system
     * @return void
     */
    private void printDeparture(Job job) {
        System.out.printf("%s %16s %13s %25s %27s %28s", "Departure",
                clock.getTime(), job.getPID(), "-", (clock.getTime() - job.getArrivalTime()), job.getCurrentQueue() + "\n");
        pw.printf("%s %16s %13s %25s %27s %28s", "Departure",
                clock.getTime(), job.getPID(), "-", (clock.getTime() - job.getArrivalTime()), job.getCurrentQueue() + "\n");
    }

}