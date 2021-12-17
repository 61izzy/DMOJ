import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), c = scanner.nextInt();
        long[][] dp = new long[c + 1][2];
        
        for (int i = 0; i < n; i++) {
            int g = scanner.nextInt(), h = scanner.nextInt(), q = scanner.nextInt(), t = scanner.nextInt();
            for (int j = h; j <= c; j++) {
                dp[j][1] = g + dp[j - h][0];
            }
            for (int j = h + t; j <= c; j++) {
                dp[j][1] = Math.max(dp[j][1], q + dp[j - t][1]);
            }
            for (int j = h; j <= c; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1]);
            }
        }
        
        System.out.println(dp[c][0]);
    }
}
