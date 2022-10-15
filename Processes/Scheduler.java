

public class Scheduler implements Runnable {
    private int sleepTime = 8000;
    private boolean running = true;
    private boolean ans = false;
    MidTermScheduler call = new MidTermScheduler();
    Memory memory = new Memory(); 
    
    // Constructor
    Scheduler() {}
    
    public void stop() {
        running = false; 
    }
    
    // send signal for process switch
    @Override
    public void run() {
        try {
            while(running) {
                Thread.sleep(sleepTime);
                if (memory.queueEmpty()) {
                    stop(); 
                }
                call.setInterrupt(true); 
            }
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}