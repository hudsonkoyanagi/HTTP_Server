import java.nio.charset.StandardCharsets;

public class HTTPRequest {
    private String requestRaw;
    private String requestType;
    private String accept;
    private String filepath;

    public String getRequestRaw() {
        return requestRaw;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getAccept() {
        return accept;
    }

    public String getFilepath() {
        return filepath;
    }

    public String toString(){
        return "Request type: " + this.requestType + "\n" +
                "Accept: " + this.accept + "\n" +
                "Filename: " + this.filepath;
    }

    public HTTPRequest(byte[]requestBytes){
        String requestRaw = new String(requestBytes, StandardCharsets.UTF_8);
        this.requestRaw = requestRaw;
        String[] headers = requestRaw.split("\n");
        String[] mainHeader = headers[0].split(" ");
        this.requestType = mainHeader[0];
        switch (this.requestType) {
            case "GET" -> {
                this.filepath =  mainHeader[1].substring(1);
                if(this.filepath.isEmpty()){
                    this.filepath = "index.html";
                }
                for(String s: headers){
                    if(s.startsWith("Accept:")){
//                        accept = s.substring(8);
                        this.accept = "html";
                    }
                }
            }
            case "PUT" -> {
                this.filepath =  mainHeader[1].substring(1);
            }
            case "POST" -> {
                this.filepath =  mainHeader[1].substring(1);
            }
            case "DELETE" -> {
                break;
            }
            default -> {
                System.out.println("Invalid HTTP request");
                break;
            }
        }

    }
}

