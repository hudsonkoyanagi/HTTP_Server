import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.spec.RSAOtherPrimeInfo;

public class Client {

    public void log(String s){
        System.out.println("");
    }

    public static int PORT = 8080;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT, 100, InetAddress.getByName("localhost"));
        while (true) {
            byte[] commandBuffer = new byte[3];
            byte[] buffer = new byte[1024];
            /* socket and stream initializations */
            Socket socket = serverSocket.accept();
            System.out.println("Connection made with: " + socket.getInetAddress());
            InputStream dis = socket.getInputStream();


            int __ = dis.read(commandBuffer);
            String command = new String(commandBuffer);
            System.out.println(command);

            /* read and format incoming request */
            int count;
            while ((count = dis.read(buffer)) > 0) {
                System.out.println(new String(buffer));
                System.out.println(count);
            }

            dis.close();
            socket.close();
            System.out.println("Connection closed");

        }
    }
}
