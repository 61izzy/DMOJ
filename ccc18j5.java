import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj = new ArrayList[10001];
    static int n;
    static int min;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
            int m = scanner.nextInt();
            for (int j = 0; j < m; j++) {
                adj[i].add(scanner.nextInt());
            }
        }
        
        System.out.println(bfs() ? "Y" : "N");
        System.out.println(min);
    }
    public static boolean bfs() {
        int[] dist = new int[10001];
        dist[1] = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i : adj[curr]) {
                if (dist[i] == 0) {
                    dist[i] = dist[curr] + 1;
                    q.offer(i);
                }
            }
            if (adj[curr].size() == 0 && min == 0) {
                min = dist[curr];
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (dist[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
