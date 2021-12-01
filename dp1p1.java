import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] dp = new int[n + 2];

        for (int i = 2; i < n + 2; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + scanner.nextInt());
        }

        System.out.println(dp[n + 1]);
    }
}
