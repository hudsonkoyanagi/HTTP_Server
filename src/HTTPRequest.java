import java.util.HashMap;

public class HTTPRequest {

    HashMap<String, String> headers = new HashMap<String, String>();
    String method;
    String resource;

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public String getMethod() {
        return method;
    }

    public String getResource() {
        return resource;
    }

    public HTTPRequest(String methodHeader, String rawHeaderText){
        String[]splitMethodHeader = methodHeader.split(" ");
        this.method = splitMethodHeader[0];
        this.resource = splitMethodHeader[1];
        String[] headersToSplit = rawHeaderText.split("\n");
        for(String s: headersToSplit){
            String[] temp = s.split(": ");
            headers.put(temp[0], temp[1]);
        }
    }
}

