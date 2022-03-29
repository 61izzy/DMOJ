import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), grid[][] = new int[n + 1][m + 1];
        boolean thing = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                grid[i][j] = scanner.nextInt();
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i][j - 1] + 1;
                    if (grid[i - 1][j] >= grid[i][j]) grid[i][j] = grid[i - 1][j] + 1;
                }
                if (grid[i][j - 1] >= grid[i][j]) thing = false;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[j - 1][i] >= grid[j][i]) thing = false;
            }
        }
        
        if (!thing) System.out.println(-1);
        else {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(j == 1 ? grid[i][j] : " " + grid[i][j]);
                }
                System.out.println();
            }
        }
    }
}
