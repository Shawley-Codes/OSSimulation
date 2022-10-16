// This represents shared memory for interprocess communication

import java.util.LinkedList;
import java.util.Queue;


public class SharedMemory {
    // Using a queue
    private static Queue<Integer> sharedMemory = new LinkedList<Integer>();
    // Using a mutex
    private static boolean mutexLock = false;
    
    // Function to add integers to queue
    public void addPacket(int i) {
        sharedMemory.add(i); 
    }
    
    // Function to remove integers from queue
    public int removePacket() {
        return sharedMemory.remove();
    }
    
    // Function to lock the mutex
    public void lockMutex() {
        this.mutexLock = true;
    }
    
    // Function to unlock the mutex
    public void unlockMutex() {
        this.mutexLock = false;
    }
    
    // Function to get mutex condition
    public static boolean isLocked() {
        return mutexLock; 
    }
}