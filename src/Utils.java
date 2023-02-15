public class Utils {

    public static String nSpaces(int n){
        String s = "";
        for(int i = 0; i < n; i++){
            s += " ";
        }
        return s;
    }
    public static void log(String s){
        if(s.length() > 50) {
            int cur = 0;
            while (cur + 50 < s.length()) {
                System.out.println("|| SERVER ~ " + s.substring(cur, cur + 50) + " ||");
                cur += 50;
            }
            if (cur < s.length()) {
                System.out.println("|| SERVER ~ " + s.substring(cur) + nSpaces(50 - cur) + " ||");
            }
        } else {
            System.out.println("|| SERVER ~ " + nSpaces(50-s.length()) + s.substring(0, s.length()) + " ||");
        }
    }

    public static void logBr(){
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }
    
    public static void logHead(String s){
        if(s.length() > 50){
            System.out.println( "bad arg");
        }else{
            logBr();
            String str = s + " starting up...";
            int len = str.length();
            System.out.println("|||| " +  nSpaces((55 - len + (len%2))/2 ) + str + nSpaces((55 - len)/2) +  " ||||");
            logBr();
        }
    }
}
