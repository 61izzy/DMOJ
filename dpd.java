import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), c = scanner.nextInt(), w[] = new int[n + 1];
        long[] v = new long[n + 1], dp = new long[c + 1];
        
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextLong();
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = c; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        
        System.out.println(dp[c]);
    }
}
