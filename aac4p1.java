import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), arr[] = new int[m], max = 0, j = 0, idx = 0;
        String x = scanner.next();
        
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            if (x.charAt(i) == '0') {
                if (arr[j] >= max) {
                    max = arr[j];
                    idx = i;
                }
                j++;
            }
        }
        
        for (int i = idx; i <= idx + n; i++) {
            if (x.charAt(i%n) == '0') continue;
            System.out.print(x.charAt(i%n));
        }
        
        System.out.println();
    }
}
