package queueDeque;

import java.util.Random;

public class OutputWorker implements Runnable {
    private final String name;
    private final ProcessingInterface processingInterface;

    public OutputWorker(String name, ProcessingInterface processingInterface) {
        this.name = name;
        this.processingInterface = processingInterface;
    }

    @Override
    public void run() {
        int countWaitCycle = 0;
        System.out.printf("   [%s] started successfully%n", name);
        Random random = new Random();

        while (countWaitCycle < Start.OUTPUTWORKER_STOP_AFTER_EMPTY_CYCLES) {
            try {
                Job job = processingInterface.getNextJob();
                if (job != null) {
                    job.setJobState(JobState.IN_PROGRESS);
                    System.out.printf("[%s] Number of open jobs: %d%n", name, processingInterface.getJobs());
                    job.setMessage("It is a really hard job!");
                    System.out.printf("<- [%s] process job: %s%n", name, job);
                    Thread.sleep(random.nextInt(Start.OUTPUTWORKER_MAX_PROCESS_TIME_MS));
                    job.setJobState(JobState.FINISH);
                    job.setMessage("Job is finished!");
                    System.out.printf("== [%s] finish job:  %s%n", name, job);
                } else {
                    countWaitCycle++;
                }
                Thread.sleep(random.nextInt(Start.OUTPUTWORKER_MAX_RELAX_TIME_MS));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("?? [%s] Nothing to do, I stop.%n", name);
    }
}