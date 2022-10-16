// This writer is to simulate a process communicating with another using a mutex

import java.util.Scanner;


public class Writer implements Runnable {
    // Instance variables
    private static int numberPacket;
    private int sleepTime = 3000; 
    private int printTime = 1000; 
    private SharedMemory memory = new SharedMemory(); 
    private int counter = 0; 
    private Scanner input = new Scanner(System.in);
    
    @Override 
    public void run() {
        try {
            // Only running 5 times
            while(counter != 5) {
                // Sleep thread
                Thread.sleep(sleepTime); 
                // Check if mutex is unlocked
                if (!memory.isLocked()) {
                    // Lock the mutex
                    memory.lockMutex();
                    // Ask for user input
                    System.out.printf("Order number(integer): %d\n", numberPacket++);
                    // Add integer to queue
                    memory.addPacket(numberPacket);
                    // Unlock the mutex
                    memory.unlockMutex();
                    // Increase counter
                    counter++; 
                    // Inform user
                    System.out.printf("Process 1 placed number %d into shared memory%n", numberPacket);
                }
            }
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}