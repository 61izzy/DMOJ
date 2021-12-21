import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj = new ArrayList[1001];
    static int n, dist[][] = new int[1001][1001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        int m = scanner.nextInt(), t = scanner.nextInt();
        
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            adj[a].add(b);
        }
        
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            System.out.println(dist[a][b] == 0 ? "Not enough hallways!" : dist[a][b] * t);
        }
    }
    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i : adj[curr]) {
                if (dist[x][i] == 0) {
                    dist[x][i] = dist[x][curr] + 1;
                    q.offer(i);
                }
            }
        }
    }
}
