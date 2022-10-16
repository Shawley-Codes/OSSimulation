// This is a controller to demonstrate interproces communication

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class InterProcessCommunication {
    
    public static void main() {
        // Create the writer and reader objects
        Writer process1 = new Writer(); 
        Reader process2 = new Reader(); 
        
        // Start the executor service
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Run the processes
        executorService.execute(process2); 
        executorService.execute(process1);
        
        executorService.shutdown();
    }
}