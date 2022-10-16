import java.util.LinkedList;
import java.util.Queue;


public class SharedMemory {
    private static Queue<Integer> sharedMemory = new LinkedList<Integer>();
    private static boolean mutexLock = false;
    
    public void addPacket(int i) {
        sharedMemory.add(i); 
    }
    
    public int removePacket() {
        return sharedMemory.remove();
    }
    
    public void lockMutex() {
        this.mutexLock = true;
    }
    
    public void unlockMutex() {
        this.mutexLock = false;
    }
    
    public static boolean isLocked() {
        return mutexLock; 
    }
}