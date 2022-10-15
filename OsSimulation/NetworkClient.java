import java.io.*;
import java.net.*;

//code example for network client taken from geeks for geeks

public class NetworkClient {
        // initialize socket and input output streams
        private Socket socket = null;
        private DataInputStream input = null;
        private DataOutputStream out = null;

        // constructor to put ip address and port
        public NetworkClient(String address, int port) {

            // establish a connection
            try {

                socket = new Socket(address, port);

                System.out.println("Connected");

                // takes input from terminal
                input = new DataInputStream(System.in);

                // sends output to the socket
                out = new DataOutputStream(
                        socket.getOutputStream());
            } catch (IOException u) {

                System.out.println(u);
            }

            // string to read message from input
            String line = "";

            // keep reading until "End" is input
            while (!line.equals("End")) {

                try {

                    line = input.readUTF();

                    out.writeUTF(line);
                } catch (IOException i) {

                    System.out.println(i);
                }
            }

            // close the connection
            try {

                input.close();

                out.flush();
                out.close();

                socket.close();
            } catch (IOException i) {

                System.out.println(i);
            }
        }

}
