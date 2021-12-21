import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), q = scanner.nextInt(), sum = 0;
        int[][] arr = new int[n + 1][n + 1];
        
        for (int k = 0; k < q; k++) {
            int op = scanner.nextInt();
            if (op == 1) {
                int x = scanner.nextInt(), y = scanner.nextInt();
                for (int i = x; i <= n; i++) {
                    for (int j = y; j <= n; j++) {
                        arr[i][j]++;
                    }
                }
            }
            else {
                int x1 = scanner.nextInt() - 1, y1 = scanner.nextInt() - 1, x2 = scanner.nextInt(), y2 = scanner.nextInt();
                sum += arr[x2][y2] - arr[x2][y1] - arr[x1][y2] + arr[x1][y1];
            }
        }
        
        System.out.println(sum);
    }
}
