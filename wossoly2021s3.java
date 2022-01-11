import java.io.*;
import java.util.*;

public class Main {
    static char[][] grid;
    static int r, c;
    static Pair[] arr = new Pair[5], dir = {new Pair(-1, 0), new Pair(0, 1), new Pair(1, 0), new Pair(0, -1)};
    static HashMap<Character, Pair> t = new HashMap<Character, Pair>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        r = scanner.nextInt();
        c = scanner.nextInt();
        grid = new char[r][c];
        int sum = 0;
        boolean thing = true;
        
        for (int i = 0; i < r; i++) {
            grid[i] = scanner.next().toCharArray();
            for (int j = 0; j < c; j++) {
                if (grid[i][j] >= '0' && grid[i][j] <= '4') arr[grid[i][j] - '0'] = new Pair(i, j);
                else if (grid[i][j] >= 'a' && grid[i][j] <= 'z') t.put((char)(grid[i][j] - 32), new Pair(i, j));
            }
        }
        
        for (int i = 0; i < 4; i++) {
            int res = bfs(arr[i].x, arr[i].y, arr[i + 1].x, arr[i + 1].y);
            if (res == 0) thing = false;
            sum += res;
        }
        
        System.out.println(thing ? sum : -1);
    }
    public static int bfs(int x1, int y1, int x2, int y2) {
        int[][] dist = new int[r][c];
        Queue<Integer> qx = new LinkedList<Integer>(), qy = new LinkedList<Integer>();
        qx.offer(x1);
        qy.offer(y1);
        while (!qx.isEmpty()) {
            int i = qx.poll(), j = qy.poll();
            for (Pair p : dir) {
                if (i + p.x >= 0 && i + p.x < r && j + p.y >= 0 && j + p.y < c && dist[i + p.x][j + p.y] == 0 && (grid[i + p.x][j + p.y] == '.' || grid[i + p.x][j + p.y] >= '0' && grid[i + p.x][j + p.y] <= '4' || grid[i + p.x][j + p.y] >= 'A' && grid[i + p.x][j + p.y] <= 'Z')) {
                    if (grid[i + p.x][j + p.y] >= 'A' && grid[i + p.x][j + p.y] <= 'Z') {
                        int tx = t.get(grid[i + p.x][j + p.y]).x, ty = t.get(grid[i + p.x][j + p.y]).y;
                        dist[tx][ty] = dist[i][j] + 1;
                        qx.offer(tx);
                        qy.offer(ty);
                    }
                    else {
                        dist[i + p.x][j + p.y] = dist[i][j] + 1;
                        qx.offer(i + p.x);
                        qy.offer(j + p.y);
                    }
                }
            }
        }
        
        return dist[x2][y2];
    }
}

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
