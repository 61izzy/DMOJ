import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt(), u = scanner.nextInt(), r = scanner.nextInt();
        int[][] arr = new int[r + 1][3];
        int[][][] dp = new int[r + 1][m + 1][u + 1];
        
        for (int i = 1; i <= r; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= u; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= arr[i][1] && k >= arr[i][2]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], arr[i][0] + dp[i - 1][j - arr[i][1]][k - arr[i][2]]);
                    }
                }
            }
        }
        
        System.out.println(dp[r][m][u]);
    }
}
