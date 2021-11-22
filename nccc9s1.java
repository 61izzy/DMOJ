import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
            if ((a + b * 2 + c * 3)%2 == 0) {
                if (a%2 == c%2 && c <= a && (0 < a || b%2 == 0)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
