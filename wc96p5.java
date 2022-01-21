import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt(), n = scanner.nextInt(), grid[][] = new int[m + 1][n + 1];
        
        while (true) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            if (x == 0 && y == 0) break;
            grid[x][y] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        System.out.println(grid[m][n]);
    }
}
