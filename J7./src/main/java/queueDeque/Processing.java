package queueDeque;



import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Processing implements ProcessingInterface {
    private BlockingQueue<Job> jobQueue = new LinkedBlockingQueue<>();

    /**
     * Add a job to the system.
     *
     * @return true if the job is added.
     */
    public boolean addJob(Job job) {
        try {
            jobQueue.put(job);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    /**
     * Get the next job for processing.
     */
    public Job getNextJob() {
        try {
            return jobQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    /**
     * Put the unprocessed job back into the system.
     */
    public void getJobBack(Job job) {
        try {
            jobQueue.put(job);
        } catch (InterruptedException e) {

        }
    }

    /**
     * Get the number of jobs in the system.
     */
    public int getJobs() {
        return jobQueue.size();
    }

    /**
     * Check if there are jobs in the system for processing.
     */
    public boolean hasJobs() {
        return !jobQueue.isEmpty();
    }
}