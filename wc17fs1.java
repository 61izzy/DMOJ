import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), d = 0;
        int[] c = new int[n], m = new int[n];
        
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        Arrays.sort(c);
        for (int i = 0; i < n; i++) {
            m[i] = scanner.nextInt();
        }
        Arrays.sort(m);
        
        for (int i = 0; i < n; i++) {
            d = Math.max(d, Math.abs(c[i] - m[i]));
        }
        
        System.out.println(d);
    }
}
