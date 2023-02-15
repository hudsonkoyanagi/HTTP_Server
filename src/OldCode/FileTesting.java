package OldCode;

import java.io.IOException;

public class FileTesting {

    static final String MAIN_DIR = "/Users/hudsonkoyanagi";

    public static void main(String[] args) throws IOException {
        Node node = new Node(MAIN_DIR);
        for(Node n : node.getNodes()){
            System.out.println(n.getFilePath());
        }
        /*String dir = "/Users/hudsonkoyanagi/ServerFolder";
        Node n = new Node(dir);
        for(Node i : n.getNodes()){
            System.out.println(i.getFilePath());
            for(Node x : i.getNodes()){
                System.out.println(x.getFilePath());
            }
        }
    */

    }
}
