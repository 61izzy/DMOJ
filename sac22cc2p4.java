import java.io.*;
import java.util.*;

public class Main {
    static String[] grid;
    static int n, m, dist[][];
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        m = scanner.nextInt();
        grid = new String[n];
        dist = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        getDist();
        System.out.println(dist[n - 1][m - 1]);
    }
    public static void getDist() {
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(n, (a, b) -> dist[a.x][a.y] - dist[b.x][b.y]);
        q.offer(new Pair(0, 0));
        dist[0][0] = grid[0].charAt(0) == 'C' ? 1 : 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.x > 0 && dist[p.x][p.y] + (grid[p.x - 1].charAt(p.y) == 'C' ? 1 : 0) < dist[p.x - 1][p.y]) {
                q.offer(new Pair(p.x - 1, p.y));
                dist[p.x - 1][p.y] = (grid[p.x - 1].charAt(p.y) == 'C' ? 1 : 0) + dist[p.x][p.y];
            }
            if (p.y > 0 && dist[p.x][p.y] + (grid[p.x].charAt(p.y - 1) == 'C' ? 1 : 0) < dist[p.x][p.y - 1]) {
                q.offer(new Pair(p.x, p.y - 1));
                dist[p.x][p.y - 1] = (grid[p.x].charAt(p.y - 1) == 'C' ? 1 : 0) + dist[p.x][p.y];
            }
            if (p.x < n - 1 && dist[p.x][p.y] + (grid[p.x + 1].charAt(p.y) == 'C' ? 1 : 0) < dist[p.x + 1][p.y]) {
                q.offer(new Pair(p.x + 1, p.y));
                dist[p.x + 1][p.y] = (grid[p.x + 1].charAt(p.y) == 'C' ? 1 : 0) + dist[p.x][p.y];
            }
            if (p.y < m - 1 && dist[p.x][p.y] + (grid[p.x].charAt(p.y + 1) == 'C' ? 1 : 0) < dist[p.x][p.y + 1]) {
                q.offer(new Pair(p.x, p.y + 1));
                dist[p.x][p.y + 1] = (grid[p.x].charAt(p.y + 1) == 'C' ? 1 : 0) + dist[p.x][p.y];
            }
        }
    }
}

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
