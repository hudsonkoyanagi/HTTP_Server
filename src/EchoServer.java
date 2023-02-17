import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

// Just exists so I can look at the headers
public class EchoServer {
    public static int PORT = 8080;
    //    public static String SRC_DIR = "/Users/hudsonkoyanagi/Documents/Dev/personal-website/";
    public static String SRC_DIR = "/Users/hudsonkoyanagi/IdeaProjects/HTTP_Socket_Server/src/";
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT, 100, InetAddress.getByName("localhost"));
        while (true) {
            Socket socket = serverSocket.accept();
            Utils.log("Connection made with: " + socket.getInetAddress());
            InputStream in = socket.getInputStream();

            byte[] bytes = new byte[8192];
            in.read(bytes);
            System.out.println(new String(bytes));

            in.close();
            socket.close();
        }
    }
}
