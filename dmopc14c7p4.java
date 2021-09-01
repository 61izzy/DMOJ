import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), h = scanner.nextInt(), breaks = 0;
        int[] t = new int[n];
        
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
        }
        
        for (int i = n - 1; i > 0; i--) {
            while (t[i] - t[i - 1] > h) {
                t[i - 1] += m;
                breaks++;
            }
        }
        
        System.out.println(breaks);
    }
}
