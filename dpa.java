import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] dp = new int[n + 1], h = new int[n + 1];
        
        h[0] = Integer.MAX_VALUE;
        h[1] = scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            h[i] = scanner.nextInt();
            dp[i] = Math.min(dp[i - 1] + Math.abs(h[i] - h[i - 1]), dp[i - 2] + Math.abs(h[i] - h[i - 2]));
        }
        
        System.out.println(dp[n]);
    }
}
