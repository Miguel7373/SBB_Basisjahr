package queueDeque;

public interface ProcessingInterface {

    /**
     * Add a job to the system.
     * @return true if the job is added.
     */
    public boolean addJob(Job job);

    /**
     * Get the next job for processing.
     */
    public Job getNextJob();

    /**
     * Put the unprocessed job back to the system.
     */
    public void getJobBack(Job job);

    /**
     * Get the number of jobs in the system.
     */
    public int getJobs();

    /**
     * Has jobs in the system for processing?
     */
    public boolean hasJobs();
}

