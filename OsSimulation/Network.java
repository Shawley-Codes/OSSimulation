import java.net.ServerSocket;
import java.io.*;
import java.net.*;

//code example for network server taken from geeks for geeks

public class Network {
    //simulate obtaining IP
    //sending out package

    // initialize socket and input stream
    Socket socket = null;
    ServerSocket server = null;
    DataInputStream in = null;

    // constructor with port
    public Network(int port)
    {

        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);

            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            socket = server.accept();

            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(
                            socket.getInputStream()));

            String line = "";

            // reads message from client until "End" is sent
            while (!line.equals("End")) {

                try {

                    line = in.readUTF();

                    System.out.println(line);
                }

                catch (IOException i) {

                    System.out.println(i);
                }
            }

            System.out.println("Closing connection");

            // close connection
            socket.close();

            in.close();
        }

        catch (IOException i) {

            System.out.println(i);
        }
    }
}
