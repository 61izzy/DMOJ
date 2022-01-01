import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        int n = s.length();
        int[] arr = new int[26],  dp = new int[n + 1];
        Arrays.fill(arr, -1);
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * 2;
            if (arr[s.charAt(i - 1) - 'a'] != -1) {
                dp[i] -= dp[arr[s.charAt(i - 1) - 'a']];
            }
            arr[s.charAt(i - 1) - 'a'] = i - 1;
            dp[i] %= 10007;
        }
        
        System.out.println((dp[n] - 1)%10007);
    }
}
