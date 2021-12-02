import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] dp = new int[n + 1], h = new int[n + 1];

        h[1] = scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            h[i] = scanner.nextInt();
            for (int j = 1; j <= k && j < i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(h[i] - h[i - j]));
            }
        }
        
        System.out.println(dp[n]);
    }
}
