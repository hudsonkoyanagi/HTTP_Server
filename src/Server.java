import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Server {
    public static int PORT = 8080;
//    public static String SRC_DIR = "/Users/hudsonkoyanagi/Documents/Dev/personal-website/";
    public static String SRC_DIR = "/Users/hudsonkoyanagi/IdeaProjects/HTTP_Socket_Server/src/" +
        "";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT, 100, InetAddress.getByName("localhost"));
        Utils.logHead("localhost");
        while (true) {
            /* socket and stream initializations */
            Socket socket = serverSocket.accept();
            Utils.log("Connection made with: " + socket.getInetAddress());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            /* read and format incoming request */
            byte[] buffer = new byte[1024];
            int __ = dis.read(buffer, 0, 1024);
            HTTPRequest formattedRequest = new HTTPRequest(buffer);
            Utils.log(formattedRequest.getFilepath());

            byte[] fileOutBytes = new byte[1024];
            File f = new File(SRC_DIR + formattedRequest.getFilepath());
            long len = f.length();
            FileInputStream in2 = new FileInputStream(f);

            String response = ResponseGenerator.simpleTextData(len, formattedRequest.getAccept());

            dos.writeBytes(response);
            int count;
            while ((count = in2.read(fileOutBytes)) > 0) {
                dos.write(fileOutBytes, 0, count);
            }
            dis.close();
            dos.close();
            socket.close();
            Utils.log("Connection closed");
            Utils.logBr();
        }
    }
}
