import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), max = 0, min = Integer.MAX_VALUE;
        long x = 0;
        String s = scanner.next(), t = scanner.next();
        int[] arr = new int[26];
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            arr[c]++;
            if (arr[c] > max) max = arr[c];
        }
        
        for (int i = 0; i < m; i++) {
            int c = t.charAt(i) - 'A';
            x += arr[c];
            if (arr[c] < min) min = arr[c];
        }
        if (max > min) x += max - min;
        
        System.out.println(x);
    }
}
