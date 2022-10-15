
public class Kernel {
    public static ProcessManager manager = new ProcessManager(); 
    public static InterProcessCommunication shared = new InterProcessCommunication(); 
    
    public static void main(String[] args) {
        
        //manager.main(); 
        shared.main(); 
    }
}