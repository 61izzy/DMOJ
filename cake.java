import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt(), arr[][] = new int[n + 2][m + 2];
        long[][] psa = new long[n + 1][m + 1];
        
        for (int i = 0; i < k; i++) {
            int x1 = scanner.nextInt(), y1 = scanner.nextInt(), x2 = scanner.nextInt() + 1, y2 = scanner.nextInt() + 1;
            arr[x1][y1]++;
            arr[x2][y2]++;
            arr[x1][y2]--;
            arr[x2][y1]--;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] += arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
                psa[i][j] = arr[i][j] + psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1];
            }
        }
        
        int q = scanner.nextInt();
        
        for (int i = 0; i < q; i++) {
            int x1 = scanner.nextInt() - 1, y1 = scanner.nextInt() - 1, x2 = scanner.nextInt(), y2 = scanner.nextInt();
            System.out.println(psa[x2][y2] - psa[x1][y2] - psa[x2][y1] + psa[x1][y1]);
        }
    }
}
