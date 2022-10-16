import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class InterProcessCommunication {
    
    public static void main() {
        Writer process1 = new Writer(); 
        Reader process2 = new Reader(); 
        
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(process2); 
        executorService.execute(process1);
        
        executorService.shutdown();
    }
}