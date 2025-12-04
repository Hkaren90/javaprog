import java.net.*;
import java.io.*;

public class PR7A {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4000);
        System.out.println("Server ready for connection...");

        Socket socket = server.accept();
        System.out.println("Connection successful, waiting for file request...");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String filename = in.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String line;
        while ((line = fileReader.readLine()) != null) {
            out.println(line);
        }

        fileReader.close();
        in.close();
        out.close();
        socket.close();
        server.close();
    }
}
