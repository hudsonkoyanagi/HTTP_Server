public class RequestParser {
    public static String requestTypeHandler(String request){
        String type = request.substring(0,3);
        String[] headers = request.split("\n");
        String[] mainHeader = headers[0].split(" ");
        switch (type) {
            case "GET" -> {
                return mainHeader[1].substring(1);
            }
            case "PUT" -> {
                System.out.println("data to put: " + headers[headers.length - 1]);
                return "Valid request";
            }
            case "POS" -> {
                System.out.println("data to post: " + headers[headers.length - 1]);
                return "Valid request";
            }
            case "DEL" -> {
                System.out.println("data to delete: " + mainHeader[2]);
                return "Valid request";
            }
            default -> {
                return "Invalid HTTP request";
            }
        }
    }
}
