import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt(), n = scanner.nextInt(), k = scanner.nextInt(), count = 0, x;
        int[][] board = new int[m][n];
        int[] row = new int[m], column = new int[n];
        char c;
        
        for (int i = 0; i < k; i++) {
            c = scanner.next().charAt(0);
            x = scanner.nextInt() - 1;
            if (c == 'R') {
                row[x]++;
            }
            else {
                column[x]++;
            }
        }

        for (int r = 0; r < m; r++) {
            if (row[r]%2 == 1) {
                for (int col = 0; col < n; col++) {
                    board[r][col] = 1;
                    count++;
                }
            }
        }
        
        for (int col = 0; col < n; col++) {
            if (column[col]%2 == 1) {
                for (int r = 0; r < m; r++) {
                    if (board[r][col] == 1) {
                        board[r][col] = 0;
                        count--;
                    }
                    else {
                        board[r][col] = 1;
                        count++;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}
