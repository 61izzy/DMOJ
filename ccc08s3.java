import java.io.*;
import java.util.*;

public class Main {
    static String[] grid;
    static int r, c;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            r = scanner.nextInt();
            c = scanner.nextInt();
            grid = new String[r];
            for (int j = 0; j < r; j++) {
                grid[j] = scanner.next();
            }
            int res = bfs();
            System.out.println(res == 0 ? -1 : res);
        }
    }
    public static int bfs() {
        Queue<Integer> qx = new LinkedList<Integer>(), qy = new LinkedList<Integer>();
        int[][] dist = new int[r][c];
        qx.offer(0);
        qy.offer(0);
        dist[0][0] = 1;
        while (!qx.isEmpty()) {
            int x = qx.poll(), y = qy.poll();
            if (grid[x].charAt(y) == '*') dist[x][y] = 0;
            if (grid[x].charAt(y) == '+' || grid[x].charAt(y) == '|') {
                if (x < r - 1 && dist[x + 1][y] == 0) {
                    qx.offer(x + 1);
                    qy.offer(y);
                    dist[x + 1][y] = dist[x][y] + 1;
                }
                if (x > 0 && dist[x - 1][y] == 0) {
                    qx.offer(x - 1);
                    qy.offer(y);
                    dist[x - 1][y] = dist[x][y] + 1;
                }
            }
            if (grid[x].charAt(y) == '+' || grid[x].charAt(y) == '-') {
                if (y < c - 1 && dist[x][y + 1] == 0) {
                    qx.offer(x);
                    qy.offer(y + 1);
                    dist[x][y + 1] = dist[x][y] + 1;
                }
                if (y > 0 && dist[x][y - 1] == 0) {
                    qx.offer(x);
                    qy.offer(y - 1);
                    dist[x][y - 1] = dist[x][y] + 1;
                }
            }
        }
        return dist[r - 1][c - 1];
    }
}
