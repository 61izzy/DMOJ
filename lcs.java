import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), arr1[] = new int[n + 1], arr2[] = new int[m + 1], dp[][] = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            arr2[i] = scanner.nextInt();
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        System.out.println(dp[n][m]);
    }
}
