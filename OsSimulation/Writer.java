import java.util.Scanner;


public class Writer implements Runnable {
    private int numberPacket;
    private int sleepTime = 3000; 
    private int printTime = 1000; 
    private SharedMemory memory = new SharedMemory(); 
    private int counter = 0; 
    private Scanner input = new Scanner(System.in);
    
    @Override 
    public void run() {
        try {
            while(counter != 5) {
                Thread.sleep(sleepTime); 
                if (!memory.isLocked()) {
                    memory.lockMutex();
                    System.out.printf("Enter an order number(integer): ");
                    numberPacket = input.nextInt(); 
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