// This is a scheduler to allot time for each process

public class Scheduler implements Runnable {
    // Instance variables
    private int sleepTime = 8000;
    private boolean running = true;
    private boolean ans = false;
    MidTermScheduler call = new MidTermScheduler();
    Memory memory = new Memory(); 
    
    // Constructor
    Scheduler() {}
    
    // Function to stop running thread
    public void stop() {
        running = false; 
    }
    
    // send signal for process switch
    @Override
    public void run() {
        try {
            while(running) {
                // Sleep thread
                Thread.sleep(sleepTime);
                // Stop when no more running processes
                if (memory.queueEmpty()) {
                    stop(); 
                }
                // Wake up and set interrupt to true for process switch
                call.setInterrupt(true); 
            }
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}