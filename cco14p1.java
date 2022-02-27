import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), dp[][] = new int[n + 1][n + 1];
        long c = 0;
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next();
        }
        for (int i = 1; i <= n; i++) {
            if (grid[i - 1].charAt(0) == '#') {
                c++;
                dp[i][1] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if (grid[i - 1].charAt(j - 1) == '#') {
                    dp[i][j] = Math.min(dp[i][j - 2], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    c += dp[i][j];
                }
            }
        }
        System.out.println(c);
    }
}
