import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] grid = new int[n + 1][m + 1];
        Arrays.fill(grid[0], Integer.MAX_VALUE);
        grid[0][1] = 0;
        
        for (int i = 1; i <= n; i++) {
            grid[i][0] = Integer.MAX_VALUE;
            for (int j = 1; j <= m; j++) {
                grid[i][j] = scanner.nextInt() + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        System.out.println(grid[n][m]);
    }
}
