import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n;
        String p = "";
        
        do {
            n = scanner.nextInt();
            if (n != 99999) {
                if (n < 1000) {
                    System.out.println(p + " " + n);
                }
                else if ((n/10000 + n%10000/1000)%2 == 0) {
                    p = "right";
                    System.out.println(p + " " + n%1000);
                }
                else {
                    p = "left";
                    System.out.println(p + " " + n%1000);
                }
            }
        }
        while (n != 99999);
    }
}
