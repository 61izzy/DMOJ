import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[][] dp = new int[n + 1][3];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j - 1] = scanner.nextInt() + Math.max(dp[i - 1][j%3], dp[i - 1][(j + 1)%3]);
            }
        }
        
        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
    }
}
