import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static int PORT = 8080;
    //public static String SRC_DIR = "/Users/hudsonkoyanagi/Documents/Dev/personal-website/";
    public static String SRC_DIR = "/Users/hudsonkoyanagi/IdeaProjects/HTTP_Socket_Server/src/web_sources/";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT, 100, InetAddress.getByName("localhost"));
        Utils.logHead("localhost");
        while (true) {
            /* socket and stream initializations */
            Socket socket = serverSocket.accept();
            Utils.log("Connection made with: " + socket.getInetAddress());
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            /* read first line of request to determine request method */
            StringBuilder methodHeader = new StringBuilder();
            int b;
            while((b = in.read()) !=  '\n')
                methodHeader.append((char) b);
            String type = methodHeader.substring(0, methodHeader.indexOf(" "));

            /* different handlers depending on method */
            switch (type){
                case("GET"):
                    byte[] headersBytes = new byte[8192];
                    int numReadBytes = in.read(headersBytes);
                    GetRequestHandler handler = new GetRequestHandler(methodHeader.toString(), new String(headersBytes), out);
                    break;
                //to fill in later with PUT, POST, etc
                default:
                    Utils.log("ERROR ENCOUNTERED!");
                    Utils.logBr();
            }


            /* clean up */
            in.close();
            out.close();
            socket.close();
            Utils.log("Connection closed");
            Utils.logBr();
        }
    }
}
