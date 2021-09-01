import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.next(), e = scanner.next();
        
        while(s.indexOf(e) != -1) {
            s = s.replace(e, "");
        }
        
        System.out.println(s.equals("") ? "FRULA" : s);
    }
}
