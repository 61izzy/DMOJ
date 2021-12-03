import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), max = 0;
        int[] arr = new int[n], dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        
        System.out.println(max);
    }
}
