import java.security.SecureRandom;


public class Writer implements Runnable {
    private int numberPacket;
    private static SecureRandom randomNumber = new SecureRandom();
    private int sleepTime = 3000; 
    private int printTime = 1000; 
    private SharedMemory memory = new SharedMemory(); 
    private int counter = 0; 
    
    public void generateNumber() {
        numberPacket = randomNumber.nextInt(10); 
    }
    
    @Override 
    public void run() {
        try {
            while(counter != 10) {
                Thread.sleep(sleepTime); 
                if (!memory.isLocked()) {
                    memory.lockMutex();
                    generateNumber(); 
                    memory.addPacket(numberPacket);
                    memory.unlockMutex();
                    counter++; 
                    System.out.printf("Process 1 placed number %d into shared memory%n", numberPacket);
                }
            }
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}