import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt(), n = scanner.nextInt(), sum, r = scanner.nextInt(), c = scanner.nextInt(), x = scanner.nextInt();
        int[][] board = new int[m + 1][n + 1];
        
        while (r != 0 && c != 0) {
            board[r][c] = x;
            r = scanner.nextInt();
            c = scanner.nextInt();
            x = scanner.nextInt();
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1] + (i%2 == j%2 ? board[i][j] : -board[i][j]);
            }
        }

        int r1 = scanner.nextInt(), c1 = scanner.nextInt(), r2 = scanner.nextInt(), c2 = scanner.nextInt();
        
        while (r1 != 0 && r2 != 0 && c1 != 0 && c2 != 0) {
            r1--;
            c1--;
            sum = board[r2][c2] + board[r1][c1] - board[r1][c2] - board[r2][c1];

            if (r1%2 != c1%2) {
                sum = -sum;
            }
            
            System.out.println(sum);
            
            r1 = scanner.nextInt();
            c1 = scanner.nextInt();
            r2 = scanner.nextInt();
            c2 = scanner.nextInt();
        }
    }
}
