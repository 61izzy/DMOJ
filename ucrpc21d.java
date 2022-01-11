import java.io.*;
import java.util.*;

public class Main {
    static String[] grid;
    static boolean[][] vis;
    static int r, c;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        r = scanner.nextInt() * 2 + 1;
        c = scanner.nextInt() * 2 + 1;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        grid = new String[r];
        vis = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
            grid[i] = scanner.next();
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!vis[i][j] && grid[i].charAt(j) == '.') arr.add(bfs(i, j));
            }
        }
        
        Collections.sort(arr);
        
        for (int i = arr.size() - 1; i >= 0; i--) {
            System.out.print(i == arr.size() - 1 ? arr.get(i) : " " + arr.get(i));
        }
        System.out.println();
    }
    public static int bfs(int x, int y) {
        int area = 0;
        vis[x][y] = true;
        Queue<Integer> qx = new LinkedList<Integer>(), qy = new LinkedList<Integer>();
        qx.offer(x);
        qy.offer(y);
        while (!qx.isEmpty()) {
            int i = qx.poll(), j = qy.poll();
            if (i%2 == 1 && j%2 == 1) area++;
            if (i > 0 && !vis[i - 1][j] && grid[i - 1].charAt(j) == '.') {
                qx.offer(i - 1);
                qy.offer(j);
                vis[i - 1][j] = true;
            }
            if (j < c - 1 && !vis[i][j + 1] && grid[i].charAt(j + 1) == '.') {
                qx.offer(i);
                qy.offer(j + 1);
                vis[i][j + 1] = true;
            }
            if (i < r - 1 && !vis[i + 1][j] && grid[i + 1].charAt(j) == '.') {
                qx.offer(i + 1);
                qy.offer(j);
                vis[i + 1][j] = true;
            }
            if (j > 0 && !vis[i][j - 1] && grid[i].charAt(j - 1) == '.') {
                qx.offer(i);
                qy.offer(j - 1);
                vis[i][j - 1] = true;
            }
        }
        return area;
    }
}
