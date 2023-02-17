import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GetRequestHandler {
    String resource; // Resource requested by user agent
    private byte[] response; // Response to

    public GetRequestHandler(String methodHeader, String headersRawText, OutputStream out) {
        HTTPRequest formattedRequest = new HTTPRequest(methodHeader, headersRawText);
    }

    public static byte[] notFound() {
        String response = lead + "404 Not Found\n\n";
        return response.getBytes();
    }

}