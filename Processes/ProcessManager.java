import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class ProcessManager {
    
    public static void main() {
        Process P1 = new Process(1, "ready");
        Process P2 = new Process(2, "ready");
        Scheduler schedule = new Scheduler();

        Memory call = new Memory(); 

        call.addProcess(P1);
        call.addProcess(P2); 

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(P1); 
        executorService.execute(schedule); 

        executorService.shutdown();
    }
}