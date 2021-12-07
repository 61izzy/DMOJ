import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Edge>[] adj;
    static int[] dist;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        n = scanner.nextInt();
        m = scanner.nextInt();
        adj = new ArrayList[n + 1];
        dist = new int[n + 1];
    
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Edge>();
        }
        
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), w = scanner.nextInt();
            adj[x].add(new Edge(y, w));
            adj[y].add(new Edge(x, w));
        }
        
        getDist();
        for (int i = 1; i <= n; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }
    }
    public static void getDist() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(n,(a,b) -> a.value - b.value);
        q.offer(new Pair(1, 0));
        while (!q.isEmpty()) {
            int curr = q.poll().key;
            for (Edge v : adj[curr]) {
                if (dist[v.to] > dist[curr] + v.dist) {
                    dist[v.to] = dist[curr] + v.dist;
                    q.offer(new Pair(v.to, dist[v.to]));
                }
            }
        }
    }
}

class Edge {
    int to, dist;
    public Edge(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}

class Pair {
    int key, value;
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
