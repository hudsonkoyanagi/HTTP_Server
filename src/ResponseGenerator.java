public class ResponseGenerator {
    public static String simpleTextData(long s, String contentType) {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: ")
                .append(contentType)
                .append("\n")
                .append("Content-Length: ")
                .append(s)
                .append("\n\n");
        return response.toString();
    }
}
