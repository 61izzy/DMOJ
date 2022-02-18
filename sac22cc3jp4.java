import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int q = scanner.nextInt();
        
        for(; q > 0; q--) {
            int b1, b2;
            String n;
            b1 = scanner.nextInt();
            n = scanner.next();
            b2 = scanner.nextInt();
            System.out.println(Integer.toString(Integer.parseInt(n, b1), b2));
        }
    }
}
