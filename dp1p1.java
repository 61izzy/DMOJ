import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[][] dp = new int[n + 1][2];
        
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            for (int j = 0; j < 2; j++) {
                dp[i][j] = dp[i - 1][0];
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][1] + x);
                }
            }
        }
        
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}
