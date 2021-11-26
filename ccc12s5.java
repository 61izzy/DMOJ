import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int r = scanner.nextInt(), c = scanner.nextInt(), k = scanner.nextInt();
        boolean grid[][] = new boolean[r + 1][c + 1];
        int[][] arr = new int[r + 1][c + 1];
        arr[1][0] = 1;
        
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            grid[x][y] = true;
        }
        
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (!grid[i][j]) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        
        System.out.println(arr[r][c]);
    }
}
