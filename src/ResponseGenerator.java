import javax.print.DocFlavor;

public class ResponseGenerator {

    private static final String FRONT = "HTTP/1.1 ";
    private static final String END = "\n\n";
    private long contentLength;
    private String contentType;
    private String responseHeader;

    public ResponseGenerator(String responseHeader, long contentLength, String contentType){
        this.responseHeader = responseHeader;
        this.contentLength = contentLength;
        this.contentType = contentType;
    }
    //For use when error occurs
    public ResponseGenerator(String responseHeader){
        this.responseHeader = responseHeader;
    }
    public String errorResponse(){
        return FRONT + this.responseHeader + END;

    }
}
