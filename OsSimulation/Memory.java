import java.util.LinkedList;
import java.util.Queue;


public class Memory {
    private static Queue<Process> memory = new LinkedList<Process>();
    
    public void addProcess(Process object) {
        memory.add(object);
    }
    
    public Process removeProcess() {
        return memory.remove();
    }
    
    public static boolean queueEmpty() {
         return memory.isEmpty();
    }
    
}