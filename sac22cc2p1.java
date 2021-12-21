import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a = scanner.nextInt(), k = scanner.nextInt(), prev = 0;
        int[] d = new int[a];
        String[] s = new String[a];
        
        for (int i = 0; i < a; i++) {
            d[i] = scanner.nextInt();
            s[i] = scanner.next();
        }
        
        for (int i = 0; i < k; i++) {
            int c = scanner.nextInt();
            for (int j = 0; j < a; j++) {
                if (prev < d[j] && d[j] <= c) {
                    System.out.println(s[j]);
                }
            }
            prev = c;
        }
    }
}
