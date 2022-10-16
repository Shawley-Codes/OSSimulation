public class Kernal {
    private static ProcessManager manager = new ProcessManager(); 
    private static InterProcessCommunication shared = new InterProcessCommunication();

    //the main method to run the kernel simulation
    public static void main(String[] args) {

        try {
            manager.main();
            Thread.sleep(41000); 
            shared.main();  
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Network client = new Network("whois.internic.net", 43, "google.com");
        Network client2 = new Network("google.com", 80);

        FileManager fileManager = new FileManager();
        fileManager.create("hello.txt", "OsSimulation/hello.txt");

    }

}
