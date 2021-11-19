import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int d = scanner.nextInt(), n = scanner.nextInt(), dp[] = new int[d + 1];

        for (int i = 1; i <= d; i++) {
            dp[i] = 10000;
        }
        
        for (int i = 1; i <= n; i++) {
            int v = scanner.nextInt();
            for (int j = 1; j <= d; j++) {
                if (v <= j) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - v]);
                }
            }
        }
        
        System.out.println(dp[d] == 10000 ? "Roberta acknowledges defeat." : "Roberta wins in " + dp[d] + " strokes.");
    }
}
