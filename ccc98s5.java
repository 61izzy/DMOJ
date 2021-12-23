import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        for (int k = 0; k < t; k++) {
            if (k != 0) System.out.println();
            n = scanner.nextInt();
            grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
            int res = bfs();
            System.out.println(res == 0x3f3f3f3f ? "CANNOT MAKE THE TRIP" : res);
        }
    }
    public static int bfs() {
        Queue<Integer> qx = new LinkedList<Integer>(), qy = new LinkedList<Integer>();
        int[][] dist = new int[n][n];
        qx.offer(0);
        qy.offer(0);

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 0x3f3f3f3f);
        }
        dist[0][0] = 0;
        
        while (!qx.isEmpty()) {
            int x = qx.poll(), y = qy.poll();
            if (x > 0 && dist[x - 1][y] > dist[x][y] + 1 && Math.abs(grid[x - 1][y] - grid[x][y]) < 3) {
                dist[x - 1][y] = grid[x - 1][y] > grid[0][0] || grid[x][y] > grid[0][0] ? dist[x][y] + 1 : dist[x][y];
                qx.offer(x - 1);
                qy.offer(y);
            }
            if (y > 0 && dist[x][y - 1] > dist[x][y] + 1 && Math.abs(grid[x][y - 1] - grid[x][y]) < 3) {
                dist[x][y - 1] = grid[x][y - 1] > grid[0][0] || grid[x][y] > grid[0][0] ? dist[x][y] + 1 : dist[x][y];
                qx.offer(x);
                qy.offer(y - 1);
            }
            if (x < n - 1 && dist[x + 1][y] > dist[x][y] + 1 && Math.abs(grid[x + 1][y] - grid[x][y]) < 3) {
                dist[x + 1][y] = grid[x + 1][y] > grid[0][0] || grid[x][y] > grid[0][0] ? dist[x][y] + 1 : dist[x][y];
                qx.offer(x + 1);
                qy.offer(y);
            }
            if (y < n - 1 && dist[x][y + 1] > dist[x][y] + 1 && Math.abs(grid[x][y + 1] - grid[x][y]) < 3) {
                dist[x][y + 1] = grid[x][y + 1] > grid[0][0] || grid[x][y] > grid[0][0] ? dist[x][y] + 1 : dist[x][y];
                qx.offer(x);
                qy.offer(y + 1);
            }
        }
        
        return dist[n - 1][n - 1];
    }
}
