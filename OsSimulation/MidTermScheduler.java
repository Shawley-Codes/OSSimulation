// This is a Midterm Scheduler to hold interrupt condition for context switching

public class MidTermScheduler {
    // Variable to send signal for interrupt condition
    private static boolean interrupt = false;
    
    // Function to set interrupt variable
    public void setInterrupt(boolean value) {
        this.interrupt = value;
    }
    
    // Function to get interrupt variable
    public boolean getInterrupt() {
        return interrupt;
    }
}