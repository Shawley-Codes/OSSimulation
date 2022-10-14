import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ProcessManager {

	public static void main(String[] args) {
		Process P1 = new Process(1, "ready");
        Process P2 = new Process(2, "ready");
        Process P3 = new Process(3, "ready");
        
        Memory call = new Memory(); 
        
        call.addProcess(P1);
        call.addProcess(P2); 
        call.addProcess(P3); 
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        executorService.execute(P1); 
        
        executorService.shutdown();
	}
}