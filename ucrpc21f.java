import java.io.*;
import java.util.*;

public class Main {
    static String[] grid;
    static int n, t;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        t = scanner.nextInt();
        grid = new String[n];
        
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next();
        }
        
        System.out.println(getDist());
    }
    public static int getDist() {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = grid[0].charAt(0) == 'b' ? t : 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n, (a, b) -> dist[a.x][a.y] - dist[b.x][b.y]);
        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int i = curr.x, j = curr.y;
            if (i > 0 && dist[i - 1][j] > dist[i][j] + (grid[i - 1].charAt(j) == 'b' ? t + 1 : 1)) {
                dist[i - 1][j] = dist[i][j] + (grid[i - 1].charAt(j) == 'b' ? t + 1 : 1);
                pq.offer(new Pair(i - 1, j));
            }
            if (j < n - 1 && dist[i][j + 1] > dist[i][j] + (grid[i].charAt(j + 1) == 'b' ? t + 1 : 1)) {
                dist[i][j + 1] = dist[i][j] + (grid[i].charAt(j + 1) == 'b' ? t + 1 : 1);
                pq.offer(new Pair(i, j + 1));
            }
            if (i < n - 1 && dist[i + 1][j] > dist[i][j] + (grid[i + 1].charAt(j) == 'b' ? t + 1: 1)) {
                dist[i + 1][j] = dist[i][j] + (grid[i + 1].charAt(j) == 'b' ? t + 1 : 1);
                pq.offer(new Pair(i + 1, j));
            }
            if (j > 0 && dist[i][j - 1] > dist[i][j] + (grid[i].charAt(j - 1) == 'b' ? t + 1 : 1)) {
                dist[i][j - 1] = dist[i][j] + (grid[i].charAt(j - 1) == 'b' ? t + 1 : 1);
                pq.offer(new Pair(i, j - 1));
            }
        }
        return dist[n - 1][n - 1];
    }
}

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
