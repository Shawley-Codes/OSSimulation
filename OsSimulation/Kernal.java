public class Kernal {
    private static ProcessManager manager = new ProcessManager(); 
    private static InterProcessCommunication shared = new InterProcessCommunication();

    //the main method to run the kernel simulation
    public static void main(String[] args) {


        Network server = new Network(5000);
        NetworkClient client = new NetworkClient("127.0.0.1", 5000);

        /*

        try {
            manager.main();
            Thread.sleep(41000); 
            shared.main();  
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

*/
    }

}
