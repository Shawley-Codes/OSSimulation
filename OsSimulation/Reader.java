// This reader is to simulate a process communicating with another using a mutex

import java.util.NoSuchElementException;


public class Reader implements Runnable {
    // Instance variables
    private int numberPacket;
    private int sleepTime = 3100; 
    private int printTime = 1000;
    private SharedMemory memory = new SharedMemory(); 
    private int counter = 0;
    
    @Override
    public void run() {
        try {
            // Only running 5 times
            while(counter != 5) {
                // Sleep thread
                Thread.sleep(sleepTime);
                // Check if mutex is unlocked
                if (!memory.isLocked()) {
                    // Lock mutex
                    memory.lockMutex();
                    // remove the integer from the queue
                    numberPacket = memory.removePacket();
                    // Unlock the mutex
                    memory.unlockMutex();
                    // Increse counter
                    counter++;
                    // Inform the user
                    System.out.printf("Process 2 removed number %d from shared memory%n", numberPacket); 
                }
            }
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        catch(NoSuchElementException ex) {
            run(); 
        }
    }
}