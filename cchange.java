import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int x = scanner.nextInt(), n = scanner.nextInt();
        int[] dp = new int[x + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            int c = scanner.nextInt();
            for (int j = 1; j <= x; j++) {
                if (c <= j) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - c]);
                }
            }
        }
        
        System.out.println(dp[x]);
    }
}
