import java.net.ServerSocket;
import java.io.*;
import java.net.*;

public class Network {
    //simulate obtaining IP
    //sending out package
    //receiving package

    // constructor with port and hostname to fill a socket and a domainname for a whois client
    public Network(String hostname, int port, String domainName)
    {
        // attempts to connect to a server
        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("\nSocketing Successful\n");

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println(domainName);

            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String data;
            while ((data = reader.readLine()) != null) {
                System.out.println(data);
            }
        }

        //fails to connect to a server prints exception error
        catch (IOException e) {
            System.err.println(e);
        }
    }

    //not completely working
    //this method will connect and create a http client
    public Network(String hostname, int port)
    {
        // attempts to connect to a server
        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("\nSocketing Successful\n");

            //create our input output vars
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            writer.println( "GET " + hostname + " HTTP/1.0" );
            writer.println();

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        }

        //fails to connect to a server prints exceotion error
        catch (IOException e) {

            System.err.println(e);
        }
    }
}
