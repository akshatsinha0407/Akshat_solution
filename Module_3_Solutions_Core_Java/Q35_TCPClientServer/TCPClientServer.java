import java.io.*;
import java.net.*;

// Run Server: java TCPClientServer server
// Run Client: java TCPClientServer client
public class TCPClientServer {
    public static void main(String[] args) throws Exception {
        if (args.length == 0 || args[0].equals("server")) {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server listening on port 5000...");
            Socket client = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hello from Server!");
            System.out.println("Client says: " + in.readLine());
            server.close();
        } else {
            Socket socket = new Socket("localhost", 5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Server says: " + in.readLine());
            out.println("Hello from Client!");
            socket.close();
        }
    }
}
