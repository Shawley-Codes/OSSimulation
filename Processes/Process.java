import java.util.NoSuchElementException;


public class Process implements Runnable {
    // Instance variables
    private int PID;
    private String state;
    private int programCounter = 0;
    private int programLength = 12;
    private int sleepTime = 1500;
    private boolean running = true;
    Memory memory = new Memory();
    MidTermScheduler call = new MidTermScheduler();
    
    //Constructors
    Process () {}
    
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
    
    // Get function for program length
    public int getProgramLength() {
        return programLength;
    }
    
    public void stop() {
        running = false; 
    }
    
    @Override
    public void run() {
        try {
            while(running) { 
                Process executing = memory.removeProcess(); 
                executing.setState("Running"); 
                System.out.printf("Process %d's state set to %s%n", executing.getPID(), executing.getState());
                System.out.printf("Process %d executing%n", executing.getPID());
                for (int i = executing.getProgramCounter(); i < executing.getProgramLength() + 1; i++) {
                    if (call.getInterrupt() == true) { 
                        System.out.printf("Process Switching%n");
                        executing.setState("Ready");
                        System.out.printf("Process %d's state set to %s%n", executing.getPID(), executing.getState()); 
                        memory.addProcess(executing); 
                        call.setInterrupt(false);
                        break;
                    }
                    Thread.sleep(sleepTime);
                    System.out.printf("Processor executing line %d%n", executing.getProgramCounter());
                    executing.setProgramCounter(i+1);
                } 
            }
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        catch(NoSuchElementException ex) {
            stop();  
        }
    }
}