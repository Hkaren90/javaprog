import java.net.*;
import java.io.*;

public class PR7B {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 4000);

        System.out.print("Enter the filename: ");
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String filename = keyboard.readLine();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(filename);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        keyboard.close();
        out.close();
        in.close();
        socket.close();
    }
}
