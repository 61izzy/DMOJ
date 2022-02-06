import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] adj;
    static boolean[] vis;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        m = scanner.nextInt();
        int max = 0;
        adj = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                adj[i][j] = 1;
            }
            adj[i][i] = 0;
        }
        
        for (int i = 0; i < m; i++) {
            int r1 = scanner.nextInt(), r2 = scanner.nextInt();
            adj[r1][r2] = 0;
            adj[r2][r1] = 0;
        }
        
        for (int i = n; i > 0; i--) {
            vis = new boolean[n + 1];
            int[] dummy = new int[n + 1];
            System.arraycopy(adj[i], 0, dummy, 0, n + 1);
            max = Math.max(dfs(i, dummy), max);
        }
        
        System.out.println(max);
    }
    public static int dfs(int x, int[] arr) {
        vis[x] = true;
        int[] temp = new int[n + 1];
        System.arraycopy(adj[x], 0, temp, 0, n + 1);
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) temp[i] = 0;
        }

        int max = 0;
        for (int i = n; i > 0; i--) {
            if (temp[i] != 0 && !vis[i]) max = Math.max(max, dfs(i, temp));
        }
        return max + 1;
    }
}
