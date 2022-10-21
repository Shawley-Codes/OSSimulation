import java.util.NoSuchElementException;


public class Process implements Runnable {
    // Instance variables
    private int PID;
    private String state;
    private int programCounter = 0;
    private int programLength = 12;
    private int sleepTime = 1500;
    private boolean running = true;
    private Memory memory = new Memory();
    private MidTermScheduler call = new MidTermScheduler();
    
    //Constructors
    public Process () {}
    
    public Process (int PID, String state) {
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
    
    // Function to stop the thread
    public void stop() {
        running = false; 
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Simulating Process Switching"); 
            while(running) { 
                // Pull a process object from the RAM
                Process executing = memory.removeProcess(); 
                // Set process status to "Running"
                executing.setState("Running"); 
                // Inform user 
                System.out.printf("Process %d's state set to %s%n", executing.getPID(), executing.getState());
                System.out.printf("Process %d executing%n", executing.getPID());
                // Counting from program counter up to total program lines in process
                for (int i = executing.getProgramCounter(); i < executing.getProgramLength() + 1; i++) {
                    // If interrupt is sent
                    if (call.getInterrupt() == true) { 
                        // Inform user
                        System.out.printf("Process Switching%n");
                        // Switch process state back to ready
                        executing.setState("Ready");
                        System.out.printf("Process %d's state set to %s%n", executing.getPID(), executing.getState()); 
                        // Add process back to RAM
                        memory.addProcess(executing); 
                        // Reset interrupt variable
                        call.setInterrupt(false);
                        break;
                    }
                    // Sleep thread
                    Thread.sleep(sleepTime);
                    // Inform user what line is executing
                    System.out.printf("Processor executing line %d%n", executing.getProgramCounter());
                    // Increase the program counter by one line
                    executing.setProgramCounter(i+1);
                } 
            }
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        catch(NoSuchElementException ex) {
            // Stop the thread when finished
            stop();  
        }
    }
}