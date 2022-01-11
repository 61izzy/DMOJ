import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr, dist;
    static int r, c;
    static char[][] grid;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        r = scanner.nextInt();
        c = scanner.nextInt();
        grid = new char[r][c];
        arr = new int[r][c];
        dist = new int[r][c];
        ArrayList<Pair> flood = new ArrayList<Pair>();
        Pair s = new Pair(-1, -1), e = new Pair(-1, -1);
        
        for (int i = 0; i < r; i++) {
            grid[i] = scanner.next().toCharArray();
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '*') flood.add(new Pair(i, j));
                else if (grid[i][j] == 'S') s = new Pair(i, j);
                else if (grid[i][j] == 'D') e = new Pair(i, j);
                arr[i][j] = dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (Pair p : flood) {
            bfs(p.x, p.y, arr);
            arr[e.x][e.y] = Integer.MAX_VALUE;
        }
        
        bfs(s.x, s.y, dist);
        System.out.println(dist[e.x][e.y] == Integer.MAX_VALUE ? "KAKTUS" : dist[e.x][e.y]);
    }
    public static void bfs(int x, int y, int[][] temp) {
        temp[x][y] = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.x, j = p.y;
            if (grid[i][j] == 'D') continue;
            if (i > 0 && grid[i - 1][j] != 'X' && temp[i][j] + 1 < arr[i - 1][j]) {
                temp[i - 1][j] = temp[i][j] + 1;
                arr[i - 1][j] = temp[i][j] + 1;
                q.offer(new Pair(i - 1, j));
            }
            if (j < c - 1 && grid[i][j + 1] != 'X' && temp[i][j] + 1 < arr[i][j + 1]) {
                temp[i][j + 1] = temp[i][j] + 1;
                arr[i][j + 1] = temp[i][j] + 1;
                q.offer(new Pair(i, j + 1));
            }
            if (i < r - 1 && grid[i + 1][j] != 'X' && temp[i][j] + 1 < arr[i + 1][j]) {
                temp[i + 1][j] = temp[i][j] + 1;
                arr[i + 1][j] = temp[i][j] + 1;
                q.offer(new Pair(i + 1, j));
            }
            if (j > 0 && grid[i][j - 1] != 'X' && temp[i][j] + 1 < arr[i][j - 1]) {
                temp[i][j - 1] = temp[i][j] + 1;
                arr[i][j - 1] = temp[i][j] + 1;
                q.offer(new Pair(i, j - 1));
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
