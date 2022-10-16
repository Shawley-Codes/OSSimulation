import java.util.NoSuchElementException;


public class Reader implements Runnable {
    private int numberPacket;
    private int sleepTime = 3100; 
    private int printTime = 1000;
    private SharedMemory memory = new SharedMemory(); 
    private int counter = 0;
    
    @Override
    public void run() {
        try {
            while(counter != 5) {
                Thread.sleep(sleepTime);
                if (!memory.isLocked()) {
                    memory.lockMutex();
                    numberPacket = memory.removePacket();
                    memory.unlockMutex();
                    counter++;
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