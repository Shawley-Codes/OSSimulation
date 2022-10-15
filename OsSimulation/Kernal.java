public class Kernal {


    //the main method to run the kernel simulation
    public static void main(String[] args) {

        Network server = new Network(5000);
        NetworkClient client = new NetworkClient("127.0.0.1", 5000); ;
    }

}
