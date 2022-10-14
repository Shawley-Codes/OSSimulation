public class Process implements Runnable {
    // Instance variables
    private int PID;
    private String state;
    private int programCounter = 0;
    private int programLength = 5;
    private int time;
    private int sleepTime = 1000;
    private boolean running = true;
    Memory memory = new Memory(); 
     
    
    // Constructor
    Process() {}
    
    Process (int PID, String state) {
        this.PID = PID;
        this.state = state;
    }
    
    // Get function for PID
    public int getPID() {
        return PID;
    }
    
    // Get function for state
    public String getState() {
        return state;
    }
    
    // Set function for stae
    public void setState(String state) {
        this.state = state;
    }
    
    // Set function for program counter
    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }
    
    // Get function for program counter
    public int getProgramCounter() {
        return programCounter;
    }
    
    // Set function for time
    public void setTime(int time) {
        this.time = time;
    }
    
    // Get function for time
    public int getTime() {
        return time;
    }
    
    // Get function for program length
    public int getProgramLength() {
        return programLength;
    }
    
    /*
    // Set function for interrupt
    public void setInterrupt(boolean value) {
        this.interrupt = value;
    }
*/
    
    @Override
    public void run() {
        try {
            while(running) { 
                Process executing = memory.removeProcess();
                System.out.printf("Process %d executing%n", executing.getPID()); 
                executing.setState("Running"); 
                System.out.printf("Process %d's state set to %s%n", executing.getPID(), executing.getState()); 
                for (int i = executing.getProgramCounter(); i < executing.getProgramLength() + 1; i++) {
                    Thread.sleep(sleepTime);
                    System.out.printf("Processor executing line %d%n", executing.getProgramCounter());
                    executing.setProgramCounter(i+1);
                }
                System.out.printf("Process %d terminating%n", executing.getPID()); 
            }
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        
            
        
        }
    }
}