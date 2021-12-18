import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), dp[][] = new int[2][n + 1];
        String s = scanner.next(), rev = "";
        
        for (int i = n - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[1][j] = dp[0][j - 1] + 1;
                }
                else {
                    dp[1][j] = Math.max(dp[0][j], dp[1][j - 1]);
                }
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        
        System.out.println(n - dp[1][n]);
    }
}
