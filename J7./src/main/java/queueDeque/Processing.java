package queueDeque;


import java.util.LinkedList;
import java.util.Queue;

public class Processing implements ProcessingInterface {

    // FIFO
//    private Queue<Job> jobQueue = new LinkedList<>();
//
//
//    public boolean addJob(Job job) {
//        return jobQueue.offer(job);
//    }
//
//
//    public Job getNextJob() {
//        return jobQueue.poll();
//    }
//
//    public void getJobBack(Job job) {
//        jobQueue.offer(job);
//    }
//
//    public int getJobs() {
//        return jobQueue.size();
//    }
//    public boolean hasJobs() {
//        return !jobQueue.isEmpty();
//    }
//}




    



// LIFO
private Queue<Job> jobQueue = new LinkedList<>();


    public boolean addJob(Job job) {
        return jobQueue.offer(job);
    }


    public Job getNextJob() {
        int size = jobQueue.size();
        while (size > 1) {
            jobQueue.offer(jobQueue.poll());
            size--;
        }
        return jobQueue.poll();
    }


    public void getJobBack(Job job) {
        jobQueue.offer(job);
    }


    public int getJobs() {
        return jobQueue.size();
    }

    public boolean hasJobs() {
        return !jobQueue.isEmpty();
    }
}